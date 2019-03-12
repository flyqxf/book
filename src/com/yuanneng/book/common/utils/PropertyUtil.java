package com.yuanneng.book.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PropertyUtil {

    private static Log log = LogFactory.getLog(PropertyUtil.class);

    public static final String DEFAULT_PROPERTY_FILE = "AllResources.properties";

    private static final String ADD_PROPERTY_PREFIX = "add.property.file.";

    private static final String PROPERTY_EXTENSION = ".properties";

    private static final String PACKAGE = "/config/";

    private static TreeMap<String, String> props = new TreeMap<String, String>();

    private static Set<String> files = new HashSet<String>();

    static {
        StringBuilder key = new StringBuilder();
        load(PACKAGE + DEFAULT_PROPERTY_FILE);
        if (props != null) {
            for (int i = 1;; i++) {
                key.setLength(0);
                key.append(ADD_PROPERTY_PREFIX);
                key.append(i);
                String path = getProperty(key.toString());
                if (path == null) {
                    break;
                }
                addPropertyFile(path);
            }
        }
        overrideProperties();
    }

    private static void load(String name) {
        Properties p = readPropertyFile(name);
        for (Map.Entry<Object, Object> e : p.entrySet()) {
            props.put((String) e.getKey(), (String) e.getValue());
        }
    }

    private static Properties readPropertyFile(String name) {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
        if (is == null) {
            is = PropertyUtil.class.getResourceAsStream("/" + name);
        }

        Properties p = new Properties();
        try {
            try {
                p.load(is);
                files.add(name);

            } catch (NullPointerException e) {
                System.err.println("!!! PANIC: Cannot load " + name + " !!!");
            } catch (IOException e) {
                System.err.println("!!! PANIC: Cannot load " + name + " !!!");
            }
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                log.error("", e);
            }
        }
        return p;
    }

    private static void overrideProperties() {
        Enumeration<String> enumeration = Collections.enumeration(props.keySet());
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = System.getProperty(name);
            if (value != null) {
                props.put(name, value);
            }
        }
    }

    public static synchronized void addPropertyFile(String name) {
        if (!name.endsWith(PROPERTY_EXTENSION)) {
            StringBuilder nameBuf = new StringBuilder();
            nameBuf.append(name);
            nameBuf.append(PROPERTY_EXTENSION);
            name = nameBuf.toString();
        }
        if (!files.contains(name)) {
            load(name);
        }
    }

    public static String getProperty(String key) {
        String result = props.get(key);

        if (result != null && result.equals("@" + key)) {
            return result;
        }
        if (result != null && result.startsWith("@@")) {
            return result.substring(1);
        }
        if (result != null && result.startsWith("@")) {
            result = getProperty(result.substring(1));
        }

        return result;
    }

    public static String getProperty(String key, String defaultValue) {
        String result = props.get(key);
        if (result == null) {
            return defaultValue;
        }
        return result;
    }

    public static Enumeration<String> getPropertyNames() {
        return Collections.enumeration(props.keySet());
    }

    public static Enumeration<String> getPropertyNames(String keyPrefix) {
        Map<String, String> map = props.tailMap(keyPrefix);
        Iterator<String> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            String name = iter.next();
            if (!name.startsWith(keyPrefix)) {
                return Collections.enumeration(props.subMap(keyPrefix, name).keySet());
            }
        }
        return Collections.enumeration(map.keySet());
    }

    public static Set<String> getPropertiesValues(String propertyName, String keyPrefix) {

        Properties localProps = loadProperties(propertyName);
        if (localProps == null) {
            return null;
        }

        Enumeration<String> keyEnum = getPropertyNames(localProps, keyPrefix);
        if (keyEnum == null) {
            return null;
        }

        return getPropertiesValues(localProps, keyEnum);
    }

    public static Enumeration<String> getPropertyNames(Properties localProps, String keyPrefix) {

        if (localProps == null || keyPrefix == null) {
            return null;
        }

        Collection<String> matchedNames = new ArrayList<String>();
        Enumeration<?> propNames = localProps.propertyNames();
        while (propNames.hasMoreElements()) {
            String name = (String) propNames.nextElement();
            if (name.startsWith(keyPrefix)) {
                matchedNames.add(name);
            }
        }
        return Collections.enumeration(matchedNames);
    }

    public static Set<String> getPropertiesValues(Properties localProps,
            Enumeration<String> propertyNames) {

        if (localProps == null || propertyNames == null) {
            return null;
        }

        Set<String> retSet = new HashSet<String>();
        while (propertyNames.hasMoreElements()) {
            retSet.add(localProps.getProperty(propertyNames.nextElement()));
        }
        return retSet;
    }

    public static Properties loadProperties(String propertyName) {
        if (propertyName == null || "".equals(propertyName)) {
            return null;
        }
        Properties retProps = new Properties();

        StringBuilder resourceName = new StringBuilder();
        resourceName.append(propertyName);
        if (!propertyName.endsWith(PROPERTY_EXTENSION)) {
            resourceName.append(PROPERTY_EXTENSION);
        }

        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(resourceName.toString());
        if (is == null) {
            is = PropertyUtil.class.getResourceAsStream("/" + propertyName + PROPERTY_EXTENSION);
        }

        try {
            retProps.load(is);
        } catch (NullPointerException npe) {
            log.warn("*** Can not find property-file [" + propertyName + ".properties] ***", npe);
            retProps = null;
        } catch (IOException ie) {
            log.error("", ie);
            retProps = null;
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ie) {
                log.error("", ie);
                retProps = null;
            }
        }
        return retProps;
    }
}
