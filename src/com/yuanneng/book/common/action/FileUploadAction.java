package com.yuanneng.book.common.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.yuanneng.book.common.utils.BusinessUtils;
import com.yuanneng.book.common.utils.Constant;

/**
 * FileUploadAction.java
 * 
 * 功 能： 文件上传共通Action
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.03.31         肖健            新规做成
 * </pre>
 */
public class FileUploadAction implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 日志
     */
    public static Logger logger = Logger.getLogger(FileUploadAction.class);

    /**
     * 定义文件存放项目路径（节点用户名密码导入）
     */
    private static final String fileSaveRealPathDis = "/upload/nodefound";

    /**
     * 文件保存的完整路径
     */
    private String uploadPath = Constant.STRING_BLANK;

    /**
     * 上传处理类型
     */
    private String uploadType = Constant.STRING_BLANK;

    /**
     * 上传文件
     */
    private File upload = null;

    /**
     * 上传文件名
     */
    private String uploadFileName = Constant.STRING_BLANK;

    /**
     * 文件上传大小限制
     */
    private String uploadMaxSize = Constant.STRING_BLANK;

    /**
     * 文件上传种类限制
     */
    private String uploadAcceptType = Constant.STRING_BLANK;

    /**
     * 文件上传异常信息
     */
    private String uploadErrorInfo = Constant.STRING_BLANK;

    /**
     * 创建文件上传目录
     * <p>
     * 根据目录路径创建文件目录并赋予权限,支持Win/Linux OS
     * </p>
     * 
     * @param savePath String 当前项目根路径
     * @return lastsFolderPath 文件目录路径 （savePath + /resources/ ）
     */
    private String createUploadFolder() {
        String filepath = Constant.STRING_BLANK;
        try {
            // 判断上传处理类型
            if (StringUtils.equals(uploadType, Constant.UPLOAD_TYPE_FLAG_ONE)) {
                // 节点用户名密码批量导入
                filepath = ServletActionContext.getServletContext()
                        .getRealPath(fileSaveRealPathDis);
            }
            File fp = new File(filepath);
            // 判断文件夹是否存在,如果不存在则创建文件夹
            if (!fp.exists()) {
                // 目录不存在的情况下，创建目录。
                fp.mkdirs();
                if (-1 != System.getProperties().getProperty("os.name").toLowerCase()
                        .indexOf("windows")) {
                    // WINDOWS系统
                    // 通过io File类对文件路径赋予读写权限
                    if (!fp.canRead()) {
                        fp.setReadable(true);
                    }
                    if (!fp.canWrite()) {
                        fp.setWritable(true);
                    }
                    if (!fp.canExecute()) {
                        fp.setExecutable(true);
                    }
                } else {
                    // 其它操作系统
                    // 通过untime.getRuntime().exec()执行command对文件路径赋予读写权限
                    String command = "chmod -R 755 " + filepath;
                    @SuppressWarnings("unused")
                    Runtime runtime = Runtime.getRuntime();
                    try {
                        @SuppressWarnings("unused")
                        Process exec = Runtime.getRuntime().exec(command);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filepath;
    }

    /**
     * 文件上传主处理
     * <p>
     * 将指定文件上传到相应的文件目录
     * </p>
     * 
     * @return 处理结果
     */
    public String fileUpload() {
        // 获取文件上传路径
        String path = createUploadFolder();
        try {
            if (upload != null) {
                File file = getUpload();
                // 检测上传文件大小的合法性
                if (!isValidFileSize(file)) {
                    String msg = "上传文件大小超过限定！";
                    logger.error(msg);
                    setUploadErrorInfo(msg);
                    return "success";
                }
                // 检测上传文件类型的合法性
                if (!isValidFileType()) {
                    String msg = "上传文件类型与限定类型不匹配！";
                    logger.error(msg);
                    setUploadErrorInfo(msg);
                    return "success";
                }
                // 采用时间+UUID的方式随即命名
                String fileName = BusinessUtils.getUUID();
                // 保存在硬盘中的文件名
                String name = fileName + uploadFileName.substring(uploadFileName.lastIndexOf("."));

                FileInputStream inputStream = new FileInputStream(file);
                FileOutputStream outputStream = new FileOutputStream(path + Constant.VIRGULE + name);
                byte[] buf = new byte[1024];
                int length = 0;
                while ((length = inputStream.read(buf)) != -1) {
                    outputStream.write(buf, 0, length);
                }
                inputStream.close();
                outputStream.close();
                // 文件保存的完整路径
                setUploadPath(path + Constant.VIRGULE + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    /**
     * 检测文件大小的合法性
     * 
     * @param file 上传文件
     * @return 检测结果
     */
    private boolean isValidFileSize(File file) {
        if (StringUtils.isEmpty(uploadMaxSize)) {
            String msg = "未设定文件上传大小限制！";
            logger.error(msg);
            setUploadErrorInfo(msg);
            return false;
        }
        if (file.length() > Long.parseLong(uploadMaxSize)) {
            return false;
        }
        return true;
    }

    /**
     * 检测文件类型的合法性
     * 
     * @param file 上传文件
     * @return 检测结果
     */
    private boolean isValidFileType() {
        if (StringUtils.isEmpty(uploadAcceptType)) {
            String msg = "未设定文件上传类型限制！";
            logger.error(msg);
            setUploadErrorInfo(msg);
            return false;
        }
        String[] types = uploadAcceptType.split(Constant.COMMA);
        String fileType = uploadFileName.substring(uploadFileName.lastIndexOf(Constant.DOT) + 1)
                .toLowerCase();
        for (String key : types) {
            if (StringUtils.equals(key.toLowerCase(), fileType)) {
                return true;
            }
        }
        return false;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public String getUploadType() {
        return uploadType;
    }

    public File getUpload() {
        return upload;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public void setUploadType(String uploadType) {
        this.uploadType = uploadType;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getUploadMaxSize() {
        return uploadMaxSize;
    }

    public String getUploadAcceptType() {
        return uploadAcceptType;
    }

    public void setUploadMaxSize(String uploadMaxSize) {
        this.uploadMaxSize = uploadMaxSize;
    }

    public void setUploadAcceptType(String uploadAcceptType) {
        this.uploadAcceptType = uploadAcceptType;
    }

    public String getUploadErrorInfo() {
        return uploadErrorInfo;
    }

    public void setUploadErrorInfo(String uploadErrorInfo) {
        this.uploadErrorInfo = uploadErrorInfo;
    }
}
