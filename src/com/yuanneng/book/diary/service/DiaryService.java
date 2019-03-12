/*
 * @(#)UserLoginServer.java
 */
package com.yuanneng.book.diary.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.yuanneng.book.common.service.CommonService;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.diary.dao.IDiaryDao;
import com.yuanneng.book.diary.entity.DiaryBean;


/**
 * UserLoginServer.java
 * 
 * 功 能： UserLoginAction的service
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.04.13         shanjixiang        新规做成
 * </pre>
 */
public class DiaryService implements CommonService {

    /**
     * 日志
     */
    public static Logger logger = Logger.getLogger(DiaryService.class);

    /**
     * 注入的Dao层
     */
    @Resource
    private IDiaryDao iDiaryDao;
    private int endDay=0;
    
    public List<List<String>> getDay(int year,int month ) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month-1, 1);
        return getDay(calendar);
    }
    
    
    /**
     * 
     * @return
     */
    public List<List<String>> getDay(Calendar calendar) {
        
        int index = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DATE, (1 - index));
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        
        calendar.add(Calendar.MONTH, 1);
        index = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DATE, (-index));
        endDay = calendar.get(Calendar.DAY_OF_MONTH);
        
        List<List<String>> listDay = new ArrayList<List<String>>();
        List<String> listDayWeek = new ArrayList<String>();
        int m=1;
        while(m<=endDay) {
            listDayWeek = new ArrayList<String>();
        for(int i = 0;i<7;i++) {
            if(listDay.size() == 0) {
                if(i <week-1) {
                    listDayWeek.add("");
                }else {
                    listDayWeek.add(String.valueOf(m));
                    m++;
                }
            } else {
                if(m<=endDay) {
                    listDayWeek.add(String.valueOf(m));
                } else {
                    listDayWeek.add("");
                }
                
                m++;
            }
        }
        listDay.add(listDayWeek);
        }

        return listDay;
    }
    
    
//    public List<String> getHaveDiaryDayList(int year,int month,String userId) {
//        
//        DiaryBean condition = new DiaryBean();
//        
//        Calendar cl = Calendar.getInstance();
//        cl.set(year, month-1, endDay);
//        
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
//        
//        condition.setConditionDiaryTimeTo(sdf.format(cl.getTime()));
//        
//        cl.set(year, month-1, 1);
//        
//        condition.setConditionDiaryTimeFrom(sdf.format(cl.getTime()));
//        condition.setUserId(userId);
//        
//        return iDiaryDao.getHaveDiaryDayList(condition);
//    }
    
public Map<String,String> getTitleMap(int year,int month,String userId) {
        Map<String,String> titleMap = new HashMap<String,String>();
        DiaryBean condition = new DiaryBean();
        
        Calendar cl = Calendar.getInstance();
        cl.set(year, month-1, endDay);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
        
        condition.setConditionDiaryTimeTo(sdf.format(cl.getTime()));
        
        cl.set(year, month-1, 1);
        
        condition.setConditionDiaryTimeFrom(sdf.format(cl.getTime()));
        condition.setUserId(userId);
        
        List<DiaryBean> diaryBeans = iDiaryDao.getHaveDiaryDayList(condition);
        for(DiaryBean bean : diaryBeans) {
            titleMap.put(bean.getDiaryTime(), bean.getTitle());
        }
       return titleMap;
    }
    
    
    
    public int getHaveDiaryDayCnt(int year,int month, int day,String userId) {
        DiaryBean condition = new DiaryBean();
        
        Calendar cl = Calendar.getInstance();
        cl.set(year, month-1, day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
        condition.setDiaryTime(sdf.format(cl.getTime()));
        condition.setUserId(userId);
        return iDiaryDao.getHaveDiaryDayCnt(condition);
    }
    
    public List<DiaryBean> getDiary(int year,int month, int day,String userId) {
        DiaryBean condition = new DiaryBean();
        
        condition.setUserId(userId);
        List<DiaryBean> lst = iDiaryDao.getDiaryList(condition);
       
        
        return lst;
    }
    
    public void insertDiary(Calendar cl,String title, String content,String userId) {
        DiaryBean diaryBean = new DiaryBean();
        String diaryTime = new SimpleDateFormat("yyyy-MM-dd").format(cl.getTime());
        String id = BusinessUtils.getUUID();
        diaryBean.setId(id);
        diaryBean.setDiaryTime(diaryTime);
        diaryBean.setDiary(content);
        diaryBean.setTitle(title);
        diaryBean.setUserId(userId);
        iDiaryDao.insertDiary(diaryBean);
    }
    
    public void updateDiary(String id,String title, String content) {
        DiaryBean diaryBean = new DiaryBean();
        diaryBean.setId(id);
        diaryBean.setDiary(content);
        diaryBean.setTitle(title);
        iDiaryDao.updateDiary(diaryBean);
    }
    
    public void deleteDiary(String id) {
        iDiaryDao.deleteDiary(id);
    }
    
}
