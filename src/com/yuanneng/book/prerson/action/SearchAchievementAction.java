/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.prerson.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.entity.CommonPageLinksBean;
import com.yuanneng.book.common.entity.UserValueObject;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.PropertyUtil;
import com.yuanneng.book.prerson.entity.AchievementBean;
import com.yuanneng.book.prerson.entity.PersonBean;
import com.yuanneng.book.prerson.service.PersonService;


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
public class SearchAchievementAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
   
    private  AchievementBean achievementBean = null;
    private  List<AchievementBean> achievementBeans = null;
    private PersonBean personBean = null;
    /**
     * 注入的Servic层
     */
    @Resource
    private PersonService personService=null;
    
    /**
     * 起点数据编号
     */
    private String indexProperty;
    /**
     * 
     */
    @Override
    public String doMain() {
        if(achievementBean ==null) {
            achievementBean = new AchievementBean();
        }
        UserValueObject uvo = BusinessUtils.getUVO();
        
        String userId = uvo.getUser().getUserId();
        personBean = personService.getPersion(userId);
        achievementBean.setUserId(userId);
        
        achievementBeans=personService.getAchievements(achievementBean);
        
        CommonPageLinksBean<AchievementBean> result = new CommonPageLinksBean<AchievementBean>();
        indexProperty = Constant.STRING_ZERO;
        result.setResultList(achievementBeans);
        result.setIndexProperty(indexProperty);
        result.setNumProperty(Integer.parseInt(result.getIndexProperty()));
        result.setRowProperty(PropertyUtil.getProperty(Constant.ROW));
        result.setTotalProperty(String.valueOf(achievementBeans.size()));
        result.setEndProperty(BusinessUtils.getEndProperty(result));
        //
        /** 将结果放入session中 */
        HttpSession session = this.getSession();
        session.setAttribute(Constant.ACHIEVEMENT_LIST, result);
        session.setAttribute(Constant.ACHIEVEMENT_CONDITION, achievementBean);
        
        return SUCCESS;

    }
    
    /**
     * @return the achievementBeans
     */
    public List<AchievementBean> getAchievementBeans() {
        return achievementBeans;
    }
    
    /**
     * @param achievementBeans the achievementBeans to set
     */
    public void setAchievementBeans(List<AchievementBean> achievementBeans) {
        this.achievementBeans = achievementBeans;
    }

    
    /**
     * @return the achievementBean
     */
    public AchievementBean getAchievementBean() {
        return achievementBean;
    }

    
    /**
     * @param achievementBean the achievementBean to set
     */
    public void setAchievementBean(AchievementBean achievementBean) {
        this.achievementBean = achievementBean;
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
     * @return the personBean
     */
    public PersonBean getPersonBean() {
        return personBean;
    }

    
    /**
     * @param personBean the personBean to set
     */
    public void setPersonBean(PersonBean personBean) {
        this.personBean = personBean;
    }
    
   
   

}
