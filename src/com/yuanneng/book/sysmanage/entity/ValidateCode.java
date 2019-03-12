/*
 * @(#)ValidateCode.java
 */
package com.yuanneng.book.sysmanage.entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.yuanneng.book.common.entity.CommonBean;

/**
 * ValidateCode.java
 * 
 * 功 能： 验证码生成器
 * 
 * <pre>
 * ver      修订日              作者            修订内容
 * -----------------------------------------------------
 * 1.0     2016.04.15         shanjixiang        新规做成
 * </pre>
 */
public class ValidateCode extends CommonBean {

    /**
     * UID
     */
    private static final long serialVersionUID = 1L;

    /** 图片的宽度。 */
    private int width = 0;

    /** 图片的高度。 */
    private int height = 0;

    /** 验证码字符个数 */
    private int codeCount = 0;

    /** 验证码干扰线数 */
    private int lineCount = 0;

    /** 验证码 */
    private String code = null;

    /** 验证码图片Buffer */
    private BufferedImage buffImg = null;

    /** 去掉1，I，0，O, */
    private char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
            'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6',
            '7', '8', '9' };

    /**
     * 
     * @param width 图片宽
     * @param height 图片高
     * @param codeCount 字符个数
     * @param lineCount 干扰线条数
     * @throws IOException
     */
    public ValidateCode(int width, int height, int codeCount, int lineCount) throws IOException {
        this.width = width;
        this.height = height;
        this.codeCount = codeCount;
        this.lineCount = lineCount;
        this.createCode();
    }

    public void createCode() throws IOException {
        int x = 0, fontHeight = 0, codeY = 0;
        int red = 0, green = 0, blue = 0;

        /** 每个字符的宽度 */
        x = width / codeCount;
        /** 字体的高度 */
        fontHeight = height - 10;
        codeY = height - 4;

        /** 图像buffer */
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImg.createGraphics();
        /** 生成随机数 */
        Random random = new Random();
        /** 将图像填充为白色 */
        g.setColor(Color.WHITE);
        
        //g.setColor(Color.GRAY);
        g.fillRect(0, 0, width, height);

        for (int i = 0; i < lineCount; i++) {
            int xs = random.nextInt(width);
            int ys = random.nextInt(height);
            int xe = xs + random.nextInt(width / 8);
            int ye = ys + random.nextInt(height / 8);
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            g.setColor(new Color(red, green, blue));
            g.drawLine(xs, ys, xe, ye);
        }
        buffImg = convert(buffImg);
        g = buffImg.createGraphics();
        /** 创建字体 */
        ImgFontByte imgFont = new ImgFontByte();
        Font font = imgFont.getFont(fontHeight);
        g.setFont(font);
        /** randomCode记录随机产生的验证码 */
        StringBuffer randomCode = new StringBuffer();
        /** 随机产生codeCount个字符的验证码。 */
        for (int i = 0; i < codeCount; i++) {
            String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            /** 产生随机的颜色值，让输出的每个字符的颜色值都将不同。 */
            g.setColor(new Color(1f, 1f, 1f, 0.5f));
            g.drawString(strRand, i * x, codeY);
            /** 将产生的四个随机数组合在一起。 */
            randomCode.append(strRand);
        }
        /** 将四位数字的验证码保存到Session中。 */
        code = randomCode.toString();
    }

    /**
     * 图片透明化
     * 
     * @param img
     * @return
     * @throws IOException
     */
    public static BufferedImage convert(BufferedImage img) throws IOException {
        BufferedImage bufferedImage = null;
        BufferedImage image = img;
        ImageIcon imageIcon = new ImageIcon(image);
        bufferedImage = new BufferedImage(imageIcon.getIconWidth(), imageIcon.getIconHeight(),
                BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g2D = (Graphics2D) bufferedImage.getGraphics();
        g2D.drawImage(imageIcon.getImage(), 0, 0, imageIcon.getImageObserver());
        int alpha = 0;
        for (int j1 = bufferedImage.getMinY(); j1 < bufferedImage.getHeight(); j1++) {
            for (int j2 = bufferedImage.getMinX(); j2 < bufferedImage.getWidth(); j2++) {
                int rgb = bufferedImage.getRGB(j2, j1);
                if (colorInRange(rgb))
                    alpha = 0;
                else
                    alpha = 255;
                rgb = (alpha << 24) | (rgb & 0x00ffffff);
                bufferedImage.setRGB(j2, j1, rgb);
            }
        }
        g2D.drawImage(bufferedImage, 0, 0, imageIcon.getImageObserver());
        return bufferedImage;
    }

    public static int color_range = 210;

    public static Pattern pattern = Pattern.compile("[0-9]*");

    public static boolean isNo(String str) {
        return pattern.matcher(str).matches();
    }

    public static boolean colorInRange(int color) {
        int red = (color & 0xff0000) >> 16;
        int green = (color & 0x00ff00) >> 8;
        int blue = (color & 0x0000ff);
        if (red >= color_range && green >= color_range && blue >= color_range)
            return true;
        return false;
    }

    public void write(String path) throws IOException {
        OutputStream sos = new FileOutputStream(path);
        this.write(sos);
    }

    public void write(OutputStream sos) throws IOException {
        ImageIO.write(buffImg, "png", sos);
        sos.close();
    }

    public BufferedImage getBuffImg() throws IOException {
        // return convert(buffImg);
        return buffImg;
    }

    public String getCode() {
        return code;
    }
}
