package demo;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;

public class SelectForm extends Base {

	@Test(groups = {"five"})
	public void selectForm() {
		driver.get("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
		Select select = new Select(driver.findElement(By.id("select-demo")));
		for (int i = 1; i < select.getOptions().size(); i++) {
			select.selectByIndex(i);
			String option = select.getAllSelectedOptions().get(0).getAttribute("value");
			String message = driver.findElement(By.xpath("//p[@class='selected-value']")).getText();
			Assert.assertTrue(message.contains(option));
		}
	
	}
	
	@Test
	public void multiSelectForm() {
		driver.get("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
		Select select = new Select(driver.findElement(By.id("multi-select")));
		select.selectByValue("California");
		select.selectByValue("New Jersey");
		select.selectByValue("Texas");
		List<String> options = select.getAllSelectedOptions().stream().map(element->element.getText()).collect(Collectors.toList());
		options.containsAll(List.of("California","Texas","New Jersey"));
	}

}
