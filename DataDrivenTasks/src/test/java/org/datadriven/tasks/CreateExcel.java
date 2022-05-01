package org.datadriven.tasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcel {
	static String studentName;
	static String studentCourse;

	public CreateExcel(String name,String course) {
		studentName=name;
		studentCourse=course;
	}

	public static void main(String[] args) throws IOException {
		FileOutputStream fs=new FileOutputStream("E:\\DDFTasks.xlsx");
		Workbook workbook=new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Student");
		
		CreateExcel excel1=new CreateExcel("Ayyappan","Java");
		Row row1 = sheet.createRow(0);
		row1.createCell(1).setCellValue(excel1.studentCourse);
		row1.createCell(0).setCellValue(excel1.studentName);

		CreateExcel excel2=new CreateExcel("Guna","Selenium");
		Row row2 = sheet.createRow(1);
		row2.createCell(1).setCellValue(excel2.studentCourse);
		row2.createCell(0).setCellValue(excel2.studentName);
		
		CreateExcel excel3=new CreateExcel("Kumar","Oracle");
		Row row3 = sheet.createRow(2);
		row3.createCell(1).setCellValue(excel3.studentCourse);
		row3.createCell(0).setCellValue(excel3.studentName);
		
		CreateExcel excel4=new CreateExcel("Sangar","SQL");
		Row row4 = sheet.createRow(3);
		row4.createCell(1).setCellValue(excel4.studentCourse);
		row4.createCell(0).setCellValue(excel4.studentName);
		
		CreateExcel excel5=new CreateExcel("Viknesh","Python");
		Row row5 = sheet.createRow(4);
		row5.createCell(1).setCellValue(excel5.studentCourse);
		row5.createCell(0).setCellValue(excel5.studentName);
		
		CreateExcel excel6=new CreateExcel("Gokul","FrameWorks");
		Row row6 = sheet.createRow(5);
		row6.createCell(1).setCellValue(excel6.studentCourse);
		row6.createCell(0).setCellValue(excel6.studentName);
		
		CreateExcel excel7=new CreateExcel("Pavan","Katelon");
		Row row7 = sheet.createRow(6);
		row7.createCell(1).setCellValue(excel7.studentCourse);
		row7.createCell(0).setCellValue(excel7.studentName);
		
		CreateExcel excel8=new CreateExcel("Ajith","Cloud");
		Row row8 = sheet.createRow(7);
		row8.createCell(1).setCellValue(excel8.studentCourse);
		row8.createCell(0).setCellValue(excel8.studentName);
		
		CreateExcel excel9=new CreateExcel("Saba","C++");
		Row row9 = sheet.createRow(8);
		row9.createCell(1).setCellValue(excel9.studentCourse);
		row9.createCell(0).setCellValue(excel9.studentName);
		
		CreateExcel excel10=new CreateExcel("kumari","C");
		Row row10 = sheet.createRow(9);
		row10.createCell(1).setCellValue(excel10.studentCourse);
		row10.createCell(0).setCellValue(excel10.studentName);
		workbook.write(fs);
		
		System.out.println("Writing completed");
		
		File file=new File("E:\\DDFTasks.xlsx");
		FileInputStream fss=new FileInputStream(file);
		Workbook workbooks=new XSSFWorkbook(fss);
		Sheet sheetread = workbooks.getSheet("Student");
		System.out.println("Total rows "+sheetread.getPhysicalNumberOfRows());
		System.out.println("Total cells "+sheetread.getRow(0).getPhysicalNumberOfCells()*sheetread.getPhysicalNumberOfRows());
		sheet.createRow(10).createCell(0).setCellValue("sangar");;
		FileOutputStream fsss=new FileOutputStream(file);
		workbook.write(fsss);
		for(int i=0;i<sheetread.getPhysicalNumberOfRows();i++) {
			Row row = sheetread.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				System.out.println(row.getCell(j).toString());
			}

		}
	}}






