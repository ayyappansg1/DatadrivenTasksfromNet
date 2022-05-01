package org.datadriven.tasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookLogin {
	static WebDriver driver;
	public void launchbrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");}
	public static void main(String[] args) throws IOException, InvalidFormatException {
		FacebookLogin fb=new FacebookLogin();
		fb.launchbrowser();
		File file=new File("C:\\Users\\ADMIN\\Desktop\\DataDriven\\facebook.xlsx");
		FileInputStream fss=new FileInputStream(file);
		Workbook workbooks=new XSSFWorkbook(fss);
		Sheet sheetread = workbooks.getSheet("Sheet1");
		WebElement username = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		WebElement loginbtn = driver.findElement(By.name("login"));
		for(int i=1;i<sheetread.getPhysicalNumberOfRows();i++) {
			Row row = sheetread.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				if(j==0) {
				username.sendKeys(row.getCell(j).toString());
				}else if(j==1) {
					password.sendKeys(row.getCell(j).toString());
					loginbtn.click();
				}}}
		workbooks.close();
		WebElement error = driver.findElement(By.xpath("//div[@class='_9ay7']"));
		FileOutputStream fs=new FileOutputStream(file);
		Workbook workbook=new XSSFWorkbook();
		Sheet sheet = workbook.getSheet("Sheet1");
		Row rownum = sheet.createRow(2);
		rownum.createCell(0).setCellValue(error.getText());
		workbook.write(fs);
		driver.quit();
		
		
	}}






