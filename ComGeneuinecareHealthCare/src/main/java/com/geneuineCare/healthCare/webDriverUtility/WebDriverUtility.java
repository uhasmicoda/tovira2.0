package com.geneuineCare.healthCare.webDriverUtility;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void windowMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void scroll(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+ y+");"); 
		
		
	}
	
	public void scrollTillBottom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	public void waitForElementLoad(WebDriver driver, WebElement element, int seconds) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void switchToWindow(WebDriver driver, String partialUrl) {
		Set<String> allWindow = driver.getWindowHandles();
		Iterator<String> it = allWindow.iterator();
		while (it.hasNext()) {
			String WindowId = it.next();
			driver.switchTo().window(WindowId);

			String tabUrl = driver.getCurrentUrl();
			if (tabUrl.contains(partialUrl)) {
				break;
			}

		}
	}

	public void switchToWindow(String partiaTitle, WebDriver driver) {
		Set<String> allWindow = driver.getWindowHandles();
		Iterator<String> it = allWindow.iterator();
		while (it.hasNext()) {
			String WindowId = it.next();
			driver.switchTo().window(WindowId);

			String tabUrl = driver.getTitle();
			if (tabUrl.contains(partiaTitle)) {
				break;
			}

		}
	}

	public void switchtoFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
		
	}
	public void switchtoFrame(WebDriver driver, String nameOrId) {

		driver.switchTo().frame(nameOrId);

	}

	public void switchtoFrame(WebDriver driver, WebElement element) {

		driver.switchTo().frame(element);

	}

	public void switchToAlertAccept(WebDriver driver) {

		driver.switchTo().alert().accept();
	}

	public void switchToAlertDismiss(WebDriver driver) {

		driver.switchTo().alert().dismiss();
	}

	public void switchToAlertEnterPrompt(WebDriver driver, String value) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(value);
		a.accept();

	}
	
	public String switchToAlertGetText(WebDriver driver) {
		
	String text = driver.switchTo().alert().getText();
	return text;
	}
	public void dropDown(WebElement element,String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	  public List<String> getTextFromElements(List<WebElement> elements) {
	        List<String> textList = new ArrayList<>();
	        for (WebElement element : elements) {
	            textList.add(element.getText());
	        }
	        return textList;
	    }
	}

