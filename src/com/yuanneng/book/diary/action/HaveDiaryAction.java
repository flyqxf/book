/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.diary.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.entity.UserValueObject;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.diary.entity.DiaryBean;
import com.yuanneng.book.diary.service.DiaryService;


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
public class HaveDiaryAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    /**
     * 注入的ISelectUserDao层
     */
    @Resource
    private DiaryService diaryService;
    private String year = null;
    private String month = null;
    private String day = null;
    private DiaryBean diaryBean = new DiaryBean();
    private int haveDiaryFlg = 0;
    
    private List<Object> resLst=new ArrayList<Object>();
   
    /**
     *获取当月日期 
     */
    @Override
    public String doMain() {

        int y = Integer.parseInt(year);
        int m = Integer.parseInt(month);
        int d = Integer.parseInt(day);
        UserValueObject uvo = BusinessUtils.getUVO();
        String userId = uvo.getUser().getUserId();
        haveDiaryFlg = diaryService.getHaveDiaryDayCnt(y,m,d,userId);
        if(haveDiaryFlg>0) {
            List<DiaryBean> diaryBeans = diaryService.getDiary(y,m,d,userId);
            HttpSession session = this.getSession();
            session.setAttribute(Constant.DIARY_LIST, diaryBeans);
            for(DiaryBean bean:diaryBeans) {
                Calendar cl = Calendar.getInstance();
                cl.set(y, m-1, d);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
                if(sdf.format(cl.getTime()).equals(bean.getDiaryTime())) {
                    diaryBean = bean;
                   
                }
            }
        }
        resLst.add(String.valueOf(haveDiaryFlg));
        resLst.add(diaryBean);
        return SUCCESS;

    }

    
    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    
    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    
    /**
     * @return the month
     */
    public String getMonth() {
        return month;
    }

    
    /**
     * @param month the month to set
     */
    public void setMonth(String month) {
        this.month = month;
    }

    
    /**
     * @return the day
     */
    public String getDay() {
        return day;
    }

    
    /**
     * @param day the day to set
     */
    public void setDay(String day) {
        this.day = day;
    }

    
    /**
     * @return the haveDiaryFlg
     */
    public int getHaveDiaryFlg() {
        return haveDiaryFlg;
    }

    
    /**
     * @param haveDiaryFlg the haveDiaryFlg to set
     */
    public void setHaveDiaryFlg(int haveDiaryFlg) {
        this.haveDiaryFlg = haveDiaryFlg;
    }


    
    /**
     * @return the resLst
     */
    public List<Object> getResLst() {
        return resLst;
    }


    
    /**
     * @param resLst the resLst to set
     */
    public void setResLst(List<Object> resLst) {
        this.resLst = resLst;
    }
    
}
