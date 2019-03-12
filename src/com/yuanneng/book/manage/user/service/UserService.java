/*
 * @(#)AdminUserLoginService.java
 */
package com.yuanneng.book.manage.user.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import com.yuanneng.book.common.service.CommonService;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.manage.pay.dao.IPayDao;
import com.yuanneng.book.manage.pay.entity.PayBean;
import com.yuanneng.book.manage.pay.entity.PayBean1;
import com.yuanneng.book.manage.systemInfo.dao.ISystemInfoDao;
import com.yuanneng.book.manage.systemInfo.entity.SystemInfoBean;
import com.yuanneng.book.manage.user.dao.IUserDao;
import com.yuanneng.book.manage.user.entity.UserBean;
import com.yuanneng.book.manage.user.entity.UserJianjieXiaoshouBean;
import com.yuanneng.book.manage.user.entity.UserXiaoshouBean;


public class UserService implements CommonService {


    /**
     * 注入的ISelectUserDao层
     */
    @Resource
    private IUserDao iUserDao;
    @Resource
    private ISystemInfoDao iSystemInfoDao;
    @Resource
    private IPayDao iPayDao;

    /**
     * 推荐会员信息
     * @param bean
     * @return
     */
    public List<UserXiaoshouBean> getTuijianUsers(UserXiaoshouBean bean) {
        List<UserXiaoshouBean> userXiaoshou =  iUserDao.getTuijianUsers(bean);
        for(UserXiaoshouBean xiaoshouBean :userXiaoshou) {
            String pay_status = xiaoshouBean.getPay_status();
            if("0".equals(pay_status)) {
                xiaoshouBean.setPay_status_name("未支付");
            } else if("1".equals(pay_status)) {
                xiaoshouBean.setPay_status_name("已支付");
            } else {
                xiaoshouBean.setPay_status_name(pay_status);
            }
        }
        
        
        return userXiaoshou;
    }
    
    public List<UserJianjieXiaoshouBean> getJianjieUsers(UserXiaoshouBean bean) {
        List<UserJianjieXiaoshouBean> jianjieXiaoshou = new ArrayList<UserJianjieXiaoshouBean>();
        
        Map<String,UserJianjieXiaoshouBean> mp = new HashMap<String,UserJianjieXiaoshouBean>();
        List<UserXiaoshouBean> userXiaoshou =  iUserDao.getTuijianUsers(bean);
        for(UserXiaoshouBean xiaoshouBean:userXiaoshou) {
            
           
            
            UserJianjieXiaoshouBean jianjieBean = new UserJianjieXiaoshouBean();
            String regUserId = xiaoshouBean.getUserId();
            if(mp.containsKey(regUserId)) {
                jianjieBean = mp.get(regUserId);
                String paySum = jianjieBean.getPaySum();
                String xiaoshouPersonSum = jianjieBean.getXiaoshouPersonSum();
                jianjieBean.setPaySum(new BigDecimal(paySum).add(new BigDecimal(xiaoshouBean.getPay())).toString());
                jianjieBean.setXiaoshouPersonSum(String.valueOf(Integer.parseInt(xiaoshouPersonSum)+1));
            } else {
                String pay_status = xiaoshouBean.getPay_status();
                if("0".equals(pay_status)) {
                    xiaoshouBean.setPay_status_name("未支付");
                } else if("1".equals(pay_status)) {
                    xiaoshouBean.setPay_status_name("已支付");
                } else {
                    xiaoshouBean.setPay_status_name(pay_status);
                }
                BeanUtils.copyProperties(xiaoshouBean, jianjieBean);
                jianjieBean.setPaySum(xiaoshouBean.getPay());
                jianjieBean.setXiaoshouPersonSum("1");
            }
            mp.put(regUserId, jianjieBean);
        }
        
        Collection<UserJianjieXiaoshouBean> c = mp.values();
        jianjieXiaoshou.addAll(c);
        //jianjieXiaoshou = (List<UserJianjieXiaoshouBean>) mp.values();
        return jianjieXiaoshou;
    }
    
    public List<UserBean> getUsers(UserBean bean) {
        
        List<UserBean> users = iUserDao.getUsers(bean);
        for(UserBean userBean:users) {
            //会员类型设定
            String user_flg = userBean.getUser_flg();
            if(user_flg.equals("0")) {
                userBean.setUser_flg_name("管理员");
            }else if(user_flg.equals("1")) {
                userBean.setUser_flg_name("会员");
            } else {
                userBean.setUser_flg_name("销售");
            }
            //收款账号设定
            String receivables_flg = userBean.getReceivables_flg();
            if("1".equals(receivables_flg)) {
                userBean.setReceivables_flg_name("支付宝");
                userBean.setZhanghao(userBean.getId_zhifubao());
            } else if("2".equals(receivables_flg)) {
                userBean.setReceivables_flg_name("微信");
                userBean.setZhanghao(userBean.getId_weixin());
            } else if("3".equals(receivables_flg)) {
                userBean.setReceivables_flg_name(userBean.getBank());
                userBean.setZhanghao(userBean.getBank_card_number());
            }
            //状态设置
            String status = userBean.getStatus();
            if("1".equals(status)) {
                userBean.setStatus_name("锁定");
            } else {
                userBean.setStatus_name("正常");
            }
        }
        
        return users;
    }
    
    public void lockUser(UserBean bean) {
        iUserDao.lockUser(bean);
    }
    
    public void pwdReset(UserBean bean) throws Exception {
        SystemInfoBean systemInfoBean = new SystemInfoBean();
        systemInfoBean.setName("初始密码");
        
        String pwd = "999999999";
       List<SystemInfoBean> systemInfos = iSystemInfoDao.getSystemInfo(systemInfoBean);
       if(systemInfos != null && systemInfos.size() > 0) {
           pwd = systemInfos.get(0).getValue();
       }
       pwd = BusinessUtils.getPasswordMD5(pwd);
       
       bean.setUserPassword(pwd);
       
        iUserDao.resetPwd(bean);
    }
    
public List<PayBean1> getPayBean(PayBean1 bean) {
        
        List<PayBean1> payBeans = new ArrayList<PayBean1>();
        List<PayBean1> payB = iPayDao.getPayBean(bean);
        Map<String,PayBean1> mp = new HashMap<String,PayBean1>();
        int i = 0;
        int pay_summary = 0;
        for(PayBean1 pb : payB) {
            i++;
            pay_summary = pay_summary + Integer.parseInt(pb.getPay_zhijie()) +Integer.parseInt(pb.getPay_jianjie()); 
            PayBean1 payBean  = new PayBean1();

            String userId = pb.getUserId();
            if(mp.containsKey(userId)) {
                payBean = mp.get(userId);
                if(i == 2) {
                    payBean.setPay_qq(String.valueOf(Integer.parseInt(pb.getPay_zhijie()) + Integer.parseInt(pb.getPay_jianjie())));
                    payBean.setUnpaid_qq(String.valueOf(Integer.parseInt(pb.getUnpaid_zhijie()) + Integer.parseInt(pb.getUnpaid_jianjie())));
                    payBean.setPersonSum_Summary_qq(String.valueOf(Integer.parseInt(pb.getPersonSum_zhijie())+Integer.parseInt(pb.getPersonSum_jianjie())));
                    
                    payBean.setPay_qq_zhijie(pb.getPay_zhijie());
                    payBean.setPay_qq_jianjie(pb.getPay_jianjie());
                    payBean.setUnpaid_qq_zhijie(pb.getUnpaid_zhijie());
                    payBean.setUnpaid_qq_jianjie(pb.getUnpaid_jianjie());
                    
                    payBean.setId_qq(pb.getId());
                    
                } else if(i ==3) {
                    payBean.setPay_qqq(String.valueOf(Integer.parseInt(pb.getPay_zhijie()) + Integer.parseInt(pb.getPay_jianjie())));
                    payBean.setUnpaid_qqq(String.valueOf(Integer.parseInt(pb.getUnpaid_zhijie()) + Integer.parseInt(pb.getUnpaid_jianjie())));
                    payBean.setPersonSum_Summary_qqq(String.valueOf(Integer.parseInt(pb.getPersonSum_zhijie())+Integer.parseInt(pb.getPersonSum_jianjie())));
                    
                    payBean.setPay_qqq_zhijie(pb.getPay_zhijie());
                    payBean.setPay_qqq_jianjie(pb.getPay_jianjie());
                    payBean.setUnpaid_qqq_zhijie(pb.getUnpaid_zhijie());
                    payBean.setUnpaid_qqq_jianjie(pb.getUnpaid_jianjie());
                    
                    payBean.setId_qqq(pb.getId());
                }
                
            } else {
                i=1;
                BeanUtils.copyProperties(pb, payBean);
                
                payBean.setPay_dq(String.valueOf(Integer.parseInt(pb.getPay_zhijie()) + Integer.parseInt(pb.getPay_jianjie())));
                payBean.setUnpaid_dq(String.valueOf(Integer.parseInt(pb.getUnpaid_zhijie()) + Integer.parseInt(pb.getUnpaid_jianjie())));
                payBean.setPersonSum_Summary_dq(String.valueOf(Integer.parseInt(pb.getPersonSum_zhijie())+Integer.parseInt(pb.getPersonSum_jianjie())));
                
                payBean.setPay_dq_zhijie(pb.getPay_zhijie());
                payBean.setPay_dq_jianjie(pb.getPay_jianjie());
                payBean.setUnpaid_dq_zhijie(pb.getUnpaid_zhijie());
                payBean.setUnpaid_dq_jianjie(pb.getUnpaid_jianjie());
                
                payBean.setId_dq(pb.getId());
                
                
            }
            payBean.setPay_summary(String.valueOf(pay_summary));
            mp.put(userId, payBean);
        }
        Collection<PayBean1> c = mp.values();
        payBeans.addAll(c);
        
        return payBeans;
    }



    public List<PayBean> getPayBean_Zhijie(String userId) {
    
    List<PayBean> payBeans = new ArrayList<PayBean>();
//    List<PayBean1> payB = iPayDao.getPayBean(bean);
//    Map<String,PayBean1> mp = new HashMap<String,PayBean1>();
//    int i = 0;
//    int pay_summary = 0;
//    for(PayBean1 pb : payB) {
//        i++;
//        pay_summary = pay_summary + Integer.parseInt(pb.getPay_zhijie()); 
//        PayBean1 payBean  = new PayBean1();
//        String userId = pb.getUserId();
//        if(mp.containsKey(userId)) {
//            payBean = mp.get(userId);
//            if(i == 2) {
//                payBean.setPay_qq(pb.getPay_zhijie());
//                payBean.setUnpaid_qq(pb.getUnpaid_zhijie());
//                payBean.setPersonSum_Summary_qq(pb.getPersonSum_zhijie());
//                payBean.setId_qq(pb.getId());
//            } else if(i ==3) {
//                payBean.setPay_qqq(pb.getPay_zhijie());
//                payBean.setUnpaid_qqq(pb.getUnpaid_zhijie());
//                payBean.setPersonSum_Summary_qqq(pb.getPersonSum_zhijie());
//                payBean.setId_qqq(pb.getId());
//            }
//            
//        } else {
//            i=1;
//            BeanUtils.copyProperties(pb, payBean);
//            payBean.setPay_dq(pb.getPay_zhijie());
//            payBean.setUnpaid_dq(pb.getUnpaid_zhijie());
//            payBean.setPersonSum_Summary_dq(pb.getPersonSum_zhijie());
//            payBean.setId_dq(pb.getId());
//        }
//        payBean.setPay_summary(String.valueOf(pay_summary));
//        mp.put(userId, payBean);
//    }
//    Collection<PayBean1> c = mp.values();
//    payBeans.addAll(c);
    
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cl = Calendar.getInstance();
    String date = sf.format(cl.getTime());
    PayBean pb_dq = iPayDao.getPayBean_zhijie(userId,date);
    
    cl.add(Calendar.DAY_OF_MONTH, -1);
    date = sf.format(cl.getTime());
    PayBean pb_qq = iPayDao.getPayBean_zhijie(userId,date);
    
    cl.add(Calendar.DAY_OF_MONTH, -1);
    date = sf.format(cl.getTime());
    PayBean pb_qqq = iPayDao.getPayBean_zhijie(userId,date);
    if(pb_qqq == null) {
        pb_qqq = new PayBean();
    }
    if(pb_qq == null) {
        pb_qq = new PayBean();
    }
    if(pb_dq == null) {
        pb_dq = new PayBean();
    }
    
    payBeans.add(pb_qqq);
    payBeans.add(pb_qq);
    payBeans.add(pb_dq);
    
    return payBeans;
    }
    
    public List<PayBean> getPayBean_Jianjie(String userId) {
        
//        List<PayBean1> payBeans = new ArrayList<PayBean1>();
//        List<PayBean1> payB = iPayDao.getPayBean(bean);
//        Map<String,PayBean1> mp = new HashMap<String,PayBean1>();
//        int i = 0;
//        int pay_summary = 0;
//        for(PayBean1 pb : payB) {
//            i++;
//            pay_summary = pay_summary + Integer.parseInt(pb.getPay_jianjie()); 
//            PayBean1 payBean  = new PayBean1();
//            String userId = pb.getUserId();
//            if(mp.containsKey(userId)) {
//                payBean = mp.get(userId);
//                if(i == 2) {
//                    payBean.setPay_qq(pb.getPay_jianjie());
//                    payBean.setUnpaid_qq(pb.getUnpaid_jianjie());
//                    payBean.setPersonSum_Summary_qq(pb.getPersonSum_jianjie());
//                    payBean.setId_qq(pb.getId());
//                } else if(i ==3) {
//                    payBean.setPay_qqq(pb.getPay_jianjie());
//                    payBean.setUnpaid_qqq(pb.getUnpaid_jianjie());
//                    payBean.setPersonSum_Summary_qqq(pb.getPersonSum_jianjie());
//                    payBean.setId_qqq(pb.getId());
//                }
//                
//            } else {
//                i=1;
//                BeanUtils.copyProperties(pb, payBean);
//                payBean.setPay_dq(pb.getPay_jianjie());
//                payBean.setUnpaid_dq(pb.getUnpaid_jianjie());
//                payBean.setPersonSum_Summary_dq(pb.getPersonSum_jianjie());
//                payBean.setId_dq(pb.getId());
//            }
//            payBean.setPay_summary(String.valueOf(pay_summary));
//            mp.put(userId, payBean);
//        }
//        Collection<PayBean1> c = mp.values();
//        payBeans.addAll(c);
        
        
        List<PayBean> payBeans = new ArrayList<PayBean>();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cl = Calendar.getInstance();
        String date = sf.format(cl.getTime());
        
        PayBean pb_dq = iPayDao.getPayBean_jianjie(userId,date);
        
        cl.add(Calendar.DAY_OF_MONTH, -7);
        date = sf.format(cl.getTime());
        PayBean pb_qq = iPayDao.getPayBean_zhijie(userId,date);
        
        cl.add(Calendar.DAY_OF_MONTH, -7);
        date = sf.format(cl.getTime());
        
        
        
//        cl.set(Calendar.DAY_OF_MONTH, 2);
//        cl.add(Calendar.MONTH, -1);
//        date = sf.format(cl.getTime());
//        PayBean pb_qq = iPayDao.getPayBean_jianjie(userId,date);
//        
//        cl.add(Calendar.MONTH, -1);
//        date = sf.format(cl.getTime());
        PayBean pb_qqq = iPayDao.getPayBean_jianjie(userId,date);
        
        if(pb_qqq == null) {
            pb_qqq = new PayBean();
        }
        if(pb_qq == null) {
            pb_qq = new PayBean();
        }
        if(pb_dq == null) {
            pb_dq = new PayBean();
        }
        
        payBeans.add(pb_qqq);
        payBeans.add(pb_qq);
        payBeans.add(pb_dq);
        return payBeans;
    }
    
    public void pay_zhijie(List<PayBean> payBean,String select,String paySum,String payName){
        
     BigDecimal sum = new BigDecimal(paySum);
     Date dt = new Date();
     PayBean pb_qqq = payBean.get(0);
     PayBean pb_qq = payBean.get(1);
     PayBean pb_dq = payBean.get(2);
     
        if(select.contains("1")) {
            BigDecimal unpaid = new BigDecimal(pb_qqq.getUnpaid());
            if(unpaid.compareTo(new BigDecimal("0")) >0) {
                BigDecimal paid = new BigDecimal(pb_qqq.getPaid());
            if(sum.compareTo(unpaid)>0) {
                sum = sum.subtract(unpaid);
                
                paid = paid.add(unpaid);
                unpaid =new BigDecimal("0");
            } else {
                
                unpaid = unpaid.subtract(sum);
                paid = paid.add(sum);
                sum = new BigDecimal("0");
            }
            
            pb_qqq.setPaydate(dt);
            pb_qqq.setPaid(String.valueOf(paid));
            pb_qqq.setUnpaid(String.valueOf(unpaid));

            iUserDao.updatePay_zhijie(pb_qqq);
            //iUserDao.updateAchStatus(pb_dq.getUserId(), "1", pb_qqq.getBeginTime().substring(0,7));
            iUserDao.updateAchStatus(pb_dq.getUserId(), "1", pb_qqq.getQishu());
            }
        } 
        if(select.contains("2")) {
            BigDecimal unpaid = new BigDecimal(pb_qq.getUnpaid());
            if(unpaid.compareTo(new BigDecimal("0")) >0) {
                BigDecimal paid = new BigDecimal(pb_qq.getPaid());
            if(sum.compareTo(unpaid)>0) {
                sum = sum.subtract(unpaid);
                
                paid = paid.add(unpaid);
                unpaid =new BigDecimal("0");
            } else {
                
                unpaid = unpaid.subtract(sum);
                paid = paid.add(sum);
                sum = new BigDecimal("0");
            }
            pb_qq.setPaid(paid.toString());
            pb_qq.setUnpaid(unpaid.toString());
            iUserDao.updatePay_zhijie(pb_qq);
            //iUserDao.updateAchStatus(pb_dq.getUserId(), "1", pb_qq.getBeginTime().substring(0,7));
            iUserDao.updateAchStatus(pb_dq.getUserId(), "1", pb_qq.getQishu());
            }
        } 
        if(select.contains("3")) {
            BigDecimal unpaid = new BigDecimal(pb_dq.getUnpaid());
            if(unpaid.compareTo(new BigDecimal("0")) >0) {
            BigDecimal paid = new BigDecimal(pb_dq.getPaid());
            if(sum.compareTo(unpaid) > 0) {
                sum = sum.subtract(unpaid);
                
                paid = paid.add(unpaid);
                unpaid =new BigDecimal("0");
            } else {
                
                unpaid = unpaid.subtract(sum);
                paid = paid.add(sum);
                sum = new BigDecimal("0");
            }

            pb_dq.setPaid(paid.toString());
            pb_dq.setUnpaid(unpaid.toString());
            iUserDao.updatePay_zhijie(pb_dq);
            //iUserDao.updateAchStatus(pb_dq.getUserId(), "1", pb_dq.getBeginTime().substring(0,7));
            iUserDao.updateAchStatus(pb_dq.getUserId(), "1", pb_dq.getQishu());
            }
        }
        
        PayBean1 historyBean = new PayBean1();
        String id = BusinessUtils.getUUID();
        BeanUtils.copyProperties(payBean, historyBean);
        historyBean.setId(id);
        historyBean.setPayId(pb_qqq.getId()+","+pb_qq.getId()+","+pb_dq.getId());
        iUserDao.insertPayHistory(historyBean);
    }
    
    public void pay_jianjie(List<PayBean> payBean,String select,String paySum,String payName){
        
        BigDecimal sum = new BigDecimal(paySum);
        Date dt = new Date();
        PayBean pb_qqq = payBean.get(0);
        PayBean pb_qq = payBean.get(1);
        PayBean pb_dq = payBean.get(2);
        
           if(select.contains("1")) {
               BigDecimal unpaid = new BigDecimal(pb_qqq.getUnpaid());
               if(unpaid.compareTo(new BigDecimal("0")) >0) {
                   BigDecimal paid = new BigDecimal(pb_qqq.getPaid());
               if(sum.compareTo(unpaid) > 0) {
                   sum = sum.subtract(unpaid);
                   
                   paid = paid.add(unpaid);
                   unpaid =new BigDecimal("0");
               } else {
                   
                   unpaid = unpaid.subtract(sum);
                   paid = paid.add(sum);
                   sum = new BigDecimal("0");
               }
               
               pb_qqq.setPaydate(dt);
               pb_qqq.setPaid(paid.toString());
               pb_qqq.setUnpaid(unpaid.toString());

               iUserDao.updatePay_jianjie(pb_qqq);
               iUserDao.updateAchStatus(pb_qqq.getUserId(), "2", pb_qqq.getQishu());
               }
           } 
           if(select.contains("2")) {
               BigDecimal unpaid = new BigDecimal(pb_qq.getUnpaid());
               if(unpaid.compareTo(new BigDecimal("0")) >0) {
                   BigDecimal paid = new BigDecimal(pb_qq.getPaid());
                   if(sum.compareTo(unpaid) > 0) {
                       sum = sum.subtract(unpaid);
                       
                       paid = paid.add(unpaid);
                       unpaid =new BigDecimal("0");
                   } else {
                       
                       unpaid = unpaid.subtract(sum);
                       paid = paid.add(sum);
                       sum = new BigDecimal("0");
                   }
                   
               pb_qq.setPaid(paid.toString());
               pb_qq.setUnpaid(unpaid.toString());
               iUserDao.updatePay_jianjie(pb_qq);
               iUserDao.updateAchStatus(pb_qq.getUserId(), "2", pb_qq.getQishu());
               }
           } 
           if(select.contains("3")) {
               BigDecimal unpaid = new BigDecimal(pb_dq.getUnpaid());
               if(unpaid.compareTo(new BigDecimal("0")) >0) {
                   BigDecimal paid = new BigDecimal(pb_dq.getPaid());
                   if(sum.compareTo(unpaid) > 0) {
                       sum = sum.subtract(unpaid);
                       
                       paid = paid.add(unpaid);
                       unpaid =new BigDecimal("0");
                   } else {
                       
                       unpaid = unpaid.subtract(sum);
                       paid = paid.add(sum);
                       sum = new BigDecimal("0");
                   }

               pb_dq.setPaid(paid.toString());
               pb_dq.setUnpaid(unpaid.toString());
               iUserDao.updatePay_jianjie(pb_dq);
               iUserDao.updateAchStatus(pb_dq.getUserId(), "2", pb_dq.getQishu());
               }
           }
           
           PayBean1 historyBean = new PayBean1();
           String id = BusinessUtils.getUUID();
           BeanUtils.copyProperties(payBean, historyBean);
           historyBean.setId(id);
           historyBean.setPayId(pb_qqq.getId()+","+pb_qq.getId()+","+pb_dq.getId());
           iUserDao.insertPayHistory(historyBean);
       }
    
    public void pay_all(PayBean1 payBean,String select){
        
        int sum = Integer.parseInt(payBean.getPay());
        Date dt = new Date();
        payBean.setPaydate(dt);
           if(select.contains("1")) {
               int unpaid = Integer.parseInt(payBean.getUnpaid_qqq());
               if(unpaid >0) {
                   
                   //先更新直接
                   int unpaid_zhijie = Integer.parseInt(payBean.getUnpaid_qqq_zhijie());
                   
                   
                   int paid_zhijie = Integer.parseInt(payBean.getPaid_qqq_zhijie());
                   
                   
                   if(sum > unpaid_zhijie) {
                       sum = sum - unpaid_zhijie;
                   
                       paid_zhijie = paid_zhijie+unpaid_zhijie;
                       unpaid_zhijie = 0;
                   } else {
                   
                       unpaid_zhijie = unpaid_zhijie - sum;
                       paid_zhijie = paid_zhijie + sum;
                       sum = 0;
                   }
                   
                   payBean.setPaid_zhijie(String.valueOf(paid_zhijie));
                   payBean.setUnpaid_zhijie(String.valueOf(unpaid_zhijie));
                   payBean.setId(payBean.getId_qqq());
                   iUserDao.updatePay_zhijie(payBean);
                   
                   //然后更新间接
                   int unpaid_jianjie = Integer.parseInt(payBean.getUnpaid_qqq_jianjie());
                   int paid_jianjie = Integer.parseInt(payBean.getPaid_qqq_jianjie());
                   
                   if(sum > unpaid_jianjie) {
                       sum = sum - unpaid_jianjie;
                   
                       paid_jianjie = paid_jianjie+unpaid_jianjie;
                       unpaid_jianjie = 0;
                   } else {
                   
                       unpaid_jianjie = unpaid_jianjie - sum;
                       paid_jianjie = paid_jianjie + sum;
                       sum = 0;
                   }
                   
                   payBean.setPaid_jianjie(String.valueOf(paid_jianjie));
                   payBean.setUnpaid_jianjie(String.valueOf(unpaid_jianjie));
                   payBean.setId(payBean.getId_qqq());
                   iUserDao.updatePay_jianjie(payBean);
                   iUserDao.updateAchStatus(payBean.getUserId(), "1", payBean.getDate());
                   
                  
               }
           } 
           if(select.contains("2")) {
               int unpaid = Integer.parseInt(payBean.getUnpaid_qq());
               if(unpaid >0) {
                   
                   //先更新直接
                   int unpaid_zhijie = Integer.parseInt(payBean.getUnpaid_qq_zhijie());
                   
                   
                   int paid_zhijie = Integer.parseInt(payBean.getPaid_qq_zhijie());
                   
                   
                   if(sum > unpaid_zhijie) {
                       sum = sum - unpaid_zhijie;
                   
                       paid_zhijie = paid_zhijie+unpaid_zhijie;
                       unpaid_zhijie = 0;
                   } else {
                   
                       unpaid_zhijie = unpaid_zhijie - sum;
                       paid_zhijie = paid_zhijie + sum;
                       sum = 0;
                   }
                   
                   payBean.setPaid_zhijie(String.valueOf(paid_zhijie));
                   payBean.setUnpaid_zhijie(String.valueOf(unpaid_zhijie));
                   payBean.setId(payBean.getId_qq());
                   iUserDao.updatePay_zhijie(payBean);
                   
                   //然后更新间接
                   int unpaid_jianjie = Integer.parseInt(payBean.getUnpaid_qq_jianjie());
                   int paid_jianjie = Integer.parseInt(payBean.getPaid_qq_jianjie());
                   
                   if(sum > unpaid_jianjie) {
                       sum = sum - unpaid_jianjie;
                   
                       paid_jianjie = paid_jianjie+unpaid_jianjie;
                       unpaid_jianjie = 0;
                   } else {
                   
                       unpaid_jianjie = unpaid_jianjie - sum;
                       paid_jianjie = paid_jianjie + sum;
                       sum = 0;
                   }
                   
                   payBean.setPaid_jianjie(String.valueOf(paid_jianjie));
                   payBean.setUnpaid_jianjie(String.valueOf(unpaid_jianjie));
                   payBean.setId(payBean.getId_qq());
                   iUserDao.updatePay_jianjie(payBean);
                   iUserDao.updateAchStatus(payBean.getUserId(), "1", payBean.getDate());
                   
                  
               }
           } 
           if(select.contains("3")) {
               int unpaid = Integer.parseInt(payBean.getUnpaid_dq());
               if(unpaid >0) {
                   
                   //先更新直接
                   int unpaid_zhijie = Integer.parseInt(payBean.getUnpaid_dq_zhijie());
                   
                   
                   int paid_zhijie = Integer.parseInt(payBean.getPaid_dq_zhijie());
                   
                   
                   if(sum > unpaid_zhijie) {
                       sum = sum - unpaid_zhijie;
                   
                       paid_zhijie = paid_zhijie+unpaid_zhijie;
                       unpaid_zhijie = 0;
                   } else {
                   
                       unpaid_zhijie = unpaid_zhijie - sum;
                       paid_zhijie = paid_zhijie + sum;
                       sum = 0;
                   }
                   
                   payBean.setPaid_zhijie(String.valueOf(paid_zhijie));
                   payBean.setUnpaid_zhijie(String.valueOf(unpaid_zhijie));
                   payBean.setId(payBean.getId_dq());
                   iUserDao.updatePay_zhijie(payBean);
                   
                   //然后更新间接
                   int unpaid_jianjie = Integer.parseInt(payBean.getUnpaid_dq_jianjie());
                   int paid_jianjie = Integer.parseInt(payBean.getPaid_dq_jianjie());
                   
                   if(sum > unpaid_jianjie) {
                       sum = sum - unpaid_jianjie;
                   
                       paid_jianjie = paid_jianjie+unpaid_jianjie;
                       unpaid_jianjie = 0;
                   } else {
                   
                       unpaid_jianjie = unpaid_jianjie - sum;
                       paid_jianjie = paid_jianjie + sum;
                       sum = 0;
                   }
                   
                   payBean.setPaid_jianjie(String.valueOf(paid_jianjie));
                   payBean.setUnpaid_jianjie(String.valueOf(unpaid_jianjie));
                   payBean.setId(payBean.getId_dq());
                   iUserDao.updatePay_jianjie(payBean);
                   iUserDao.updateAchStatus(payBean.getUserId(), "1", payBean.getDate());
                   
                  
               }
           }
           
           PayBean1 historyBean = new PayBean1();
           String id = BusinessUtils.getUUID();
           BeanUtils.copyProperties(payBean, historyBean);
           historyBean.setId(id);
           historyBean.setPayId(payBean.getId());
           iUserDao.insertPayHistory(historyBean);
       }
    
    public void addAdminRole(String userId){
        UserBean userBean = iUserDao.getUser(userId);
        iUserDao.updateUser_flg(userId, "0");
        iUserDao.addAdminUser(userId, userBean.getUserPassword());
    }
    public void delAdminRole(String userId){
        UserBean userBean = iUserDao.getUser(userId);
        String code = userBean.getCode();
        String userFlg = "1";
        if(!StringUtils.isEmpty(code)) {
            userFlg = "2";
        }
        iUserDao.updateUser_flg(userId, userFlg);
        iUserDao.delAdminUser(userId);
    }

}
