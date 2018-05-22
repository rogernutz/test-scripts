package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;

public class HomePage extends PageObject {
    private String homePageURL = "https://pages.circles.life/";

    @FindBy(css="a[href='https://shop.circles.life/buy_now']")
    private WebElement buyNowButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void isHomePageLoaded() {
        assertTrue("Home Page is not loaded", buyNowButton.isDisplayed());
    }

    public void clickBuyNowButton(){
        buyNowButton.click();
    }

    public void invokeHomePage(){
        driver.get(homePageURL);
        waitForElementVisibility(buyNowButton);
    }
}
