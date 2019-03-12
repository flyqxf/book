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


public class UserPwdResetAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    @Resource
    private UserService userService = null;

    private String userId=null;
    
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
        Map<String, Object> map = new HashMap<String, Object>();
        UserBean userBean = new UserBean();
        userBean.setUserId(userId);
        try{
            userService.pwdReset(userBean);
        
            map.put("status", "success");
            map.put("msg", "密码重置成功");
        } catch (Exception e) {
            map.put("status", "failed");
            map.put("msg", "密码重置失败");
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


    
}
