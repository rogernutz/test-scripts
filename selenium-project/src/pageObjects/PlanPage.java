package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class PlanPage extends PageObject {

    public PlanPage(WebDriver driver) {
        super(driver);
    }

    private String planPageUrl = "https://shop.circles.life/plan";

    @FindBy(xpath="//div[contains(text(), 'LOGIN')]")
    private WebElement loginLinkInHeader;

    @FindBy(xpath="//div[contains(text(), 'MY ACCOUNT')]")
    private WebElement myAccountLinkInHeader;

    @FindBy(css="a[href='https://www.facebook.com/CirclesLifeSG/'] img")
    private WebElement facebookIcon;

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void clickLoginLink(){
        loginLinkInHeader.click();
    }

    public void clickMyAccountLink(){
        myAccountLinkInHeader.click();
    }

    public void clickFacebookIcon(){
        waitForElementVisibility(facebookIcon);
        facebookIcon.click();
    }

    public void isPlanPageLoaded(){
        waitForElementVisibility(loginLinkInHeader);
        Assert.assertTrue("Plan Page is not loaded.",
                this.getCurrentUrl().contains(planPageUrl));
    }

    public void isPlanPageLoadedAfterLogin(){
        waitForElementVisibility(myAccountLinkInHeader);
        Assert.assertTrue("Plan Page is not loaded after Login",
                this.getCurrentUrl().contains(planPageUrl));
    }

    public void changeUserControlToNewTab() {
        Set<String> handles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();
        for (String handle : handles) {

            if (!handle.equals(currentHandle)) {
                driver.switchTo().window(handle);
            }
        }
    }
}
