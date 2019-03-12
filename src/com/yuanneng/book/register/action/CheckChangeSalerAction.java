/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.register.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.entity.UserValueObject;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.register.service.RegisterService;


/**
 * InitTaskAction.java
 * 
 * 功 能： 安全检测任务检索初期页面显示Action
 * 
 * <pre>
 * ver       修订日             作者          修订内容
 * ---------------------------------------------------
 * 1.0     2016.03.30         qinxiaofei      初期做成
 * </pre>
 */
public class CheckChangeSalerAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private String resJson = null;
    
    @Resource
    private RegisterService registerService;
    
    /**
     * 任务检索页面初期显示
     * <p>
     * 调用Servic取得需要从数据库获取的检索条件和任务检索结果
     * </p>
     * 
     * @return 处理结果 SUCCESS: 正常、ERROR: 异常
     * @exception 待定
     */
    @Override
    public String doMain() {
        HttpSession session = this.getSession();
        UserValueObject uvo = (UserValueObject) session.getAttribute(Constant.UVO);
        String userId = uvo.getUser().getUserId();
        
        resJson = registerService.getUserFlg(userId);

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
    
    

}
