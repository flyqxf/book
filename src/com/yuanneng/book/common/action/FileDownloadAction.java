package com.yuanneng.book.common.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.yuanneng.book.common.utils.CodeConstant;
import com.yuanneng.book.common.utils.Constant;

/**
 * FileDownloadAction.java
 * 
 * 功 能： 文件下载共通Action
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.03.31         肖健            新规做成
 * </pre>
 */
public class FileDownloadAction implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 日志
     */
    public static Logger logger = Logger.getLogger(FileDownloadAction.class);

    /**
     * 资产发现批量导入文件下载模板保存位置
     */
    private static final String discoveryFileTemplatePath = "/template/found";

    /**
     * 资产发现批量导入CSV文件模板
     */
    private static final String INPUT_CSV_TEMPLATE = "INPUT_CSV_TEMPLATE.csv";

    /**
     * 资产发现批量导入EXCEL文件模板
     */
    private static final String INPUT_EXCEL_TEMPLATE = "INPUT_EXCEL_TEMPLATE.xlsx";

    /**
     * 资产发现批量导入TXT文件模板（逗号分隔）
     */
    private static final String INPUT_TXT_TEMPLATE1 = "INPUT_TXT_COMA_TEMPLATE.txt";

    /**
     * 资产发现批量导入TXT文件模板（空格分隔）
     */
    private static final String INPUT_TXT_TEMPLATE2 = "INPUT_TXT_SPACE_TEMPLATE.txt";

    /**
     * 下载文件类型
     */
    private String fileType = Constant.STRING_BLANK;

    /**
     * 下载文件名称
     */
    private String fileName = Constant.STRING_BLANK;

    /**
     * 分隔符类型
     */
    private String splitType = Constant.STRING_BLANK;

    /**
     * 将指定文件返回一个输入流给客户端
     * 
     * @return 返回给客户端的输入流
     * @throws Exception
     */
    public InputStream getDownloadStream() throws Exception {
        // 返回结果
        InputStream inputStream = null;

        try {
            String filepath = ServletActionContext.getServletContext().getRealPath(
                    discoveryFileTemplatePath);
            File fp = new File(filepath); // 判断文件夹是否存在,如果不存在则报错
            // 创建目录
            if (!fp.exists()) {
                logger.error("下载文件Template路径不存在。");
                return null;
            }

            // 资产发现导入CSV文件模板
            if (StringUtils.equals(this.fileType, CodeConstant.FILE_TYPE_CSV)) {
                // 设定下载文件名
                this.fileName = FileDownloadAction.INPUT_CSV_TEMPLATE;
                // 获取资源路径
                inputStream = new FileInputStream(filepath + Constant.VIRGULE + this.fileName);
            }
            // 资产发现导入EXCEL文件模板
            else if (StringUtils.equals(this.fileType, CodeConstant.FILE_TYPE_EXCEL)) {
                // 设定下载文件名
                this.fileName = FileDownloadAction.INPUT_EXCEL_TEMPLATE;
                inputStream = new FileInputStream(filepath + Constant.VIRGULE + this.fileName);
            }
            // 资产发现导入TXT文件模板
            else if (StringUtils.equals(this.fileType, CodeConstant.FILE_TYPE_TXT)) {
                if (StringUtils.equals(splitType, CodeConstant.FILE_SPLIT_COMA)) {
                    // 设定下载文件名
                    this.fileName = FileDownloadAction.INPUT_TXT_TEMPLATE1;
                } else {
                    // 设定下载文件名
                    this.fileName = FileDownloadAction.INPUT_TXT_TEMPLATE2;
                }
                inputStream = new FileInputStream(filepath + Constant.VIRGULE + this.fileName);
            }
            logger.info("成功下载文件名称：" + fileName);
        } catch (Exception e) {
            logger.error("下载文件信息出错。" + fileName, e);
        }
        if (null == inputStream) {
            logger.error("下载【" + fileName + "】失败。");
        }
        return inputStream;
    }

    /**
     * 文件下载被调用方法
     * <p>
     * 文件下载被调用处理
     * </p>
     * 
     * @return 处理结果
     */
    public String downloadFile() throws Exception {
        return "success";
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSplitType() {
        return splitType;
    }

    public void setSplitType(String splitType) {
        this.splitType = splitType;
    }
}
