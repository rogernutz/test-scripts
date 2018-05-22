package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageObject{

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    private String profilePageUrl = "https://shop.circles.life/my_profile";

    @FindBy(xpath="//label[contains(text(), 'Email')]")
    private WebElement emailLabel;

    @FindBy(xpath="//label[contains(text(), 'Email')]/../div/input")
    private WebElement emailTextBox;

    public String getEmailPlaceholderValue(){
        Actions actions = new Actions(driver);
        actions.moveToElement(emailTextBox);
        actions.perform();
        return emailTextBox.getAttribute("value");
    }

    public void isProfilePageLoadedAfterLogin(){
        waitForElementVisibility(emailLabel);
        Assert.assertTrue("Profile Page is not loaded after Login",
                driver.getCurrentUrl().contains(profilePageUrl));
    }

    public void checkEmail(String email){
        Assert.assertTrue("Email is not correct for logged account",
                this.getEmailPlaceholderValue().contains(email));
    }
}
