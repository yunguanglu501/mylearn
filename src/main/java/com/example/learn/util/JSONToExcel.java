package com.example.learn.util;

/**
 * JSONToExcel
 *
 * @author wcy
 * @date 2022/8/24
 */
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.Set;

public class JSONToExcel {
    public static void main(String[] args) throws IOException {
        Set<String> keys = null;
        // 创建HSSFWorkbook对象
        HSSFWorkbook wb = new HSSFWorkbook();
        // 创建HSSFSheet对象
        HSSFSheet sheet = wb.createSheet("sheet0");

        FileReader reader = new FileReader("D:\\json.txt");
        BufferedReader br = new BufferedReader(reader);
        String str = null;
        int roleNo = 0;
        int rowNo = 0;
        while ((str = br.readLine()) != null) {
            JSONObject jsonObject = JSONObject.parseObject(str);
            // 创建HSSFRow对象
            HSSFRow row = sheet.createRow(roleNo++);
            // 创建HSSFCell对象
            if (keys == null) {
                //标题
                keys = jsonObject.keySet();
                for (String s : keys) {
                    HSSFCell cell = row.createCell(rowNo++);
                    cell.setCellValue(s);
                }
                rowNo = 0;
                row = sheet.createRow(roleNo++);
            }

            for (String s : keys) {
                HSSFCell cell = row.createCell(rowNo++);
                cell.setCellValue(jsonObject.getString(s));
            }
            rowNo = 0;
            System.out.println(rowNo);

        }

        br.close();
        reader.close();

        // 输出Excel文件
        FileOutputStream output = new FileOutputStream("c://target.xls");
        wb.write(output);
        wb.close();
        output.flush();
        output.close();
    }
}

