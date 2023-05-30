package demo;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;

public class CheckboxForm extends Base  {
	
	@Test(groups = {"two"})
	public void singleCheckbox() throws InterruptedException {
		driver.get("http://demo.seleniumeasy.com/basic-checkbox-demo.html");
		List<WebElement> checkboxes = driver.findElements(By.xpath("//div[text()='Single Checkbox Demo']/following-sibling::div//input"));
		Assert.assertTrue(checkboxes.get(1).isSelected());
		Assert.assertFalse(checkboxes.get(2).isEnabled());
		WebElement message = driver.findElement(By.id("txtAge"));
		Assert.assertEquals("none",message.getCssValue("display"));
		checkboxes.get(0).click();
		Assert.assertEquals("block",message.getCssValue("display"));
	}
	
	@Test
	public void multipleCheckbox() throws InterruptedException {
		driver.get("http://demo.seleniumeasy.com/basic-checkbox-demo.html");
		List<WebElement> checkboxes = driver.findElements(By.xpath("//div[text()='Multiple Checkbox Demo']/..//input"));
		WebElement selectAll = checkboxes.get(4);
		for (int i = 0; i < 4; i++) {
			Assert.assertFalse(checkboxes.get(i).isSelected());
		}
		selectAll.click();
		for (int i = 0; i < 4; i++) {
			Assert.assertTrue(checkboxes.get(i).isSelected());
		}
		Thread.sleep(2000);
	}
	

}
