/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.diary.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.entity.UserValueObject;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;
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
public class PreCalendarAction extends CommonAction {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    /**
     * 注入的ISelectUserDao层
     */
    @Resource
    private DiaryService diaryService;
    private List<List<String>> dayList = null;
    private Map<String,String> diaryTitle = null;
    private String year = null;
    private String month = null;
    private List<String> haveDiaryDayList = null;
   
    /**
     *获取当月日期 
     */
    @Override
    public String doMain() {

        Calendar cl = Calendar.getInstance();
        HttpSession session = this.getSession();
        session.setAttribute(Constant.DIARY_TODAY_YEAR, cl.get(Calendar.YEAR));
        session.setAttribute(Constant.DIARY_TODAY_MONTH, cl.get(Calendar.MONTH)+1);
        session.setAttribute(Constant.DIARY_TODAY_DAY, cl.get(Calendar.DAY_OF_MONTH));
        int thisy = Integer.parseInt(year);
        int thism = Integer.parseInt(month);
        cl.set(thisy, thism-1, 1);
        cl.add(Calendar.MONTH, -1);
        int y = cl.get(Calendar.YEAR);
        int m = cl.get(Calendar.MONTH)+1;
        
        year = String.valueOf(y);
        month = String.valueOf(m);
        
        dayList = diaryService.getDay(cl);
        UserValueObject uvo = BusinessUtils.getUVO();
        String userId = uvo.getUser().getUserId();
        //getHaveDiaryDay(y,m);
        
        diaryTitle = diaryService.getTitleMap(y,m,userId);
        Iterator<String> it = diaryTitle.keySet().iterator();
        haveDiaryDayList = new ArrayList<String>();
        while(it.hasNext()) {
            haveDiaryDayList.add(it.next());
        }
        session.setAttribute(Constant.DIARY_YEAR, year);
        session.setAttribute(Constant.DIARY_MONTH, month);
        return SUCCESS;

    }
    
    
    /**
     * @return the dayList
     */
    public List<List<String>> getDayList() {
        return dayList;
    }

    
    /**
     * @param dayList the dayList to set
     */
    public void setDayList(List<List<String>> dayList) {
        this.dayList = dayList;
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
     * @return the haveDiaryDayList
     */
    public List<String> getHaveDiaryDayList() {
        return haveDiaryDayList;
    }
    
    /**
     * @param haveDiaryDayList the haveDiaryDayList to set
     */
    public void setHaveDiaryDayList(List<String> haveDiaryDayList) {
        this.haveDiaryDayList = haveDiaryDayList;
    }
    
    /**
     * @return the diaryTitle
     */
    public Map<String, String> getDiaryTitle() {
        return diaryTitle;
    }
    
    /**
     * @param diaryTitle the diaryTitle to set
     */
    public void setDiaryTitle(Map<String, String> diaryTitle) {
        this.diaryTitle = diaryTitle;
    }
    
    

}
