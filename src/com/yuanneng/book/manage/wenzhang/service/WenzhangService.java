/*
 * @(#)AdminUserLoginService.java
 */
package com.yuanneng.book.manage.wenzhang.service;

import java.util.List;

import javax.annotation.Resource;

import com.yuanneng.book.common.service.CommonService;
import com.yuanneng.book.manage.wenzhang.dao.IWenzhangDao;
import com.yuanneng.book.manage.wenzhang.entity.WenzhangBean;

public class WenzhangService implements CommonService {


    /**
     * 注入的ISelectUserDao层
     */
    @Resource
    private IWenzhangDao iWenzhangDao;

    
    public List<WenzhangBean> getWenzhang(WenzhangBean wenzhangBean) {
        
        List<WenzhangBean> wenzhangBeans=iWenzhangDao.getWenzhang(wenzhangBean);
        int i = 0;
        for(WenzhangBean bean : wenzhangBeans) {
            i++;
            String status = bean.getStatus();
            String leibie = bean.getLeibie();
            if("0".equals(status)) {
                bean.setStatus_name("未处理");
            } else if ("1".equals(status)) {
                bean.setStatus_name("已处理");
            } else {
                bean.setStatus_name(status);
            }
            
            if("1".equals(leibie)) {
                bean.setLeibie_name("答疑");
            } else if ("2".equals(leibie)) {
                bean.setLeibie_name("发表");
            } else {
                bean.setLeibie_name(leibie);
            }
            bean.setNo(String.valueOf(i));
        }
        
        return wenzhangBeans;
    }
    
    public void answer(String id,String leibie,String answer) {
        WenzhangBean wenzhangBean = new WenzhangBean();
        wenzhangBean.setAnswer(answer);
        wenzhangBean.setId(id);
        wenzhangBean.setStatus("1");
        if(leibie.equals("1")) {
            iWenzhangDao.updateHelp(wenzhangBean);
        }else {
            iWenzhangDao.updateArticle(wenzhangBean);
        }
    }

}
