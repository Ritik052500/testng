package demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;

public class BootstrapDatePicker extends Base{

	@Test(groups = {"one"})
	public void date() throws ParseException, InterruptedException {
		driver.get("http://demo.seleniumeasy.com/bootstrap-date-picker-demo.html");
		WebElement calendar = driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-th']"));
		calendar.click();
		String currentMonthYear = driver.findElements(By.xpath("//th[@class='datepicker-switch']")).get(0).getText();
		Date currentDate = onscreen.parse(currentMonthYear);
		WebElement leftArrow = driver.findElements(By.xpath("//th[@class='prev']")).get(0);
		Date desiredDate = onscreen.parse("March 2023");
		while(desiredDate.before(currentDate)) {
			leftArrow.click();
			currentMonthYear = driver.findElements(By.xpath("//th[@class='datepicker-switch']")).get(0).getText();
			currentDate = onscreen.parse(currentMonthYear);
		}
		driver.findElement(By.xpath("//div[@class='datepicker-days']//tbody//td[text()='7']")).click();
	}
	
	@Test
	public void dateRange() throws ParseException, InterruptedException {
		driver.get("http://demo.seleniumeasy.com/bootstrap-date-picker-demo.html");
		
		String desiredStart = "January 16 2023";
		String desiredEnd = "April 21 2023";
		
		SimpleDateFormat format = new SimpleDateFormat("MMMM dd yyyy");
		
		WebElement start = driver.findElement(By.xpath("//div[@class='input-daterange input-group']/input[1]"));
		WebElement end = driver.findElement(By.xpath("//div[@class='input-daterange input-group']/input[2]"));
		
		start.click();
		
		WebElement leftArrow = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='prev']"));
		
		String startOnscreen = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']")).getText();
		Date startDate = onscreen.parse(startOnscreen);
		
		Date desiredStartDate = format.parse(desiredStart);
		Date desiredEndDate = format.parse(desiredEnd);
		
		while(desiredStartDate.before(startDate)) {
			leftArrow.click();
			startOnscreen = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']")).getText();
			startDate = onscreen.parse(startOnscreen);
			if(!desiredStartDate.before(startDate)) {
				driver.findElement(By.xpath("//div[@class='datepicker-days']//tbody//td[text()='"+desiredStartDate.getDate()+"']")).click();
			}
		}
		
		end.click();
		
		WebElement rightArrow = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next']"));
		
		String endOnscreen = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']")).getText();
		Date endDate = onscreen.parse(endOnscreen);
		
		while(onscreen.parse("April 2023").after(endDate)) {
			rightArrow.click();
			endOnscreen = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']")).getText();
			endDate = onscreen.parse(endOnscreen);
			if(!onscreen.parse("April 2023").after(endDate)) {
				driver.findElement(By.xpath("//div[@class='datepicker-days']//tbody//td[text()='"+desiredEndDate.getDate()+"']")).click();
			}
		}
	}


}
