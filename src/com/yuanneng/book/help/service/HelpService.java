/*
 * @(#)UserLoginServer.java
 */
package com.yuanneng.book.help.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.yuanneng.book.common.service.CommonService;
import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;
import com.yuanneng.book.help.dao.IHelpDao;
import com.yuanneng.book.help.entity.HelpBean;


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
public class HelpService implements CommonService {

    /**
     * 日志
     */
    public static Logger logger = Logger.getLogger(HelpService.class);

    /**
     * 注入的ISelectUserDao层
     */
    @Resource
    private IHelpDao iHelpDao;

    /**
     * 
     */
    public void addHelp(HelpBean helpBean) {
        
        String id = BusinessUtils.getUUID();
        String createUser = BusinessUtils.getUVO().getUser().getUserId();
        
        helpBean.setId(id);
        helpBean.setCreateUser(createUser);
        
        iHelpDao.insertHelp(helpBean);
    }
    
 public void editHelp(HelpBean helpBean) {
        
      
        iHelpDao.updateHelp(helpBean);
    }
    
    public List<HelpBean> selectHelp(String userId) {
        List<HelpBean> helpBeans =  iHelpDao.selectHelp(userId);
        for(HelpBean helpBean:helpBeans) {
            String status = helpBean.getStatus();
            if(Constant.STRING_ONE.equals(status)) {
                status = "已回答";
            } else {
                status = "未回答";
            }
            helpBean.setStatus(status);
        }
        return helpBeans;
    }
    
    public void deleteHelp(String id) {
        iHelpDao.deleteHelp(id);
    }
    
    public HelpBean selectHelpDetail(String id) {
        return iHelpDao.selectHelpDetail(id);
    }

}
