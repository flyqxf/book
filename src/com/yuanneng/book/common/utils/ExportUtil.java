package com.yuanneng.book.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import com.csvreader.CsvWriter;


public class ExportUtil {
    public static File exportCSV(List<List<String>> list,String[] title, String filePath) throws IOException{
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = sdf.format(dt);
        int idx = filePath.lastIndexOf(".");
        String filePathLeft = filePath.substring(0,idx);
        String filePathRight = filePath.substring(idx);
        filePath = filePathLeft+time+filePathRight;
        File file = new File(filePath);
        if(file.exists()) {
            file = exportCSV(list,title,filePath);
        } else {
            CsvWriter wr = new CsvWriter(filePath, ',', Charset.forName("UTF-8"));
            wr.writeRecord(title);
            for(List<String> lst: list) {
            String[] contents = lst.toArray(new String[lst.size()]);
            wr.writeRecord(contents);
            }
        
            wr.close();
        }
        return file;
    }
    
    public static File exportExcel(List<List<String>> list,String[] title, String filePath) throws IOException{
        
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = sdf.format(dt);
        int idx = filePath.lastIndexOf(".");
        String filePathLeft = filePath.substring(0,idx);
        String filePathRight = filePath.substring(idx);
        filePath = filePathLeft+time+filePathRight;
        File file = new File(filePath);//"/tmp/tmpfiles/workbook.xls"
        if(file.exists()) {
            file = exportExcel(list,title,filePath);
        } else {
            FileOutputStream fileOut = new FileOutputStream(filePath);//创建excel表格//"/tmp/tmpfiles/workbook.xls"
            Workbook wb = new HSSFWorkbook();//获取workbook
            //FileOutputStream fileOut = new FileOutputStream("workbook.xls");
            HSSFSheet sheet = (HSSFSheet) wb.createSheet("report");// 生成一个表格
         
            sheet.setColumnWidth(1, 4000);
        
            HSSFRow row = sheet.createRow((short)0);//创建行并插入表头
            for(int i = 0; i< title.length;i++) {
                row.createCell(i).setCellValue(title[i]);
            }
       
            for(int i = 0;i<list.size();i++) {
                row = sheet.createRow(i+1);
                List<String> lst = list.get(i);
                for(int j=0;j<lst.size();j++) {
                    row.createCell(j).setCellValue(lst.get(j));
                }
            }

            wb.write(fileOut);
            wb.close();
            fileOut.close();
        }
        return file;
    }
}
