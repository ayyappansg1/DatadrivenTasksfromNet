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

public class Naukri {
	static WebDriver driver;
	public void launchbrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.naukri.com/registration/createAccount");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	public static void main(String[] args) throws IOException, InvalidFormatException {
		Naukri adactins=new Naukri();
		adactins.launchbrowser();
		File file=new File("C:\\Users\\ADMIN\\Desktop\\DataDriven\\naukri.xlsx");
		FileInputStream fss=new FileInputStream(file);
		Workbook workbooks=new XSSFWorkbook(fss);
		Sheet sheetread = workbooks.getSheet("Sheet1");
		WebElement fullname = driver.findElement(By.id("name"));
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement phone = driver.findElement(By.id("mobile"));
		
		for(int i=1;i<sheetread.getPhysicalNumberOfRows();i++) {
			Row row = sheetread.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				if(j==0) {
					fullname.sendKeys(row.getCell(j).toString());
				}else if(j==1) {
					email.sendKeys(row.getCell(j).toString());
				}else if(j==2) {
					password.sendKeys(row.getCell(j).toString());
				}else if(j==3) {
					phone.sendKeys(row.getCell(j).toString());
				}
			}
		}
		
		
	}}






