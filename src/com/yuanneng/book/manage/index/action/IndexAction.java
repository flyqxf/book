/*
 * @(#)AdminLoginAction.java
 */
package com.yuanneng.book.manage.index.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.manage.index.entity.IndexBean;
import com.yuanneng.book.manage.index.entity.IndexDetailBean;
import com.yuanneng.book.manage.index.service.IndexService;


public class IndexAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    @Resource
    private IndexService indexService = null;
    
    private IndexBean indexBean = null;
    
    private String thisYear = null;
    
    private String lastYear = null;
    
    private List<IndexDetailBean> lastIndexDetail= new ArrayList<IndexDetailBean>();
    
    private List<IndexDetailBean> thisIndexDetail= new ArrayList<IndexDetailBean>();


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
       
        indexBean = indexService.getIndexBean();
        List<IndexDetailBean> indexDetail = indexService.getUsers();
        
        int i = 0;
        for(IndexDetailBean IndexDetailBean:indexDetail) {
            i++;
            if(i<14) {
                lastIndexDetail.add(IndexDetailBean);
            }else {
                thisIndexDetail.add(IndexDetailBean);
            }
            
        }
        Calendar cl = Calendar.getInstance();
        int thisY = cl.get(Calendar.YEAR);
        int lastY = thisY - 1;
        thisYear = String.valueOf(thisY);
        lastYear = String.valueOf(lastY);
        
        return SUCCESS;
        
    }


    
    /**
     * @return the indexBean
     */
    public IndexBean getIndexBean() {
        return indexBean;
    }


    
    /**
     * @param indexBean the indexBean to set
     */
    public void setIndexBean(IndexBean indexBean) {
        this.indexBean = indexBean;
    }

    
    
    
    /**
     * @return the lastIndexDetail
     */
    public List<IndexDetailBean> getLastIndexDetail() {
        return lastIndexDetail;
    }



    
    /**
     * @param lastIndexDetail the lastIndexDetail to set
     */
    public void setLastIndexDetail(List<IndexDetailBean> lastIndexDetail) {
        this.lastIndexDetail = lastIndexDetail;
    }



    
    /**
     * @return the thisIndexDetail
     */
    public List<IndexDetailBean> getThisIndexDetail() {
        return thisIndexDetail;
    }



    
    /**
     * @param thisIndexDetail the thisIndexDetail to set
     */
    public void setThisIndexDetail(List<IndexDetailBean> thisIndexDetail) {
        this.thisIndexDetail = thisIndexDetail;
    }



    /**
     * @return the thisYear
     */
    public String getThisYear() {
        return thisYear;
    }



    
    /**
     * @param thisYear the thisYear to set
     */
    public void setThisYear(String thisYear) {
        this.thisYear = thisYear;
    }



    
    /**
     * @return the lastYear
     */
    public String getLastYear() {
        return lastYear;
    }



    
    /**
     * @param lastYear the lastYear to set
     */
    public void setLastYear(String lastYear) {
        this.lastYear = lastYear;
    }
    
    
    
}
