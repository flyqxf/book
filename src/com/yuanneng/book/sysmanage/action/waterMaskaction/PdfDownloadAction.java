/*
 * @(#)UserLoginAction.java
 */
package com.yuanneng.book.sysmanage.action.waterMaskaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.common.utils.PropertyUtil;

/**
 * UserLoginAction.java
 * 
 * 功 能： 用户登录验证
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.04.13         shanjixiang     新规做成
 * </pre>
 */
public class PdfDownloadAction extends CommonAction {


    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;


    /**
     * 下载方法
     */
    private String fileName;

    /**
     * 输入流变量
     */
    private InputStream inputStream;

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
        
        fileName = PropertyUtil.getProperty("zipName");
        String pdfPath = PropertyUtil.getProperty("pdfPath");
        String outputPdfPath = PropertyUtil.getProperty("outputPdfPath");
        
        HttpServletRequest request = this.getRequest();
        String rootPath = request.getServletContext().getRealPath("/");
        
        String outPath = rootPath.concat(pdfPath).concat(outputPdfPath).concat(fileName);
        inputStream =new FileInputStream(new File(outPath));
        
        return SUCCESS;
        
    }

    
    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    
    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    
    /**
     * @return the inputStream
     */
    public InputStream getInputStream() {
        return inputStream;
    }


    
    /**
     * @param inputStream the inputStream to set
     */
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

   
   

}
