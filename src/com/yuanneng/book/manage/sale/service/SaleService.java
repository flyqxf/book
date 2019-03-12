/*
 * @(#)AdminUserLoginService.java
 */
package com.yuanneng.book.manage.sale.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.yuanneng.book.common.service.CommonService;
import com.yuanneng.book.manage.sale.dao.ISaleDao;
import com.yuanneng.book.manage.sale.entity.ConditionBean;
import com.yuanneng.book.manage.sale.entity.SaleBean;


public class SaleService implements CommonService {


    /**
     * 注入的ISelectUserDao层
     */
    @Resource
    private ISaleDao iSaleDao;

    
    public List<SaleBean> getSaleBean(ConditionBean conditionBean) {
        
        List<SaleBean> saleBeans = new ArrayList<SaleBean>();
        List<SaleBean> saleB = iSaleDao.getSaleBean(conditionBean);
        Calendar cl = Calendar.getInstance();
        int y = cl.get(Calendar.YEAR);
        int m = cl.get(Calendar.MONTH)+1;
        String dangqi = "";
        if(m<10) {
            dangqi = y+"0"+m;
        } else {
            dangqi = y+""+m;
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String dangqi_zhijie = sf.format(cl.getTime());
        
        Map<String,SaleBean> mp = new HashMap<String,SaleBean>();
        for(SaleBean sale: saleB) {
            SaleBean sBean = new SaleBean();
            String userId = sale.getUserId();
            if(mp.containsKey(userId)) {
                sBean = mp.get(userId);
            } else {
                sBean.setUserId(sale.getUserId());
                sBean.setUserName(sale.getUserName());
                sBean.setRegister_time(sale.getRegister_time());

            }
            //直接推荐（累计）
            if("1".equals(sale.getFlg())) {
                if(dangqi_zhijie.equals(sale.getRegister_time())) {
                    sBean.setPersonThisMonth_zhijie(sBean.getPersonThisMonth_zhijie()+1);
                }
                sBean.setPersonSum_zhijie(sBean.getPersonSum_zhijie()+1);
            } else {
                if(dangqi.equals(sale.getYearMonth())) {
                    sBean.setPersonThisMonth_jianjie(sBean.getPersonThisMonth_jianjie()+1);
                }
                sBean.setPersonSum_jianjie(sBean.getPersonSum_jianjie()+1);
            }
            if(dangqi.equals(sale.getYearMonth())) {
                sBean.setPaySummary_thisMonth((new BigDecimal(sBean.getPaySummary_thisMonth()).add(new BigDecimal(sale.getPay())).toString()));
            }
            sBean.setPaySummary(new BigDecimal(sBean.getPaySummary()).add(new BigDecimal(sale.getPay())).toString());
            
            mp.put(userId, sBean);
        }
        
        Iterator<Entry<String, SaleBean>> it = mp.entrySet().iterator();
        
        String flg = conditionBean.getFlg();
        String personSumFrom= conditionBean.getPersonSumFrom();
        String personSumTo= conditionBean.getPersonSumTo();
        if(StringUtils.isEmpty(personSumFrom)) {
            personSumFrom = "0";
        }
        if(StringUtils.isEmpty(personSumTo)) {
            personSumTo = "0";
        }
        
       while(it.hasNext()) {
           Entry<String, SaleBean> en = it.next();
           SaleBean bean = en.getValue();
           int personSum_zhijie = bean.getPersonThisMonth_zhijie();
           int personSum_jianjie = bean.getPersonThisMonth_jianjie();
           int pSum = 0;
           if(StringUtils.isEmpty(flg)) {
               pSum = personSum_zhijie+personSum_jianjie;
           } else if("1".equals(flg)) {
               pSum = personSum_zhijie;
           } else if("2".equals(flg)) {
               pSum = personSum_jianjie;
           }
           if(!(personSumFrom.equals("0") &&personSumTo.equals("0") )) {
               if(pSum>=Integer.parseInt(personSumFrom) && pSum<=Integer.parseInt(personSumTo)) {
                   saleBeans.add(bean);
               }
           } else {
               saleBeans.add(bean);
           }
       }
        
        
        return saleBeans;
    }
  
   
}
