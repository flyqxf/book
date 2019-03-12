/*
 * @(#)AdminUserLoginService.java
 */
package com.yuanneng.book.manage.index.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.yuanneng.book.common.service.CommonService;
import com.yuanneng.book.manage.index.dao.IIndexDao;
import com.yuanneng.book.manage.index.entity.IndexBean;
import com.yuanneng.book.manage.index.entity.IndexDetailBean;


public class IndexService implements CommonService {


    /**
     * 注入的ISelectUserDao层
     */
    @Resource
    private IIndexDao iIndexDao;

    
    public IndexBean getIndexBean() {
        
        IndexBean indexB = new IndexBean();
        //检索会员总数及总收入
        indexB = iIndexDao.getUsers();
        //检索销售人员数
        List<String> sales = iIndexDao.getSaleSum();
        int saleNum = sales.size();
        //检索普通会员数
        int personSum = Integer.parseInt(indexB.getPersonSummary()) - saleNum;
        //检索已分配金额
        String distribution = iIndexDao.getDistribution();
        if(StringUtils.isEmpty(distribution)) {
            distribution = "0";
        }
        //检索未分配金额
        String notDistribution = iIndexDao.getNotDistribution();
        if(StringUtils.isEmpty(notDistribution)) {
            notDistribution = "0";
        }
        
        

        indexB.setSaleSum(String.valueOf(saleNum));
        indexB.setPersonSum(String.valueOf(personSum));
        indexB.setDistribution(new BigDecimal(distribution).toString());
        indexB.setNotDistribution(new BigDecimal(notDistribution).toString());
        //indexB.setIncome(String.valueOf(Integer.valueOf(distribution)+Integer.valueOf(notDistribution)));
        indexB.setIncome((new BigDecimal(distribution).add(new BigDecimal(notDistribution))).toString());
        
        return indexB;
    }
    
    public List<IndexDetailBean> getUsers() {
        List<IndexDetailBean> userList = new ArrayList<IndexDetailBean>();
        List<IndexDetailBean> usrs = iIndexDao.getUsrs();
        
        int cntSumLastYear = 0;
        int cntSumThisYear = 0;
        Calendar cl = Calendar.getInstance();
        int thisYear = cl.get(Calendar.YEAR);
        int lastYear = thisYear - 1;

        
        for(int j = 1; j<25; j++) {
            IndexDetailBean idxBean = new IndexDetailBean();
            String cnt = "0";
            if(usrs == null || usrs.size() == 0) {
                idxBean.setCnt(cnt);
                idxBean.setRegisteTime(j+"月");
                userList.add(idxBean);
                if(j == 12) {
                    idxBean = new IndexDetailBean();
                    idxBean.setCnt("0");
                    idxBean.setRegisteTime("年小计");
                    userList.add(idxBean);

                }
                if(j == 24) {
                    idxBean = new IndexDetailBean();
                    idxBean.setCnt("0");
                    idxBean.setRegisteTime("年小计");
                    userList.add(idxBean);
                }
            } else {
            if(j <13) {
                for(IndexDetailBean indexDetailBean:usrs) {
                    String time = indexDetailBean.getRegisteTime();
                    String[] times = time.split("-");
                    if(j==Integer.parseInt(times[1])) {
                        if(String.valueOf(lastYear).equals(times[0])) {
                            cnt = indexDetailBean.getCnt();
                            cntSumLastYear = cntSumLastYear + Integer.parseInt(cnt);
                            
                            break;
                        }
                    }
                }
                idxBean.setCnt(cnt);
                idxBean.setRegisteTime(j+"月");
                userList.add(idxBean);
                if(j == 12) {
                    idxBean = new IndexDetailBean();
                        idxBean.setCnt(String.valueOf(cntSumLastYear));
                        idxBean.setRegisteTime("年小计");
                        userList.add(idxBean);

                }
                
            }else {
                for(IndexDetailBean indexDetailBean:usrs) {
                    String time = indexDetailBean.getRegisteTime();
                    
                    String[] times = time.split("-");
                    if((j-12)== Integer.parseInt(times[1])) {
                        if(String.valueOf(thisYear).equals(times[0])) {
                            cnt = indexDetailBean.getCnt();
                            cntSumThisYear = cntSumThisYear + Integer.parseInt(cnt);
                            
                            break;
                        }
                    }
                }
                idxBean.setCnt(cnt);
                idxBean.setRegisteTime(j-12+"月");
                userList.add(idxBean);
                if(j == 24) {
                    idxBean = new IndexDetailBean();
                        idxBean.setCnt(String.valueOf(cntSumThisYear));
                        idxBean.setRegisteTime("年小计");
                        userList.add(idxBean);
                }
            }
            }
            
        }
         
        return userList;
    }

   
}
