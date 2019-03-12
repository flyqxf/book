/*
 * @(#)InitTaskAction.java
 */
package com.yuanneng.book.diary.action;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.entity.UserValueObject;
import com.yuanneng.book.common.utils.BusinessUtils;
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
public class InsertDiaryAction extends CommonAction {

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
    private List<String> haveDiaryDayList = null;
    private String year = null;
    private String month = null;
    private String day = null;
    private String title = null;
    private String content = null;
    
    
    /**
     * 返回值
     */
    private String resJson;
   
    /**
     *获取当月日期 
     */
    @Override
    public String doMain() {

        Calendar cl = Calendar.getInstance();
        int thisy = Integer.parseInt(year);
        int thism = Integer.parseInt(month);
        int thisd = Integer.parseInt(day);
        cl.set(thisy, thism-1, thisd);

        UserValueObject uvo = BusinessUtils.getUVO();
        String userId = uvo.getUser().getUserId();
        diaryService.insertDiary(cl,title,content,userId);
     // 设定JSON返回值
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", "success");
        map.put("msg", "日记录入成功");
     // 设定字符串返回值
        resJson = JSONObject.fromObject(map).toString();
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
