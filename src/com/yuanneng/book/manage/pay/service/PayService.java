/*
 * @(#)AdminUserLoginService.java
 */
package com.yuanneng.book.manage.pay.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;




import java.util.Map;

import javax.annotation.Resource;

import com.yuanneng.book.common.service.CommonService;
import com.yuanneng.book.manage.pay.dao.IPayDao;
import com.yuanneng.book.manage.pay.entity.PayBean;
import com.yuanneng.book.manage.pay.entity.PayBean1;
import com.yuanneng.book.manage.sale.entity.SaleBean;


public class PayService implements CommonService {


    /**
     * 注入的ISelectUserDao层
     */
    @Resource
    private IPayDao iPayDao;

    
    public List<PayBean1> getPayBean(PayBean1 bean) {
        
        List<PayBean1> payBeans = new ArrayList<PayBean1>();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cl = Calendar.getInstance();
        String date = sf.format(cl.getTime());
        List<PayBean> pb_dqs = iPayDao.getPayBean_zhijie_lst(bean.getUserId(),bean.getUserName(),date);
        
        //cl.add(Calendar.DAY_OF_MONTH, -7);
        cl.add(Calendar.DAY_OF_MONTH, -1);
        date = sf.format(cl.getTime());
        List<PayBean> pb_qqs = iPayDao.getPayBean_zhijie_lst(bean.getUserId(),bean.getUserName(),date);
        
        //cl.add(Calendar.DAY_OF_MONTH, -7);
        cl.add(Calendar.DAY_OF_MONTH, -1);
        date = sf.format(cl.getTime());
        List<PayBean> pb_qqqs = iPayDao.getPayBean_zhijie_lst(bean.getUserId(),bean.getUserName(),date);
        
        Map<String,PayBean1> mp = new HashMap<String,PayBean1>();
        
        PayBean1 pb_all = new PayBean1();
        for(PayBean pb : pb_dqs) {
            String userId = pb.getUserId();
            if(mp.containsKey(userId)) {
                pb_all = mp.get(userId);
            } else {
                pb_all = new PayBean1();
            }
            pb_all.setId_dq(pb.getId());
            pb_all.setPay_dq(pb.getPay());
            pb_all.setPaid_dq(pb.getPaid());
            pb_all.setUnpaid_dq(pb.getUnpaid());
            pb_all.setUserId(pb.getUserId());
            pb_all.setUserName(pb.getUserName());
            mp.put(userId, pb_all);
        }
        for(PayBean pb : pb_qqs) {
            String userId = pb.getUserId();
            if(mp.containsKey(userId)) {
                pb_all = mp.get(userId);
            } else {
                pb_all = new PayBean1();
            }
            pb_all.setId_qq(pb.getId());
            pb_all.setPay_qq(pb.getPay());
            pb_all.setPaid_qq(pb.getPaid());
            pb_all.setUnpaid_qq(pb.getUnpaid());
            pb_all.setUserId(pb.getUserId());
            pb_all.setUserName(pb.getUserName());
            mp.put(userId, pb_all);
        }
        for(PayBean pb : pb_qqqs) {
            String userId = pb.getUserId();
            if(mp.containsKey(userId)) {
                pb_all = mp.get(userId);
            } else {
                pb_all = new PayBean1();
            }
            pb_all.setId_qqq(pb.getId());
            pb_all.setPay_qqq(pb.getPay());
            pb_all.setPaid_qqq(pb.getPaid());
            pb_all.setUnpaid_qqq(pb.getUnpaid());
            pb_all.setUserId(pb.getUserId());
            pb_all.setUserName(pb.getUserName());
            mp.put(userId, pb_all);
        }
        
//        List<PayBean1> payB = iPayDao.getPayBean(bean);
//        Map<String,PayBean1> mp = new HashMap<String,PayBean1>();
//        int i = 0;
//        for(PayBean1 pb : payB) {
//            i++;
//            PayBean1 payBean  = new PayBean1();
//            String userId = pb.getUserId();
//            int unpaid_sum = 0;
//            if(mp.containsKey(userId)) {
//                payBean = mp.get(userId);
//                if(i == 2) {
//                    payBean.setPay_qq(String.valueOf(Integer.parseInt(pb.getPay_zhijie()) + Integer.parseInt(pb.getPay_jianjie())));
//                    payBean.setUnpaid_qq(String.valueOf(Integer.parseInt(pb.getUnpaid_zhijie()) + Integer.parseInt(pb.getUnpaid_jianjie())));
//                    unpaid_sum = Integer.parseInt(payBean.getUnpaid_summary()) + Integer.parseInt(payBean.getUnpaid_qq());
//                    payBean.setUnpaid_summary(String.valueOf(unpaid_sum));
//                } else if(i ==3) {
//                    payBean.setPay_qqq(String.valueOf(Integer.parseInt(pb.getPay_zhijie()) + Integer.parseInt(pb.getPay_jianjie())));
//                    payBean.setUnpaid_qqq(String.valueOf(Integer.parseInt(pb.getUnpaid_zhijie()) + Integer.parseInt(pb.getUnpaid_jianjie())));
//                    unpaid_sum = Integer.parseInt(payBean.getUnpaid_summary()) + Integer.parseInt(payBean.getUnpaid_qqq());
//                    payBean.setUnpaid_summary(String.valueOf(unpaid_sum));
//                }
//            } else {
//                i=1;
//                BeanUtils.copyProperties(pb, payBean);
//                payBean.setPay_dq(String.valueOf(Integer.parseInt(pb.getPay_zhijie()) + Integer.parseInt(pb.getPay_jianjie())));
//                payBean.setUnpaid_dq(String.valueOf(Integer.parseInt(pb.getUnpaid_zhijie()) + Integer.parseInt(pb.getUnpaid_jianjie())));
//                unpaid_sum = unpaid_sum + Integer.parseInt(payBean.getUnpaid_dq());
//                payBean.setUnpaid_summary(String.valueOf(unpaid_sum));
//            }
//            mp.put(userId, payBean);
//        }
        Collection<PayBean1> c = mp.values();
        payBeans.addAll(c);
        for(PayBean1 p : payBeans) {
//            int unpaid_qqq = Integer.parseInt(p.getUnpaid_qqq());
//            int unpaid_qq = Integer.parseInt(p.getUnpaid_qq());
//            int unpaid_dq = Integer.parseInt(p.getUnpaid_dq());
            p.setUnpaid_summary(new BigDecimal(p.getUnpaid_qqq()).add(new BigDecimal(p.getUnpaid_qq())).add(new BigDecimal(p.getUnpaid_dq())).toString());
        }
        payBeans = sort(payBeans);
        return payBeans;
    }
private List<PayBean1> sort(List<PayBean1> resList) {
        
        Collections.sort(resList, new Comparator<PayBean1>(){

            @Override
            public int compare(PayBean1 o1, PayBean1 o2) {

                int a = new BigDecimal(o1.getUnpaid_summary()).compareTo((new BigDecimal(o2.getUnpaid_summary())));
                return a;
            }
            
        });
        return resList;
};
public List<PayBean1> getPayBeanJianjie(PayBean1 bean) {
        
        List<PayBean1> payBeans = new ArrayList<PayBean1>();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cl = Calendar.getInstance();
        String date = sf.format(cl.getTime());
        List<PayBean> pb_dqs = iPayDao.getPayBean_jianjie_lst(bean.getUserId(),bean.getUserName(),date);
        
        cl.add(Calendar.DAY_OF_MONTH, -7);
        //cl.add(Calendar.DAY_OF_MONTH, -1);
        date = sf.format(cl.getTime());
        List<PayBean> pb_qqs = iPayDao.getPayBean_jianjie_lst(bean.getUserId(),bean.getUserName(),date);
        
        cl.add(Calendar.DAY_OF_MONTH, -7);
        //cl.add(Calendar.DAY_OF_MONTH, -1);
        date = sf.format(cl.getTime());
        List<PayBean> pb_qqqs = iPayDao.getPayBean_jianjie_lst(bean.getUserId(),bean.getUserName(),date);
        
        Map<String,PayBean1> mp = new HashMap<String,PayBean1>();
        
        PayBean1 pb_all = new PayBean1();
        for(PayBean pb : pb_dqs) {
            String userId = pb.getUserId();
            if(mp.containsKey(userId)) {
                pb_all = mp.get(userId);
            } else {
                pb_all = new PayBean1();
            }
            pb_all.setId_dq(pb.getId());
            pb_all.setPay_dq(pb.getPay());
            pb_all.setPaid_dq(pb.getPaid());
            pb_all.setUnpaid_dq(pb.getUnpaid());
            pb_all.setUserId(pb.getUserId());
            pb_all.setUserName(pb.getUserName());
            mp.put(userId, pb_all);
        }
        for(PayBean pb : pb_qqs) {
            String userId = pb.getUserId();
            if(mp.containsKey(userId)) {
                pb_all = mp.get(userId);
            } else {
                pb_all = new PayBean1();
            }
            pb_all.setId_qq(pb.getId());
            pb_all.setPay_qq(pb.getPay());
            pb_all.setPaid_qq(pb.getPaid());
            pb_all.setUnpaid_qq(pb.getUnpaid());
            pb_all.setUserId(pb.getUserId());
            pb_all.setUserName(pb.getUserName());
            mp.put(userId, pb_all);
        }
        for(PayBean pb : pb_qqqs) {
            String userId = pb.getUserId();
            if(mp.containsKey(userId)) {
                pb_all = mp.get(userId);
            } else {
                pb_all = new PayBean1();
            }
            pb_all.setId_qqq(pb.getId());
            pb_all.setPay_qqq(pb.getPay());
            pb_all.setPaid_qqq(pb.getPaid());
            pb_all.setUnpaid_qqq(pb.getUnpaid());
            pb_all.setUserId(pb.getUserId());
            pb_all.setUserName(pb.getUserName());
            mp.put(userId, pb_all);
        }
 
        Collection<PayBean1> c = mp.values();
        payBeans.addAll(c);
        for(PayBean1 p : payBeans) {

            p.setUnpaid_summary(new BigDecimal(p.getUnpaid_qqq()).add(new BigDecimal(p.getUnpaid_qq())).add(new BigDecimal(p.getUnpaid_dq())).toString());
        }
        payBeans = sort(payBeans);
        return payBeans;
    }
  
   
}
