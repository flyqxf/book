package com.yuanneng.book.common.utils;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;


public class UserSessionMap {
    private static ConcurrentHashMap<String, HttpSession> sessionMap = null;
    private static UserSessionMap userSessionMap = null;
    
    private UserSessionMap() {
        if(sessionMap == null) {
            sessionMap = new ConcurrentHashMap<String, HttpSession>();
        }
    }
    
    public static UserSessionMap getSingle() {
        if(userSessionMap == null) {
            userSessionMap = new UserSessionMap();
        }
        return userSessionMap;
    }

    
    /**
     * @return the sessionMap
     */
    public ConcurrentHashMap<String, HttpSession> getSessionMap() {
        return sessionMap;
    }

    
    /**
     * @param sessionMap the sessionMap to set
     */
    public void setSessionMap(ConcurrentHashMap<String, HttpSession> sessionMap) {
        UserSessionMap.sessionMap = sessionMap;
    }
    
    
}
