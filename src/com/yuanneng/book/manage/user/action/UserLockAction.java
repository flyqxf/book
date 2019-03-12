/*
 * @(#)AdminLoginAction.java
 */
package com.yuanneng.book.manage.user.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.manage.user.entity.UserBean;
import com.yuanneng.book.manage.user.service.UserService;


public class UserLockAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    @Resource
    private UserService userService = null;

    private String userId=null;
    
    private String status = null;
    
    private String resJson;

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

        UserBean userBean = new UserBean();
        userBean.setUserId(userId);
        if("0".equals(status)) {
            userBean.setStatus("1");
        } else {
            userBean.setStatus("0");
        }
        userService.lockUser(userBean);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", "success");
        map.put("userId", userId);
        if("0".equals(status)) {
            map.put("msg", "账户冻结成功");
        } else {
            map.put("msg", "账户解锁成功");
        }
     // 设定字符串返回值
        resJson = JSONObject.fromObject(map).toString();
        
        return SUCCESS;
        
    }

    
    /**
     * @return the resJson
     */
    public String getResJson() {
        return resJson;
    }

    
    /**
     * @param resJson the resJson to set
     */
    public void setResJson(String resJson) {
        this.resJson = resJson;
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


    
    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }


    
    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
