/*
 * @(#)UserLoginServer.java
 */
package com.yuanneng.book.prerson.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.yuanneng.book.common.service.CommonService;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.prerson.dao.IPersonDao;
import com.yuanneng.book.prerson.entity.AchievementBean;
import com.yuanneng.book.prerson.entity.AchievementSummaryBean;
import com.yuanneng.book.prerson.entity.AchievementSummaryListBean;
import com.yuanneng.book.prerson.entity.CountBean;
import com.yuanneng.book.prerson.entity.PersonBean;


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
public class PersonService implements CommonService {

    /**
     * 日志
     */
    public static Logger logger = Logger.getLogger(PersonService.class);

    /**
     * 注入的ISelectUserDao层
     */
    @Resource
    private IPersonDao iPersonDao;

    
    public PersonBean getPersion(String userId) {
        PersonBean pbean = iPersonDao.getPersion(userId);
        String receivables_flg = pbean.getReceivables_flg();
        if("1".equals(receivables_flg)) {
            pbean.setReceivables_flg_name("支付宝");
        } else if("2".equals(receivables_flg)){
            pbean.setReceivables_flg_name("微信");
        } else if("3".equals(receivables_flg)){
            pbean.setReceivables_flg_name("银行");
        }
        
        
         return pbean;
    }
    
    public void updatePersion(PersonBean personBean) {
        String id = BusinessUtils.getUUID();
        personBean.setId(id);
        iPersonDao.updatePersion(personBean);
        iPersonDao.insertHistory(personBean);
    }
    
    public AchievementSummaryBean getAchievementSummary(String userId) {
        AchievementSummaryBean achievementSummaryBean = new AchievementSummaryBean();
        
        List<AchievementSummaryListBean> lst =  iPersonDao.getAchievementSummary(userId);
        String moneySum_yi = "0";
        String moneySum_wei = "0";
        for(AchievementSummaryListBean bean:lst) {
            String pay_status = bean.getPay_status();
            String flg = bean.getFlg();
            
            if(pay_status.equals("0")) {
                if(flg.equals("1")) {
                    achievementSummaryBean.setMoneySum_zhi_wei(bean.getMoneySum());
                    achievementSummaryBean.setPersonSum_zhi_wei(bean.getPersonSum());
                } else {
                    achievementSummaryBean.setMoneySum_jian_wei(bean.getMoneySum());
                    achievementSummaryBean.setPersonSum_jian_wei(bean.getPersonSum());
                }
                //moneySum_wei = moneySum_wei+Integer.parseInt(bean.getMoneySum());
                moneySum_wei = new BigDecimal(moneySum_wei).add(new BigDecimal(bean.getMoneySum())).toString();
            } else {
                if(flg.equals("1")) {
                    achievementSummaryBean.setMoneySum_zhi_yi(bean.getMoneySum());
                    achievementSummaryBean.setPersonSum_zhi_yi(bean.getPersonSum());
                } else {
                    achievementSummaryBean.setMoneySum_jian_yi(bean.getMoneySum());
                    achievementSummaryBean.setPersonSum_jian_yi(bean.getPersonSum());
                }
                moneySum_yi = new BigDecimal(moneySum_yi).add(new BigDecimal(bean.getMoneySum())).toString();
            }
        }
        achievementSummaryBean.setMoneySum_yi(moneySum_yi);
        achievementSummaryBean.setMoneySum_wei(String.valueOf(moneySum_wei));
        
        return achievementSummaryBean;
    }

    public List<AchievementBean> getAchievement(String userId) {
        List<AchievementBean> list= iPersonDao.getAchievement(userId);
        for(AchievementBean bean:list) {
            if(bean.getPay_status().equals("1")) {
                bean.setPay_status_name("已支付");
            } else {
                bean.setPay_status_name("未支付");
            }
            if(bean.getFlg().equals("1")) {
                bean.setFlg_name("直接介绍");
            } else {
                bean.setFlg_name("间接介绍");
            }
        }
        
        return list;
    }
    public List<AchievementBean> getAchievements(AchievementBean achievementBean) {
        
        List<AchievementBean> list= iPersonDao.getAchievements(achievementBean);
        for(AchievementBean bean:list) {
            if(bean.getPay_status().equals("1")) {
                bean.setPay_status_name("已支付");
            } else {
                bean.setPay_status_name("未支付");
            }
            if(bean.getFlg().equals("1")) {
                bean.setFlg_name("直接介绍");
            } else {
                bean.setFlg_name("间接介绍");
            }
        }
        
        return list;
    }
    public List<CountBean> getCount(String userId) {
        List<CountBean> lst1= new ArrayList<CountBean>();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
        Calendar cl = Calendar.getInstance();
        cl.add(Calendar.MONTH, -6);
        for(int i=0;i<6;i++) {
            CountBean countBean = new CountBean();
            cl.add(Calendar.MONTH, 1);
            String year = sf.format(cl.getTime());
            countBean.setYear(year);
            int cnt = iPersonDao.getCount(userId,year,"1");
            countBean.setCount_zhi(String.valueOf(cnt));
            
            cnt = iPersonDao.getCount(userId,year,"2");
            countBean.setCount_jian(String.valueOf(cnt));
            lst1.add(countBean);
        }
        
        //List<CountBean> lst = iPersonDao.getCount(userId);
//        List<CountBean> lst1= new ArrayList<CountBean>();
//        Map<String,CountBean> map = new HashMap<String,CountBean>();
//        for(CountBean bean:lst) {
//            CountBean countBean = new CountBean();
//            String flg = bean.getFlg();
//            String year = bean.getYear();
//            if(map.containsKey(year)) {
//                countBean = map.get(year);
//            }
//            countBean.setYear(year);
//            if(flg.equals("1")) {
//                countBean.setCount_zhi(bean.getCount());
//            } else {
//                countBean.setCount_jian(bean.getCount());
//            }
//            map.put(year, countBean);
//        }
//        Iterator<Entry<String, CountBean>> it = map.entrySet().iterator();
//        while(it.hasNext()) {
//            CountBean countBean = it.next().getValue();
//            lst1.add(countBean);
//        }
        return lst1;
    }
    
    
}
