package demo;

import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class WindowPopupForm extends Base {
	
	@Test(groups = {"six","pop"})
	public void popup() throws ParseException, InterruptedException {
		driver.get("http://demo.seleniumeasy.com/window-popup-modal-demo.html");
		
		List.of("Follow On Twitter","Like us On Facebook","Follow Twitter & Facebook","Follow All")
		.stream().forEach(button -> {
			driver.findElement(By.xpath("//a[normalize-space(text())='"+button+"']")).click();
			handles = driver.getWindowHandles();
			System.out.println(handles);
			for (int i = handles.size(); i > 1; i--) {
				driver.switchTo().window((String) handles.toArray()[i - 1]);
				driver.manage().window().maximize();
				status = (String) js.executeScript("return document.readyState");
				while(!status.equals("complete")) {
					status = (String) js.executeScript("return document.readyState");
					System.out.println(status);
				}
				driver.close();
			}
			driver.switchTo().window((String) handles.toArray()[0]);
		});
		
		
}
}
