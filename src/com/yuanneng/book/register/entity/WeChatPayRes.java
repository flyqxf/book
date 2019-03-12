/*
 * @(#)BookBean.java
 */
package com.yuanneng.book.register.entity;
import java.util.concurrent.ConcurrentHashMap;

import com.yuanneng.book.common.entity.CommonBean;

/**
 * UserBean.java
 * 
 * 功 能： 用户信息bean
 * 
 * <pre>
 * ver      修订日              作者            修订内容
 * -----------------------------------------------------
 * 1.0     2016.08.21         guot        新规做成
 * </pre>
 */
public class WeChatPayRes extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    private static WeChatPayRes weChatPayRes = null;

    private WeChatPayRes(){
        
    }
    private static ConcurrentHashMap<String, String> resIdMap = new ConcurrentHashMap<String, String>();
    
    public static WeChatPayRes getSingle() {
        if (weChatPayRes == null) {
            weChatPayRes = new WeChatPayRes();
        }
        return weChatPayRes;
    }
    public void setSts(String out_trade_no, String sts) {
        synchronized (weChatPayRes) {
            resIdMap.put(out_trade_no, sts);
        }

    }
    public String getSts(String out_trade_no) {
        return resIdMap.get(out_trade_no);
    }
    
    public void removeTrade(String out_trade_no) {
        synchronized (weChatPayRes) {
            resIdMap.remove(out_trade_no);
        }
    }
    
}
