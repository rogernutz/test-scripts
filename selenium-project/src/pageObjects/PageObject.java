package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
	protected WebDriver driver;

	public PageObject(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForElementVisibility(WebElement webElement){
		try {
			WebDriverWait webDriverWait = new WebDriverWait(driver,5);
			webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
		}catch (TimeoutException e){
		throw e;
		}
	}

	public void waitForElementClickable(By elementLocator){
		try {
			WebDriverWait webDriverWait = new WebDriverWait(driver,5);
			webDriverWait.until(ExpectedConditions.elementToBeClickable(elementLocator));
		}catch (TimeoutException e){
			throw e;
		}
	}
}
