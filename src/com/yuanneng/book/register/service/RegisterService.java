/*
 * @(#)UserLoginServer.java
 */
package com.yuanneng.book.register.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.yuanneng.book.common.service.CommonService;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.manage.pay.entity.PayBean;
import com.yuanneng.book.manage.systemInfo.dao.ISystemInfoDao;
import com.yuanneng.book.manage.systemInfo.entity.SystemInfoBean;
import com.yuanneng.book.prerson.entity.AchievementBean;
import com.yuanneng.book.register.dao.IRegisterDao;
import com.yuanneng.book.sysmanage.entity.UserBean;


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
public class RegisterService implements CommonService {

    /**
     * 日志
     */
    public static Logger logger = Logger.getLogger(RegisterService.class);

    /**
     * 注入的ISelectUserDao层
     */
    @Resource
    private IRegisterDao iRegisterDao;
    
    @Resource
    private ISystemInfoDao iSystemInfoDao;

    public String getPrice() {
        
      //产品价格
        String price = null;
        SystemInfoBean res = null;
        SystemInfoBean systemInfoBeanCondition = new SystemInfoBean();
        //systemInfoBeanCondition.setName("产品价格");
        systemInfoBeanCondition.setKey("price");
        List<SystemInfoBean> lst = iSystemInfoDao.getSystemInfo(systemInfoBeanCondition);
        if(lst.size()>0) {
            res = lst.get(0);
            price = res.getKeyword();
        }
        return price;
    }
    
    public String getPrivilege() {
        
      //优惠金额
        String privilege =null;
        SystemInfoBean res = null;
        SystemInfoBean systemInfoBeanCondition = new SystemInfoBean();
        systemInfoBeanCondition.setKey("privilege");
        List<SystemInfoBean> lst = iSystemInfoDao.getSystemInfo(systemInfoBeanCondition);
        if(lst.size()>0) {
            res = lst.get(0);
            privilege = res.getKeyword();
        }
        return privilege;
    }
    public String updateUserSts(UserBean usrBean) {
        
        String userId =null;
        UserBean userBean = iRegisterDao.selectUserByOutTradeNo(usrBean);
        userId = userBean.getUserId();
        int cnt = iRegisterDao.getUserCnt(userId);
        if(cnt==0) {
            insertUser(userBean);
            deleteUserByOutTradeNo(userBean);
        }
        return userId;
        
    }
    public void deleteUserByOutTradeNo(UserBean userBean) {
        iRegisterDao.deleteUserByOutTradeNo(userBean);
    }
    
    public void inserUserTemp(UserBean userBean) {
      //产品价格
        String price = "0";
        //优惠金额
        String privilege ="0";
        userBean.setNo(BusinessUtils.getUUID());
        SystemInfoBean res = null;
        SystemInfoBean systemInfoBeanCondition = new SystemInfoBean();
        //systemInfoBeanCondition.setName("产品价格");
        systemInfoBeanCondition.setKey("price");
        List<SystemInfoBean> lst = iSystemInfoDao.getSystemInfo(systemInfoBeanCondition);
        if(lst.size()>0) {
            res = lst.get(0);
            price = res.getKeyword();
        }
        
        
        
        String registerCode = userBean.getRegister_code();
        if(!StringUtils.isEmpty(registerCode)) {
            
            //优惠金额取得
            //systemInfoBeanCondition.setName("优惠金额");
            systemInfoBeanCondition.setKey("privilege");
            lst = iSystemInfoDao.getSystemInfo(systemInfoBeanCondition);
            if(lst.size()>0) {
                res = lst.get(0);
                privilege = res.getKeyword();
            }  
        }
        userBean.setMoney(new BigDecimal(price).subtract(new BigDecimal(privilege)).toString());
        iRegisterDao.insertUserTemp(userBean);
    }
    
    public void insertUser(UserBean userBean) {
        //产品价格
        String price = "0";
        //优惠金额
        String privilege ="0";
        SystemInfoBean res = null;
        SystemInfoBean systemInfoBeanCondition = new SystemInfoBean();
        //systemInfoBeanCondition.setName("产品价格");
        systemInfoBeanCondition.setKey("price");
        List<SystemInfoBean> lst = iSystemInfoDao.getSystemInfo(systemInfoBeanCondition);
        if(lst.size()>0) {
            res = lst.get(0);
            price = res.getKeyword();
        }
        
        
        
        String registerCode = userBean.getRegister_code();
        if(!StringUtils.isEmpty(registerCode)) {
            
            //优惠金额取得
            //systemInfoBeanCondition.setName("优惠金额");
            systemInfoBeanCondition.setKey("privilege");
            lst = iSystemInfoDao.getSystemInfo(systemInfoBeanCondition);
            if(lst.size()>0) {
                res = lst.get(0);
                privilege = res.getKeyword();
            }
            
            
            
            String directReward = "0";
            
            systemInfoBeanCondition = new SystemInfoBean();
            
            //systemInfoBeanCondition.setName("直接销售奖励");
            systemInfoBeanCondition.setKey("directReward");
            lst = iSystemInfoDao.getSystemInfo(systemInfoBeanCondition);
            if(lst.size()>0) {
                res = lst.get(0);
                directReward = res.getKeyword();
            }
            
            String userId = iRegisterDao.getUserId(registerCode);
            
//            AchievementBean achievementBean = new AchievementBean();
//            achievementBean.setUserId(userId);
//            achievementBean.setId(BusinessUtils.getUUID());
//            achievementBean.setRegisterUserId(userBean.getUserId());
//            achievementBean.setPay_status("0");
//            achievementBean.setFlg("1");
//            achievementBean.setPay(directReward);
//            
//            iRegisterDao.insertAchievement(achievementBean);
            
            //录入支付统计表
            
            List<PayBean> idList = iRegisterDao.getPay_zhijie_cnt(userId);
            int qishu = 0;
            int maxQishu = iRegisterDao.getMaxQishu_zhijie(userId);
            PayBean payBean = new PayBean();
            if(idList.size()>0) {
                qishu = maxQishu;
                PayBean pb = idList.get(0);
                String id = pb.getId();
                String persionSum = pb.getPersonSum();
                String pay = pb.getPay();
                String unpaid = pb.getUnpaid();
                
                payBean.setId(id);
                payBean.setPersonSum(String.valueOf(Integer.parseInt(persionSum)+1));
                payBean.setPay(new BigDecimal(pay).add(new BigDecimal(directReward)).toString());
                payBean.setUnpaid(new BigDecimal(unpaid).add(new BigDecimal(directReward)).toString());
                
                iRegisterDao.updatePay_zhijie(payBean);
                
            } else {
//                int maxQishu = iRegisterDao.getMaxQishu_zhijie(userId);
                //当前日期
                qishu = maxQishu+1;
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                Calendar cl = Calendar.getInstance();
                
                //int week = cl.get(Calendar.DAY_OF_WEEK);
                
                //cl.add(Calendar.DAY_OF_MONTH, 1-week);
                String beginTime = sf.format(cl.getTime());
                //cl.add(Calendar.DAY_OF_MONTH, 6);
                String endTime = sf.format(cl.getTime());
                
                String id= BusinessUtils.getUUID();
                String personSum = "1";
                String pay = directReward;
                String paid = "0";
                String unpaid = directReward;
//                String qishu = String.valueOf(maxQishu+1);
                
                payBean.setId(id);
                payBean.setUserId(userId);
                payBean.setPersonSum(personSum);;
                payBean.setPay(pay);
                payBean.setPaid(paid);
                payBean.setUnpaid(unpaid);
                payBean.setQishu(String.valueOf(qishu));
                payBean.setBeginTime(beginTime);
                payBean.setEndTime(endTime);
                
                iRegisterDao.insertPay_zhijie(payBean);
            }
            
            AchievementBean achievementBean = new AchievementBean();
            achievementBean.setUserId(userId);
            achievementBean.setId(BusinessUtils.getUUID());
            achievementBean.setRegisterUserId(userBean.getUserId());
            achievementBean.setPay_status("0");
            achievementBean.setFlg("1");
            achievementBean.setQishu(String.valueOf(qishu));
            achievementBean.setPay(directReward);
          
          iRegisterDao.insertAchievement(achievementBean);

            //间接推荐
            String registerCodeJianjie = iRegisterDao.getRegisterCode(userId);
            //间接
            if(!StringUtils.isEmpty(registerCodeJianjie)) {
                String indirectReword = "0";
            
                //systemInfoBeanCondition.setName("间接销售奖励");
                systemInfoBeanCondition.setKey("indirectReword");
                List<SystemInfoBean> lstIndirect = iSystemInfoDao.getSystemInfo(systemInfoBeanCondition);
                if(lstIndirect.size()>0) {
                    res = lstIndirect.get(0);
                    indirectReword = res.getKeyword();
                }
                
                String userIdJianjie = iRegisterDao.getUserId(registerCodeJianjie);
                
//                achievementBean = new AchievementBean();
//                achievementBean.setUserId(userIdJianjie);
//                achievementBean.setId(BusinessUtils.getUUID());
//                achievementBean.setRegisterUserId(userId);
//                achievementBean.setRegisterUserIdJianjie(userBean.getUserId());
//                achievementBean.setPay_status("0");
//                achievementBean.setFlg("2");
//                achievementBean.setPay(indirectReword);
//                
//                iRegisterDao.insertAchievement(achievementBean);
                
              //录入支付统计表
                
                List<PayBean> idList_jianjie = iRegisterDao.getPay_jianjie_cnt(userIdJianjie);
                payBean = new PayBean();
                qishu = 0;
                maxQishu = iRegisterDao.getMaxQishu_jianjie(userIdJianjie);
                if(idList_jianjie.size()>0) {
                    qishu=maxQishu;
                    PayBean pb = idList_jianjie.get(0);
                    String id = pb.getId();
                    String persionSum = pb.getPersonSum();
                    String pay = pb.getPay();
                    String unpaid = pb.getUnpaid();
                    
                    payBean.setId(id);
                    payBean.setPersonSum(String.valueOf(Integer.parseInt(persionSum)+1));
                    payBean.setPay(new BigDecimal(pay).add(new BigDecimal(indirectReword)).toString());
                    payBean.setUnpaid(new BigDecimal(unpaid).add(new BigDecimal(indirectReword)).toString());
                    
                    iRegisterDao.updatePay_jianjie(payBean);
                    
                } else {
                    qishu = maxQishu+1;
                    //当前日期
                    
                    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                    Calendar cl = Calendar.getInstance();
                    
                    int week = cl.get(Calendar.DAY_OF_WEEK);
                    
                    cl.add(Calendar.DAY_OF_MONTH, 1-week);
                    String beginTime = sf.format(cl.getTime());
                    cl.add(Calendar.DAY_OF_MONTH, 6);
                    String endTime = sf.format(cl.getTime());
                    
//                    cl.set(Calendar.DAY_OF_MONTH, 1);
//                    String beginTime = sf.format(cl.getTime());
//                    
//                    int maxDay = cl.getActualMaximum(Calendar.DAY_OF_MONTH);
//                    cl.set(Calendar.DAY_OF_MONTH, maxDay);
//
//                    String endTime = sf.format(cl.getTime());
                    
                    String id= BusinessUtils.getUUID();
                    String personSum = "1";
                    String pay = indirectReword;
                    String paid = "0";
                    String unpaid = indirectReword;
//                    String qishu = String.valueOf(maxQishu+1);
                    
                    payBean.setId(id);
                    payBean.setUserId(userIdJianjie);
                    payBean.setPersonSum(personSum);;
                    payBean.setPay(pay);
                    payBean.setPaid(paid);
                    payBean.setUnpaid(unpaid);
                    payBean.setQishu(String.valueOf(qishu));
                    payBean.setBeginTime(beginTime);
                    payBean.setEndTime(endTime);
                    
                    iRegisterDao.insertPay_jianjie(payBean);
                }
                achievementBean = new AchievementBean();
                achievementBean.setUserId(userIdJianjie);
                achievementBean.setId(BusinessUtils.getUUID());
                achievementBean.setRegisterUserId(userId);
                achievementBean.setRegisterUserIdJianjie(userBean.getUserId());
                achievementBean.setPay_status("0");
                achievementBean.setFlg("2");
                achievementBean.setQishu(String.valueOf(qishu));
                achievementBean.setPay(indirectReword);
                
                iRegisterDao.insertAchievement(achievementBean);
                
               
            }
            List<String> userIdList = getUpdateUserId(userBean.getRegister_code(), null);
            iRegisterDao.updateTuijianRenshu(userIdList);
        }
        userBean.setMoney(new BigDecimal(price).subtract(new BigDecimal(privilege)).toString());
        iRegisterDao.insertUser(userBean);
        
    }
    
    /**
     * 根据regisiterCode更新上级、上上级、到最初的销售的用户名
     * @param regisiterCode
     * @return
     */
    private List<String> getUpdateUserId(String regisiterCode,List<String> userIdList) {
        if(userIdList == null) {
            userIdList = new ArrayList<String>();
        }
        if(StringUtils.isNotEmpty(regisiterCode)) {
            UserBean usrBean = iRegisterDao.getTuijianUser(regisiterCode);
            String regCode = usrBean.getRegister_code();
            userIdList = getUpdateUserId(regCode,userIdList);
            userIdList.add(usrBean.getUserId());
        }
        return userIdList;
    }
    
    public void changeSaler(UserBean userBean) {
        UserBean bean = iRegisterDao.getUserInfo(userBean.getUserId());
        
        String user_flg = bean.getUser_flg();
        
        if(!"0".equals(user_flg)) {
            userBean.setUser_flg("2");
        } else {
            userBean.setUser_flg("0");
        }
        
        String code = userBean.getCode();
        
        if("1".equals(code)) {
            userBean.setCode(bean.getMobile());
        } else {
            userBean.setCode(userBean.getUserId());
        }
        
        iRegisterDao.changeSaler(userBean);
    }
    
    /**
     * 登录名是否存在
     * @param userId
     * @return
     */
    public boolean isExsitsUser(String userId) {
        return iRegisterDao.getUserCnt(userId)>0;
    }
    
    /**
     * 手机号是否存在
     * @param userId
     * @return
     */
    public boolean isExsitsMobile(String mobile) {
        return iRegisterDao.getMobileCnt(mobile)>0;
    }
    
    /**
     * 优惠码是否存在
     * @param userId
     * @return
     */
    public boolean isExsitsRegisterCode(String registerCode) {
        return !StringUtils.isEmpty(iRegisterDao.getUserId(registerCode));
    }
    
    public String getUserFlg(String userId) {
        UserBean bean = iRegisterDao.getUserInfo(userId);
        return bean.getUser_flg();
    }
    
}
