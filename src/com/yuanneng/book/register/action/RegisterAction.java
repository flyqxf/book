/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.register.action;

import com.yuanneng.book.common.action.CommonAction;


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
public class RegisterAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

   
    
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


        return SUCCESS;

    }
    
    

}
