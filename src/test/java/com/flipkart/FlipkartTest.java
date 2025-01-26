package com.flipkart;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartTest {
	
	static WebDriver driver;
	static Wait w;
	static String days1;
	static String days2;
	@BeforeClass
	public static void Application_Launch() {
		//Application Launch
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
	    options.addArguments("start-maximized");
	    options.addArguments("disable-notifications");
	    options.addArguments("disable-popups");
	    driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.get("https://www.flipkart.com/");	
	}
	
	@Test
	public void method1() {
		WebElement search = driver.findElement(By.xpath("//input[contains(@title,'Search')]"));
		if(search.isDisplayed()) {
			System.out.println("SEARCH is Displayed");
		}
	}
	@Test
	public void method2() {
		//Enter the search 
		WebElement search = driver.findElement(By.xpath("//input[contains(@title,'Search')]"));
		search.click();
		search.sendKeys("Samsung Mobile");
		search.submit();		
	}
	@Test
	public void method3() {
		//Obtain the search response
		List<WebElement> result = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
		//Validate the result obtain are samsung mobile only
		for(WebElement x:result) {
		String a=x.getText();
		System.out.println(x.getText());	
		}
	}
	@Test
	public void method4() {
		//Obtain the search response
		List<WebElement> result = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
		int f =0;
		//Validate the result obtain are samsung mobile only
		for(WebElement x:result) {
			 if (x.getText().toLowerCase().contains("samsung")) {
				// System.out.println(x.getText());	
		}else {
			f=1;
		}
		}
		if (f==1) {
			System.out.println("No The obtained result is not correct");
		}else {
			System.out.println("The obtained result is correct");
		}
	}
	@Test
	public void method5() {
		WebElement sort = driver.findElement(By.xpath("//div[text()='Price -- High to Low']"));
		sort.click();
		
	}
	//SAMSUNG Galaxy Z Fold5 (Cream, 512 GB)
	@Test
	public void method6() {
		WebElement result = driver.findElement(By.xpath("//div[contains(text(),'Z Fold5 (Cream, 512 GB)')]"));
	
		
		//WebElement result = driver.findElement(By.xpath("(//div[@class='KzDlHZ'])[last()]"));
		result.click();
	}
	@Test
	public void method7() {
		
		driver.quit();
	}
	
	@AfterClass
	public static void method8() {
		System.out.println("Completed");
	}
	
}