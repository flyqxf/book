/*
 * @(#)AdminLoginAction.java
 */
package com.yuanneng.book.manage.user.action;

import com.yuanneng.book.common.action.CommonAction;


public class UserDetailAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private String userId=null;


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

        return SUCCESS;
        
    }

    
    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }


    
    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

 
}
