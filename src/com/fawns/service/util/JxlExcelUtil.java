/* 
 * Copyright (C) 2013-2014 mawenqiang
 *
 * FileName: JxlExcelUtil.java 
 *
 * Created: [2014-1-23 下午02:59:09] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2014-1-23 下午02:59:09
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/
package com.fawns.service.util;

import java.io.IOException;
import java.io.OutputStream;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.DateFormat;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/** 
 *
 * Description: JxlExcel样式工具类
 *
 * @author mawenqiang
 * </pre>
 */

public class JxlExcelUtil {
	
	public static final int  TITLEROWVIEW = 600;
	
	public static final int COLUMNVIEW = 25;
	
	public static final int CONTENTROWVIEW = 400;
	
	/**
	 * 
	 * Description: 创建workbook
	 *
	 * @param 
	 * @return WritableWorkbook
	 * @throws 
	 * @Author Administrator
	 * Create Date: 2011-10-31 下午04:16:37
	 */
	public static WritableWorkbook createWorkbook(OutputStream os) throws WriteException, IOException{
		WritableWorkbook workbook = Workbook.createWorkbook(os);
		return workbook;
	}
	/**
	 * 
	 * Description: 创建sheet
	 *
	 * @param 
	 * @return WritableSheet
	 * @throws 
	 * @Author Administrator
	 * Create Date: 2011-10-31 下午04:16:28
	 */
	public static WritableSheet createSheet(WritableWorkbook workbook,String title,int columnWidth,int rowHeight){
		WritableSheet sheet = workbook.createSheet(title, 0);
		sheet.getSettings().setDefaultColumnWidth(columnWidth);
		sheet.getSettings().setDefaultRowHeight(rowHeight);
		return sheet;
	}
	/**
	 * 
	 * Description: 创建cell样式
	 *
	 * @param 
	 * @return WritableCellFormat
	 * @throws 
	 * @Author Administrator
	 * Create Date: 2011-10-31 下午04:21:24
	 */
	public static WritableCellFormat createCellFormat(){
		WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
		WritableCellFormat wcf = new WritableCellFormat(wf); /* 单元格定义 */
		try {
			wcf.setBackground(jxl.format.Colour.BLACK);/* 设置单元格的背景颜色 */
			wcf.setAlignment(jxl.format.Alignment.CENTRE); /* 设置对齐方式  水平居中*/
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);/* 垂直居中 */
			wcf.setBorder(Border.ALL,BorderLineStyle.THIN);/* 边框 */
			wcf.setWrap(true); //自动换行
		} catch (WriteException e) {
			e.printStackTrace();
		} 
		return wcf;
	}
	
	/**
	 * 
	 * Description:  生成日期格式的单元格
	 *
	 * @param  type: 1.代表格式"yyyy-MM-dd  hh:mm:ss"，2.代表格式"yyyy-MM-dd"
	 * @return WritableCellFormat
	 * @throws Exception if has error
	 * @Author wbwang
	 * Create Date: 2012-10-31 下午03:07:24
	 */
	public static WritableCellFormat createDateCellFormat(String type){
		DateFormat df = null;
		if("1".equals(type)){
			df = new DateFormat("yyyy-MM-dd  hh:mm:ss");
		}else if("2".equals(type)){
			df = new DateFormat("yyyy-MM-dd");
		}
		WritableCellFormat wcf = new WritableCellFormat(df); /* 单元格定义 */
		try {
			wcf.setBackground(jxl.format.Colour.BLACK);/* 设置单元格的背景颜色 */
			wcf.setAlignment(jxl.format.Alignment.CENTRE); /* 设置对齐方式  水平居中*/
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);/* 垂直居中 */
			wcf.setBorder(Border.ALL,BorderLineStyle.THIN);/* 边框 */
			wcf.setWrap(true); //自动换行
		} catch (WriteException e) {
			e.printStackTrace();
		} 
		return wcf;
	}
	
	/**
	 * 
	 * Description: 生成货币格式的单元格
	 *
	 * @param 
	 * @return WritableCellFormat
	 * @throws Exception if has error
	 * @Author wbwang
	 * Create Date: 2012-11-6 下午05:54:39
	 */
	public static WritableCellFormat createNumberCellFormat(){
		NumberFormat df = new NumberFormat("￥##,##0.00");
		//NumberFormat df = new NumberFormat(NumberFormat.FRACTION_THREE_DIGITS);
		WritableCellFormat wcf = new WritableCellFormat(df); /* 单元格定义 */
		try {
			wcf.setBackground(jxl.format.Colour.BLACK);/* 设置单元格的背景颜色 */
			wcf.setAlignment(jxl.format.Alignment.CENTRE); /* 设置对齐方式  水平居中*/
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);/* 垂直居中 */
			wcf.setBorder(Border.ALL,BorderLineStyle.THIN);/* 边框 */
			wcf.setWrap(true); //自动换行
		} catch (WriteException e) {
			e.printStackTrace();
		} 
		return wcf;
	}
	
	/**
	 * Description: 
	 * 设置excel的题目
	 * @param 
	 * @return WritableCellFormat
	 * @throws 
	 * @Author ydw
	 * Create Date: 2011-11-4 下午01:43:16
	 */
	public static WritableCellFormat createBigTitleCellFormat(){
		WritableFont wf = new WritableFont(WritableFont.ARIAL, 20 ,WritableFont.BOLD, false ,UnderlineStyle.NO_UNDERLINE,Colour.BLACK);
		WritableCellFormat wcf = new  WritableCellFormat(wf);
		try {
			wcf.setAlignment(Alignment.CENTRE);
			wcf.setBorder(Border.ALL,BorderLineStyle.THIN);
		} catch (WriteException e) {
			e.printStackTrace();
		}  
		return wcf;
	}
	
	/**
	 * Description: 
	 * 设置excel显示列表的标题
	 * @param 
	 * @return WritableCellFormat
	 * @throws 
	 * @Author ydw
	 * Create Date: 2011-11-4 下午02:01:48
	 */
	public static WritableCellFormat createTitleCellFormat(){
		WritableFont wf = new WritableFont(WritableFont.TIMES, 14 ,WritableFont.BOLD, false );  
		WritableCellFormat wcf = new  WritableCellFormat(wf);
		try {
			wcf.setBackground(Colour.BLACK);/* 设置单元格的背景颜色 */
			wcf.setAlignment(Alignment.CENTRE); /* 设置对齐方式  水平居中*/
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);/* 垂直居中 */
			wcf.setBorder(Border.ALL,BorderLineStyle.THIN);/* 边框 */
		} catch (WriteException e) {
			e.printStackTrace();
		}
		return wcf;
	}
	
	public static WritableCellFormat createDigitalCellFormat(){
		NumberFormat df = new NumberFormat("##,##0.00");
		WritableCellFormat wcf = new WritableCellFormat(df); /* 单元格定义 */
		try {
			wcf.setBackground(jxl.format.Colour.BLACK);/* 设置单元格的背景颜色 */
			wcf.setAlignment(jxl.format.Alignment.CENTRE); /* 设置对齐方式  水平居中*/
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);/* 垂直居中 */
			wcf.setBorder(Border.ALL,BorderLineStyle.THIN);/* 边框 */
			wcf.setWrap(true); //自动换行
		} catch (WriteException e) {
			e.printStackTrace();
		} 
		return wcf;
	}
	
	/**
	 * 
	 * Description: 生成百分比格式的单元格
	 *
	 * @param 
	 * @return WritableCellFormat
	 * @throws Exception if has error
	 * @Author wbwang
	 * @Create Date: 2013-1-29 下午02:06:47
	 */
	public static WritableCellFormat createPercentageNumberCellFormat(){
		NumberFormat df = new NumberFormat("0.00%");
		//NumberFormat df = new NumberFormat(NumberFormat.FRACTION_THREE_DIGITS);
		WritableCellFormat wcf = new WritableCellFormat(df); /* 单元格定义 */
		try {
			wcf.setBackground(jxl.format.Colour.BLACK);/* 设置单元格的背景颜色 */
			wcf.setAlignment(jxl.format.Alignment.CENTRE); /* 设置对齐方式  水平居中*/
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);/* 垂直居中 */
			wcf.setBorder(Border.ALL,BorderLineStyle.THIN);/* 边框 */
			wcf.setWrap(true); //自动换行
		} catch (WriteException e) {
			e.printStackTrace();
		} 
		return wcf;
	}
}
