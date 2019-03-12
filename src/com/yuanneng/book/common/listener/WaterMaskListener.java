package com.yuanneng.book.common.listener;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.yuanneng.book.common.utils.BookPdfStamper;
import com.yuanneng.book.common.utils.PropertyUtil;
import com.yuanneng.book.common.utils.ZipFileUtil;

/**
 * ScanStatusListener.java
 * 
 * 功 能： 扫描状态获取Listener
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.04.18         秦霄飞          新规做成
 * </pre>
 */
public class WaterMaskListener implements ServletContextListener {

    /**
     * ServletContext失效时处理
     * 
     * @param src ServletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent src) {
    }

    /**
     * ServletContext初始化处理
     * 
     * @param src ServletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent src) {

        String rootPath = src.getServletContext().getRealPath("/");
        
        String pdfPath = PropertyUtil.getProperty("pdfPath");
        String zipName = PropertyUtil.getProperty("zipName");
        String outputPdfPath = PropertyUtil.getProperty("outputPdfPath");
        String waterMaskName = PropertyUtil.getProperty("waterMaskName");
        

        String outPath = rootPath.concat(pdfPath).concat(outputPdfPath);
        File out = new File(outPath);
        out.deleteOnExit();
        out.mkdirs();
        
        //String fullOutPath = outPath.concat(pdfName);
        //String pdfFullName = rootPath.concat(pdfPath).concat(pdfName);
        
        String pdfFullPath = rootPath.concat(pdfPath);
        File abPath = new File(pdfFullPath);
        File[] files = abPath.listFiles();
        File[] pdfFiles = new File[files.length];
        int i = -1;
        for(File f:files) {
            i++;
            String fileName = f.getName();
            int idx = fileName.lastIndexOf(".");
            if(idx != -1) {
                String suffix = fileName.substring(idx+1);
                if("pdf".equals(suffix.toLowerCase())) {
                    String pdfFullName = f.getAbsolutePath();
                    String fullOutPath = outPath.concat(f.getName());
                    BookPdfStamper.waterMark(pdfFullName,fullOutPath,waterMaskName);
                    pdfFiles[i]=new File(fullOutPath);
                }
            }
            
        }
        
        ZipFileUtil.compressFiles2Zip(pdfFiles,outPath.concat(zipName));

    }
}
