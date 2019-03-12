/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.manage.wenzhang.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.entity.CommonPageLinksBean;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.PropertyUtil;
import com.yuanneng.book.manage.wenzhang.entity.WenzhangBean;



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
public class WenzhangPageLinkAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 起点数据编号
     */
    private List<WenzhangBean> wenzhangList = null;
    private WenzhangBean bean = null;
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

        HttpSession session = this.getSession();
        
        bean = (WenzhangBean) session.getAttribute("wenzhangCondition");
        
        @SuppressWarnings("unchecked")
        CommonPageLinksBean<WenzhangBean> result = (CommonPageLinksBean<WenzhangBean>) session.getAttribute("wenzhangList");
        if (StringUtils.isEmpty(indexProperty)) {
            indexProperty = Constant.STRING_ZERO;
        }
//        result.setResultList(users);
        result.setIndexProperty(indexProperty);
        result.setNumProperty(Integer.parseInt(result.getIndexProperty()));
        result.setRowProperty(PropertyUtil.getProperty(Constant.ROW));
//        result.setTotalProperty(String.valueOf(users.size()));
        result.setEndProperty(BusinessUtils.getEndProperty(result));
        

        session.setAttribute("wenzhangList", result);
        

        return SUCCESS;

    }

    
    /**
     * @return the indexProperty
     */
    public String getIndexProperty() {
        return indexProperty;
    }

    
    /**
     * @param indexProperty the indexProperty to set
     */
    public void setIndexProperty(String indexProperty) {
        this.indexProperty = indexProperty;
    }


    
    /**
     * @return the wenzhangList
     */
    public List<WenzhangBean> getWenzhangList() {
        return wenzhangList;
    }


    
    /**
     * @param wenzhangList the wenzhangList to set
     */
    public void setWenzhangList(List<WenzhangBean> wenzhangList) {
        this.wenzhangList = wenzhangList;
    }


    
    /**
     * @return the bean
     */
    public WenzhangBean getBean() {
        return bean;
    }


    
    /**
     * @param bean the bean to set
     */
    public void setBean(WenzhangBean bean) {
        this.bean = bean;
    }
    

}
