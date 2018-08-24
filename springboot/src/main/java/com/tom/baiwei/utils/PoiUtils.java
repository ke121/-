package com.tom.baiwei.utils;

import com.tom.baiwei.model.Employee;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class PoiUtils {
    //返回一个responseEntity实现下载功能
    public static ResponseEntity<byte[]> exportExcel(List<Employee> employees) throws IOException {
        //创建一个excel文件
        HSSFWorkbook workbook = new HSSFWorkbook() ;
        //先创建一个文档信息
        workbook.createInformationProperties();
        //然后获取这个文档信息
        DocumentSummaryInformation doinfo = workbook.getDocumentSummaryInformation();
        doinfo.setCategory("员工资料");
        doinfo.setCompany("尚学堂");
        doinfo.setManager("tom");
        SummaryInformation summaryInformation = workbook.getSummaryInformation();
        summaryInformation.setAuthor("tom");
        summaryInformation.setTitle("员工资料表");
        //创建一个表单实例
        HSSFSheet sheet = workbook.createSheet("尚学堂员工资料表");
        //创建一行
        HSSFRow row = sheet.createRow(0);
        HSSFCell c0 = row.createCell(0, CellType.STRING);
        c0.setCellValue("员工姓名");
        HSSFCell c1 = row.createCell(1, CellType.STRING);
        c1.setCellValue("性别");
        HSSFCell c2 = row.createCell(2, CellType.NUMERIC);
        c2.setCellValue("出生日期");
        HSSFCellStyle dateCellStyle = workbook.createCellStyle();
        sheet.setColumnWidth(0, 30 * 256);
        sheet.setColumnWidth(1, 30 * 256);
        sheet.setColumnWidth(2, 30 * 256);
        dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
        for(int i = 0 ; i < employees.size() ; i++){
            HSSFRow row1 = sheet.createRow(i+1);
            HSSFCell c10 = row1.createCell(0, CellType.STRING);
            c10.setCellValue(employees.get(i).getName());
            HSSFCell c20 = row1.createCell(1, CellType.STRING);
            c20.setCellValue(employees.get(i).getGender());
            HSSFCell c30 = row1.createCell(2, CellType.STRING);
            c30.setCellValue(employees.get(i).getBirthday());
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream() ;
        workbook.write(baos);
        HttpHeaders headers = new HttpHeaders() ;
        headers.setContentDispositionFormData("attachment", new String("员工资料表.xls".getBytes(), "ISO-8859-1"));
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return  new ResponseEntity<byte[]>(baos.toByteArray(),headers, HttpStatus.CREATED) ;

    }
}
