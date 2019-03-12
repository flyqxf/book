/*
 * @(#)AdminLoginAction.java
 */
package com.yuanneng.book.manage.sale.action;

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
import com.yuanneng.book.manage.sale.entity.SaleBean;

public class SaleExportExcelAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    private final String path = "/excel/";
    private final String filename = "saleManage.xls";
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
        
        String[] title = {"会员ID","会员名称","入会时间","直接推荐（累计）","间接推荐（累计）","奖励金额（合计）","直接推荐（当期）","间接推荐（当期）","应付金额"};
        HttpSession session = this.getSession();
        @SuppressWarnings("unchecked")
        CommonPageLinksBean<SaleBean> result = (CommonPageLinksBean<SaleBean>) session.getAttribute("saleList");
        List<SaleBean> sales = result.getResultList();
        List<List<String>> list = new ArrayList<List<String>>();
        for(SaleBean  bean : sales) {
            List<String> lst = new ArrayList<String>();
            lst.add(bean.getUserId());
            lst.add(bean.getUserName());
            lst.add(bean.getRegister_time());
            lst.add(String.valueOf(bean.getPersonSum_zhijie()));
            lst.add(String.valueOf(bean.getPersonSum_jianjie()));
            lst.add(String.valueOf(bean.getPaySummary()));
            lst.add(String.valueOf(bean.getPersonThisMonth_zhijie()));
            lst.add(String.valueOf(bean.getPersonThisMonth_jianjie()));
            lst.add(String.valueOf(bean.getPaySummary_thisMonth()));
            
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
