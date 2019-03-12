/*
 * @(#)AuthCodeAction.java
 */
package com.yuanneng.book.sysmanage.action.useraction;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.yuanneng.book.common.action.CommonAction;
import com.yuanneng.book.sysmanage.entity.ValidateCode;

/**
 * AuthCodeAction.java
 * 
 * 功 能： 用户登录验证
 * 
 * <pre>
 * ver     修订日             作者            修订内容
 * 1.0     2016.04.13         shanjixiang        新规做成
 * </pre>
 */
public class AuthCodeAction extends CommonAction {

    /**
     * 日志
     */
    public static Logger logger = Logger.getLogger(AuthCodeAction.class);

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 验证码图片
     */
    private BufferedImage codeImg = null;

    @Override
    public String doMain() throws Exception {

        /** 获得HttpServletResponse */
        HttpServletResponse response = this.getResponse();
        /** 设置响应的类型格式为图片格式 */
        response.setContentType("image/png");

        /** 禁止图像缓存。 */
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        /** 生成ValidateCode验证码类 */
        ValidateCode vCode = new ValidateCode(80, 30, 4, 20);

        /** 获得验证码图片 */
        codeImg = vCode.getBuffImg();

        /** 获得输出流向页面输出验证码图片 */
        ServletOutputStream sos = response.getOutputStream();
        ImageIO.write(codeImg, "png", sos);

        /** 获取验证码内容 */
        String code = vCode.getCode();

        logger.debug("code:@@@@@@@@@@@@:" + code);
        /** 验证码内容存入session */
        if (code != null) {
            HttpSession session = this.getSession();
            session.setAttribute("code", code);
        }
        /** 刷新关闭输出流 */
        sos.flush();
        //sos.close();
        return null;
    }
}
