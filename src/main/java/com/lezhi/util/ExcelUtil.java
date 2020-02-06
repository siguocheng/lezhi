package com.lezhi.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;


public class ExcelUtil {
	public static HSSFWorkbook createSimcardTable() {
		HSSFWorkbook tb = new HSSFWorkbook();
		HSSFSheet sheet = tb.createSheet("SIM卡模板下载");
        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle style = tb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);;
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("ICCID");
        cell.setCellStyle(style);
 
		cell = row.createCell(1);
		cell.setCellValue("Carrier");
		cell.setCellStyle(style);

		cell = row.createCell(2);
		cell.setCellValue("手机号");
		cell.setCellStyle(style);
		
		cell = row.createCell(3);
		cell.setCellValue("导入时间");
		cell.setCellStyle(style);

		
		for (int i = 0; i < 3; i++) {
	        row = sheet.createRow(i + 1);
	        // 创建单元格，设置值
	        row.createCell(0).setCellValue("12345678"+i);
	        row.createCell(1).setCellValue("中国电信");
	        row.createCell(2).setCellValue("15002586598");
	        row.createCell(3).setCellValue("2018/01/01 01:01:01");
	        sheet.autoSizeColumn(i);
	    }
		return tb;
	}
	
	public static HSSFWorkbook createEquipmentTable() {
		HSSFWorkbook tb = new HSSFWorkbook();
		HSSFSheet sheet = tb.createSheet("设备模板下载");
		 // 设置列宽   
		sheet.setColumnWidth(0, 9000);   
		sheet.setColumnWidth(1, 9000);   
        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle style = tb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);;
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("编号");
        cell.setCellStyle(style);
        
		cell = row.createCell(1);
		cell.setCellValue("序列号");
		cell.setCellStyle(style);

		
//		for (int i = 0; i < 3; i++) {
//	        row = sheet.createRow(i + 1);
//	        // 创建单元格，设置值
//	        row.createCell(0).setCellValue("12345678"+i);
//	        row.createCell(1).setCellValue("中国电信");
//	        row.createCell(2).setCellValue("15002586598");
//	        row.createCell(3).setCellValue("2018/01/01 01:01:01");
//	        sheet.autoSizeColumn(i);
//	    }
		return tb;
	}

}
