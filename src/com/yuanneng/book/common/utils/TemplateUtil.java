package com.yuanneng.book.common.utils;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by 大数据pc01 on 2016/9/13.
 */
public class TemplateUtil {

    private final static String MODULE_PROPERTY_PREFIX = "module-";

    private static List<String> moduleRange = new ArrayList<String>();

    // module-servic=cloudera impala\:Catalog|StateStore|Daemon|Llama
    // ApplicationMaster,hdfs\:NameNode|SecondaryNameNode|DataNode|JournalNode|HttpFS|NFS
    // Gateway|KMS,hive\:HiveMetaStore|HiveServer2|WebHCat,mapreduce\:JobTracker|FailoverController|TaskTracker,yarn\:ResourceManager|JobHistory|NodeManager|ZooKeeper，zookeeper\:ZooKeeper,sqoop\:Sqoop
    // 按上例，逗号分隔的组件，组件名称为冒号前
    private static List<String> getModuleProperty(String property) {
        List<String> moduleNames = new ArrayList<String>();
        String[] modules = property.split(",");
        if (modules == null || modules.length == 0)
            return null;
        for (String module : modules) {
            String[] moduleSetting = module.split(":");
            if (moduleSetting != null && modules.length > 0)
                moduleNames.add(moduleSetting[0]);
        }
        return moduleNames;
    }

    static {
        Enumeration<String> moduleKeys = PropertyUtil.getPropertyNames(MODULE_PROPERTY_PREFIX);
        while (moduleKeys.hasMoreElements()) {
            String key = moduleKeys.nextElement();
            String value = PropertyUtil.getProperty(key);
            List<String> moduleNames = getModuleProperty(value);
            if (moduleNames != null && moduleNames.size() > 0)
                moduleRange.addAll(moduleNames);
        }
    }

    public static List<String> getModules() {
        return moduleRange;
    }
}
