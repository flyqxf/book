package com.yuanneng.book.common.filter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class ParameterTrimmedHttpServletRequest extends HttpServletRequestWrapper {

    private String trimPattern;

    public ParameterTrimmedHttpServletRequest(HttpServletRequest request, String trimPattern) {
        super(request);
        this.trimPattern = trimPattern;
    }

    @Override
    public final String getParameter(String name) {
        String value = super.getParameter(name);
        return trim(value);
    }

    @Override
    public final String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (values == null) {
            return null;
        }
        String[] trimmedValues = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            trimmedValues[i] = trim(values[i]);
        }
        return trimmedValues;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public final Map getParameterMap() {
        Map<String, String[]> map = super.getParameterMap();
        if (map == null) {
            return null;
        }
        Map<String, String[]> trimmedMap = new HashMap<String, String[]>();
        Iterator<String> it = map.keySet().iterator();
        String[] trimmedValues = null;
        while (it.hasNext()) {
            String key = it.next();
            String[] values = map.get(key);
            if (values != null) {
                trimmedValues = new String[values.length];
                for (int i = 0; i < values.length; i++) {
                    trimmedValues[i] = trim(values[i]);
                }
            }
            trimmedMap.put(key, trimmedValues);
        }
        return trimmedMap;
    }

    protected final String trim(String value) {
        if (value == null) {
            return null;
        }
        return value.replaceAll(this.trimPattern, "");
    }
}
