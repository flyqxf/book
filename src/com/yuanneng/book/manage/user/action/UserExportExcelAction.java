/*
 * @(#)AdminLoginAction.java
 */
package com.yuanneng.book.manage.user.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;



import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.entity.CommonPageLinksBean;
import com.yuanneng.book.common.utils.ExportUtil;
import com.yuanneng.book.manage.user.entity.UserBean;

public class UserExportExcelAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    private final String path = "/excel/";
    private final String filename = "userManage.xls";
    /**
     * 下载方法
     */
    private String downloadFileName;

    /**
     * 输入流变量
     */
    private InputStream excelStream;


    /**
     * 主要逻辑方法
     * <p>
     * 编辑画面的输入值，调用service,处理service的返回结果
     * </p>
     * 
     * @return 处理结果
     * @exception 待定
     */
    @Override
    public String doMain() throws Exception {
        
        String[] title = {"会员ID","会员名称","电话","籍贯","入会时间","会员区分","收款方式","收款账号","状态"};
        HttpSession session = this.getSession();
        @SuppressWarnings("unchecked")
        CommonPageLinksBean<UserBean> result = (CommonPageLinksBean<UserBean>) session.getAttribute("userInfoList");
        List<UserBean> users = result.getResultList();
        List<List<String>> list = new ArrayList<List<String>>();
        for(UserBean  bean : users) {
            List<String> lst = new ArrayList<String>();
            lst.add(bean.getUserId());
            lst.add(bean.getUserName());
            lst.add(bean.getMobile());
            lst.add(bean.getProvince()+bean.getCity());
            lst.add(bean.getRegister_time());
            lst.add(bean.getUser_flg_name());
            lst.add(bean.getReceivables_flg_name());
            if(bean.getReceivables_flg().equals("1")) {
                lst.add(bean.getId_zhifubao());
            } else if(bean.getReceivables_flg().equals("2")) {
                lst.add(bean.getId_weixin());
            } else {
                lst.add(bean.getBank_card_number());
            }
            lst.add(bean.getStatus_name());
            list.add(lst);
        }
        
        String filepath = ServletActionContext.getServletContext().getRealPath(
                path);
        File f = new File(filepath);
        if(!f.exists()) {
            f.mkdirs();
        }
        filepath = filepath +"/"+filename;
        File fl = ExportUtil.exportExcel(list, title, filepath);
       
         excelStream = new FileInputStream(fl);

         downloadFileName = fl.getName();
         
        return SUCCESS;
        
    }


    
    /**
     * @return the downloadFileName
     */
    public String getDownloadFileName() {
        return downloadFileName;
    }


    
    /**
     * @param downloadFileName the downloadFileName to set
     */
    public void setDownloadFileName(String downloadFileName) {
        this.downloadFileName = downloadFileName;
    }


    
    /**
     * @return the excelStream
     */
    public InputStream getExcelStream() {
        return excelStream;
    }


    
    /**
     * @param excelStream the excelStream to set
     */
    public void setExcelStream(InputStream excelStream) {
        this.excelStream = excelStream;
    }

    

}
