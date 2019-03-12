package com.yuanneng.book.common.utils;

import java.util.Hashtable;
import java.util.Map;

/**
 * pwActiveUtil.java
 * 
 * 功 能： 密码激活用
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.05.18         梅琼            新规做成
 * </pre>
 */
public class PwActiveUtil {

    /**
     * 保存用户名称和checkId用的集合(key:id,value:用户名称)
     */
    private Hashtable<String, String> activeMap = new Hashtable<String, String>();

    public void remove(String id) {
        activeMap.remove(id);
    }

    public String getValue(String id) {
        return activeMap.get(id);
    }

    public void add(String id, String userName) {
        for (Map.Entry<String, String> entry : activeMap.entrySet()) {
            if (userName.equals(entry.getValue())) {
                activeMap.remove(entry.getKey());
            }
            break;
        }
        activeMap.put(id, userName);
    }
}
