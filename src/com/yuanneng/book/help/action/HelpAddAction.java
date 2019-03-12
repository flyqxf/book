/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.help.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.mysql.jdbc.StringUtils;
import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.entity.CommonPageLinksBean;
import com.yuanneng.book.common.entity.UserValueObject;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.common.utils.PropertyUtil;
import com.yuanneng.book.help.entity.HelpBean;
import com.yuanneng.book.help.service.HelpService;


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
public class HelpAddAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    
    
    private HelpBean helpBean = null;
    private String pro =null;
    private String city =null;
    private String pro_val =null;
    private String city_val =null;
    private String title =null;
    private String content =null;
    
    private String flg = null;
    /**
     * 返回值
     */
    private String resJson;
    
    
    private  List<HelpBean> helpBeans = null;
    private String indexProperty;
    /**
     * 注入的Servic层
     */
    @Resource
    private HelpService helpService=null;
    /**
     * 
     */
    @Override
    public String doMain() {
        
     // 设定JSON返回值
        Map<String, Object> map = new HashMap<String, Object>();
        
        if(StringUtils.isNullOrEmpty(title)) {
            map.put("status", "false");
            map.put("msg", "请输入问题标题");
        } else if(StringUtils.isNullOrEmpty(content)) {
            map.put("status", "false");
            map.put("msg", "请输入问题内容");
        } else {
        HelpBean helpBean = new HelpBean();
        helpBean.setCity(city);
        helpBean.setProvince(pro);
        helpBean.setCity_val(city_val);
        helpBean.setProvince_val(pro_val);
        helpBean.setTitle(title);
        helpBean.setContent(content);
        helpService.addHelp(helpBean);
        UserValueObject uvo = BusinessUtils.getUVO();
        String userId = uvo.getUser().getUserId();
        helpBeans = helpService.selectHelp(userId);
        CommonPageLinksBean<HelpBean> result = new CommonPageLinksBean<HelpBean>();
        indexProperty = Constant.STRING_ZERO;
        result.setResultList(helpBeans);
        result.setIndexProperty(indexProperty);
        result.setNumProperty(Integer.parseInt(result.getIndexProperty()));
        result.setRowProperty(PropertyUtil.getProperty(Constant.ROW));
        result.setTotalProperty(String.valueOf(helpBeans.size()));
        result.setEndProperty(BusinessUtils.getEndProperty(result));
        //
        /** 将结果放入session中 */
        HttpSession session = this.getSession();
        session.setAttribute(Constant.HELP_LIST, result);
        map.put("status", "success");
        map.put("msg", "问题录入成功");
        }
        // 设定字符串返回值
        resJson = JSONObject.fromObject(map).toString();
        return SUCCESS;

    }

    
    
    /**
     * @return the pro
     */
    public String getPro() {
        return pro;
    }


    
    /**
     * @param pro the pro to set
     */
    public void setPro(String pro) {
        this.pro = pro;
    }


    
    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }


    
    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }


    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }


    
    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }


    
    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }


    
    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }


    
    /**
     * @return the flg
     */
    public String getFlg() {
        return flg;
    }


    
    /**
     * @param flg the flg to set
     */
    public void setFlg(String flg) {
        this.flg = flg;
    }


    
    /**
     * @return the helpService
     */
    public HelpService getHelpService() {
        return helpService;
    }


    
    /**
     * @param helpService the helpService to set
     */
    public void setHelpService(HelpService helpService) {
        this.helpService = helpService;
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
     * @return the helpBeans
     */
    public List<HelpBean> getHelpBeans() {
        return helpBeans;
    }



    
    /**
     * @param helpBeans the helpBeans to set
     */
    public void setHelpBeans(List<HelpBean> helpBeans) {
        this.helpBeans = helpBeans;
    }



    /**
     * @return the helpBean
     */
    public HelpBean getHelpBean() {
        return helpBean;
    }



    
    /**
     * @param helpBean the helpBean to set
     */
    public void setHelpBean(HelpBean helpBean) {
        this.helpBean = helpBean;
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
     * @return the pro_val
     */
    public String getPro_val() {
        return pro_val;
    }



    
    /**
     * @param pro_val the pro_val to set
     */
    public void setPro_val(String pro_val) {
        this.pro_val = pro_val;
    }



    
    /**
     * @return the city_val
     */
    public String getCity_val() {
        return city_val;
    }



    
    /**
     * @param city_val the city_val to set
     */
    public void setCity_val(String city_val) {
        this.city_val = city_val;
    }
    


}
