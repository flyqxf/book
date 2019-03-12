/*
 * @(#)AdminLoginAction.java
 */
package com.yuanneng.book.manage.wenzhang.action;


import org.apache.commons.lang3.StringUtils;

import com.yuanneng.book.common.action.CommonAction;


public class WenzhangAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    private String id = null;
    private String selectedTab = null;
    private String url = null;
    /**
     * 主要逻辑方法
     * <p>
     * 编辑画面的输入值，调用service,处理service的返回结果
     * </p>
     * 
     * @return 处理结果
     * @exception 待定
     */
    @Override
    public String doMain() throws Exception {
         
        if(!StringUtils.isEmpty(id)) {
            selectedTab = "1";
            url = "../wenzhang/tab1Wenzhang.action?id="+id;
        }
        return SUCCESS;
        
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * @return the selectedTab
     */
    public String getSelectedTab() {
        return selectedTab;
    }
    
    /**
     * @param selectedTab the selectedTab to set
     */
    public void setSelectedTab(String selectedTab) {
        this.selectedTab = selectedTab;
    }
    
    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }
    
    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    
    
}
