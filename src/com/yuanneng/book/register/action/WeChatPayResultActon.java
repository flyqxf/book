/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.register.action;

import com.yuanneng.book.common.action.CommonAction;


public class WeChatPayResultActon extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    private String code = null;
    private String msg = null;
    private String userId =null;
    
    @Override
    public String doMain() throws Exception {
        
        if("1".equals(code)) {
            msg="支付成功";
        } else if("2".equals(code)) {
            msg="支付失败";
        }
        
        return SUCCESS;
    }

    
    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    
    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }


    
    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }


    
    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
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
