/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.advice.action;

import java.util.List;

import javax.annotation.Resource;







import javax.servlet.http.HttpSession;

import com.yuanneng.book.advice.entity.AdviceBean;
import com.yuanneng.book.advice.service.AdvieService;
import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.entity.CommonPageLinksBean;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.PropertyUtil;


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
public class AdviceAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    /**
     * 注入的ISelectUserDao层
     */
    @Resource
    private AdvieService advieService;
 
    private List <AdviceBean> adviceTopics = null;
    
    /**
     * 起点数据编号
     */
    private String indexProperty;

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

        adviceTopics =  advieService.getAdviceTopic();
        
        CommonPageLinksBean<AdviceBean> result = new CommonPageLinksBean<AdviceBean>();
        indexProperty = Constant.STRING_ZERO;
        result.setResultList(adviceTopics);
        result.setIndexProperty(indexProperty);
        result.setNumProperty(Integer.parseInt(result.getIndexProperty()));
        result.setRowProperty(PropertyUtil.getProperty(Constant.ROW));
        result.setTotalProperty(String.valueOf(adviceTopics.size()));
        result.setEndProperty(BusinessUtils.getEndProperty(result));
        //
        /** 将结果放入session中 */
        HttpSession session = this.getSession();
        session.setAttribute(Constant.ADVICE_LIST, result);
        

        return SUCCESS;

    }

   
    /**
     * @return the adviceTopics
     */
    public List<AdviceBean> getAdviceTopics() {
        return adviceTopics;
    }

    
    /**
     * @param adviceTopics the adviceTopics to set
     */
    public void setAdviceTopics(List<AdviceBean> adviceTopics) {
        this.adviceTopics = adviceTopics;
    }

    
 

}
