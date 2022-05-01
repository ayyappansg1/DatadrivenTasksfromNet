package org.datadriven.tasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

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
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Adactin {
	static WebDriver driver;
	public void launchbrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://adactinhotelapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));}
	public static void main(String[] args) throws IOException, InvalidFormatException {
		Adactin adactins=new Adactin();
		adactins.launchbrowser();
		File file=new File("C:\\Users\\ADMIN\\Desktop\\DataDriven\\adactin.xlsx");
		FileInputStream fss=new FileInputStream(file);
		Workbook workbooks=new XSSFWorkbook(fss);
		Sheet sheetread = workbooks.getSheet("Sheet1");
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
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
		WebElement location = driver.findElement(By.id("location"));
		Select select=new Select(location);
		select.selectByValue(sheetread.getRow(1).getCell(2).toString());
		WebElement hotels = driver.findElement(By.id("hotels"));
		Select selecthotel=new Select(hotels);
		selecthotel.selectByValue(sheetread.getRow(1).getCell(3).toString());
		WebElement roomtype = driver.findElement(By.id("room_type"));
		Select selectroomtype=new Select(roomtype);
		selectroomtype.selectByValue(sheetread.getRow(1).getCell(4).toString());
		WebElement rooms = driver.findElement(By.name("room_nos"));
		Select selectroomnumer=new Select(rooms);
		selectroomnumer.selectByIndex(2);
		workbooks.close();
	}}






