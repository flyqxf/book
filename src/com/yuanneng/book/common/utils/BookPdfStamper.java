package com.yuanneng.book.common.utils;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;


public class BookPdfStamper {

    //public static boolean waterMark(String inputFile, String imageFile,
    public static boolean waterMark(String inputFile, 
            String outputFile, String waterMarkName) {
        try {
            PdfReader reader = new PdfReader(inputFile);
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(
                    outputFile));
            //这里的字体设置比较关键，这个设置是支持中文的写法
//            BaseFont base = BaseFont.createFont("STSong-Light",
//                    "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);// 使用系统字体
            BaseFont bf = BaseFont.createFont("c:\\windows\\fonts\\simsun.ttc,1", BaseFont.IDENTITY_H, BaseFont.EMBEDDED); 
            int total = reader.getNumberOfPages() + 1;
            //Image image = Image.getInstance(imageFile);
            // 图片位置
            //image.setAbsolutePosition(110, 110);
           
            //image.setAbsolutePosition(10, -10); 
            PdfContentByte under;
            Rectangle pageRect = null;
            for (int i = 1; i < total; i++) {
                pageRect = stamper.getReader().
                           getPageSizeWithRotation(i);
                // 计算水印X,Y坐标
//                float x = pageRect.getWidth()/10;
//                float y = pageRect.getHeight()/10-10;
                
                float x = pageRect.getWidth()/2;
                float y = pageRect.getHeight()/2;
                // 获得PDF最顶层
                under = stamper.getOverContent(i);
                under.saveState();
                // set Transparency
                PdfGState gs = new PdfGState();
                // 设置透明度为0.2
                gs.setFillOpacity(1.f);
                under.setGState(gs);
                // 注意这里必须调用一次restoreState 否则设置无效
                under.restoreState();
                under.beginText();
                under.setFontAndSize(bf, 30);
                under.setColorFill(new BaseColor(238, 209, 212));
               
                // 水印文字成45度角倾斜
                under.showTextAligned(Element.ALIGN_CENTER
                        , waterMarkName, x,
                        y, 30);
                // 添加水印文字
                under.endText();
                under.setLineWidth(1f);
                under.stroke();
            }
            stamper.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void testPdf(String inputFile,String outputFile,String waterMmarkName) throws IOException, DocumentException {
      //读取原来的pdf
        //PdfReader reader = new PdfReader("E:/80 书籍/" + "给开发者的终极XSS防护备忘录.pdf");
        PdfReader reader = new PdfReader(inputFile);
        //生成以后的pdf
         PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(outputFile));
         int max = reader.getNumberOfPages();
         //max =2;
         // 文字水印
         for (int i = 1; i <= max; i++) {
         PdfContentByte over = stamp.getOverContent(i);
         over.beginText();
         BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);
         over.setFontAndSize(bf, 16);
         over.setTextMatrix(10, 10);
         over.setColorFill(BaseColor.GRAY);
         over.showTextAligned(Element.ALIGN_LEFT, "元能学习系统", 150,670, 45);
        // 0 0 0 表示左下脚 最后一个0是角度，0表示横着 45 表示斜着
         over.endText();
         }
          
         reader.close();

            stamp.close();
       
    }
    public static void main(String[] args) {
        BookPdfStamper t = new BookPdfStamper();

            String inputFile = "E:/80 书籍/" + "test.pdf";
            String outputFile = "E:/80 书籍/" + "test.pdf";
            //String waterMarkName = "元能学习系统  元能学习系统  元能学习系统  元能学习系统  元能学习系统  元能学习系统";
            String waterMarkName = "元能学习系统  元能学习系统  元能学习系统";
            //t.testPdf();
            t.waterMark(inputFile,  outputFile, waterMarkName);
       

    }

}
