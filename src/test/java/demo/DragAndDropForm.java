package demo;

import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.Base;

public class DragAndDropForm extends Base {
	
	@Test(groups = {"two"})
	public void popup() throws ParseException, InterruptedException {
		driver.get("http://demo.seleniumeasy.com/drag-and-drop-demo.html");
		WebElement drop = driver.findElement(By.id("mydropzone"));
		List<WebElement> items = driver.findElements(By.xpath("//span[@draggable='true']"));
		items.stream().forEach(element -> {
			action.dragAndDrop(element,drop).perform();
		});
		
	}

}
