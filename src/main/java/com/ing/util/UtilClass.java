package com.ing.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ing.base.BaseClass;

public class UtilClass extends BaseClass

{
	public static long PAGE_LOAD_TIMESOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	static Workbook book;
	static Sheet sheet;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(System.getProperty("user.dir") + "TESTDATA_SHEET_PATH");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static void scrolltoElement(WebElement element) throws Exception {

		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		System.out.println("x:" + x + "y:" + y);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
		Thread.sleep(2000);
	}

	public static void writeDataToNotePad(By locator, String path) throws IOException {
		try {
			File file = new File(System.getProperty("user.dir") + path);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + path);
			PrintWriter pw = new PrintWriter(fos);

			List<WebElement> list = driver.findElements(locator);
			List<String> currentOptions = new ArrayList<String>();

			for (WebElement option : list) {

				currentOptions.add(option.getText());
			}

			for (int i = 0; i < currentOptions.size(); i++) {
				String text = currentOptions.get(i);
				// System.out.println(text);
				pw.println(text);

				// Assert.assertTrue(text.toLowerCase().equals(.toLowerCase)
				// byte[] contentInBytes=text.getBytes();
				// fos.write(contentInBytes);
				// pw.println(contentInBytes);

			}
			pw.flush();
		}

		catch (IOException ioe) {
			System.out.println("Exception occurred:");
			ioe.printStackTrace();
		}

	}

	public static void TextFileReading(By locator, String path) {

		try {
			FileReader reader = new FileReader(System.getProperty("user.dir") + path);
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line;

			while ((line = bufferedReader.readLine()) != null) {

				System.out.println(line);
			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void countPdf(By locator) throws Exception {

		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(locator);
		int count = 0;
		for (WebElement e : list) {
			if (e.getText().endsWith("PDF")) {
				count++;
				// e.click();
			}
		}

		System.out.println(count);
	}

	public static void dowloadpdf(By locator) throws Exception {
		List<WebElement> list = driver.findElements(locator);
		int count = 0;
		for (WebElement e : list) {
			if (e.getText().endsWith("PDF")) {
				count++;
			}
		}
		System.out.println(count);

	}
}
