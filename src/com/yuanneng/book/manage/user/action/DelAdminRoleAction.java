/*
 * @(#)AdminLoginAction.java
 */
package com.yuanneng.book.manage.user.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.manage.user.service.UserService;


public class DelAdminRoleAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    @Resource
    private UserService userService = null;
    
    private String userId = null;
    
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
        
        userService.delAdminRole(userId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", "success");
        map.put("msg", "权限删除成功");
     // 设定字符串返回值
        resJson = JSONObject.fromObject(map).toString();
        
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
    
}
