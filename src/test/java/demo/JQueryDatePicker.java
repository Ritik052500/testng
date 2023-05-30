package demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;

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

public class JQueryDatePicker extends Base  {
	
	@Test(groups = {"three"})
	public void dateRange() throws ParseException, InterruptedException {
		driver.get("http://demo.seleniumeasy.com/jquery-date-picker-demo.html");
		
		SimpleDateFormat format = new SimpleDateFormat("MMMM dd yyyy");
		WebElement from = driver.findElement(By.id("from"));
		WebElement to = driver.findElement(By.id("to"));
		
		String desiredFrom = "January 16 2023";
		String desiredTo = "April 21 2023";
		
		Date desiredFromDate = format.parse(desiredFrom);
		Date desiredToDate = format.parse(desiredTo);
		
		from.click();
		
		Select month = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		month.selectByVisibleText("Jan");
		driver.findElement(By.xpath("//a[text()='"+desiredFromDate.getDate()+"']")).click();
	
		to.click();
		
		month = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		month.selectByVisibleText("Apr");
		driver.findElement(By.xpath("//a[text()='"+desiredToDate.getDate()+"']")).click();
	
	}


}
