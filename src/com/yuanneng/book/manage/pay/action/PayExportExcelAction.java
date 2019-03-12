/*
 * @(#)AdminLoginAction.java
 */
package com.yuanneng.book.manage.pay.action;

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
import com.yuanneng.book.manage.pay.entity.PayBean1;

public class PayExportExcelAction extends CommonAction {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    private final String path = "/excel/";
    private final String filename = "payManage.xls";
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
        
        String[] title = {"会员ID","会员名称","前前期金额","前前期待支付金额","前期金额","前期待支付金额","当期金额","当期待支付","待支付金额（合计）"};
        HttpSession session = this.getSession();
        @SuppressWarnings("unchecked")
        CommonPageLinksBean<PayBean1> result = (CommonPageLinksBean<PayBean1>) session.getAttribute("payList");
        List<PayBean1> pays = result.getResultList();
        List<List<String>> list = new ArrayList<List<String>>();
        for(PayBean1  bean : pays) {
            List<String> lst = new ArrayList<String>();
            lst.add(bean.getUserId());
            lst.add(bean.getUserName());
            lst.add(bean.getPay_qqq());
            lst.add(bean.getUnpaid_qqq());
            lst.add(bean.getPay_qq());
            lst.add(bean.getUnpaid_qq());
            lst.add(bean.getPay_dq());
            lst.add(bean.getUnpaid_dq());
            lst.add(bean.getUnpaid_summary());
            
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
