package demo;

import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.Alert;
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

public class BootstrapListBoxForm extends Base {

	@Test(groups = {"one"})
	public void popup() throws ParseException, InterruptedException {
		driver.get("http://demo.seleniumeasy.com/bootstrap-dual-list-box-demo.html");
		Map<String, List<String>> data = Map.of("left", List.of("Porta ac consectetur ac", "Vestibulum at eros"),
				"right", List.of("Cras justo odio", "Dapibus ac facilisis in"));
		
		for (Map.Entry<String, List<String>> entry : data.entrySet()) {
			String key = entry.getKey();
			String arrow = "right";
			if(key.equals(arrow)) arrow = "left";
			
			List<String> val = entry.getValue();
			val.stream().forEach(string -> {
				driver.findElement(By.xpath("//div[@class='dual-list list-"+key+" col-md-5']//ul//li[text()='" + string + "']")).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
			driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-chevron-"+arrow+"']")).click();
			List<String> results = driver.findElements(By.xpath("//div[@class='dual-list list-"+arrow+" col-md-5']//ul/li"))
					.stream().map(element -> element.getText()).collect(Collectors.toList());
			Assert.assertTrue(results.containsAll(val));
			deselectItems();

		}

	}

	public void deselectItems() {
		List<WebElement> items = driver.findElements(By.xpath("//div[@class='col-md-6 text-left']//li"));
		items.forEach(item -> {
			if (item.getAttribute("class").contains("active")) {
				item.click();
			}
		});
	}
}
