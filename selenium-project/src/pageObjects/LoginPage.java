package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name="email")
    private WebElement mailTextBox;

    @FindBy(name="password")
    private WebElement passwordTextBox;

    @FindBy(xpath="//button[contains(text(), 'Sign In')]")
    private WebElement signInButton;

    public void enterMail(String email){
        this.mailTextBox.clear();
        this.mailTextBox.sendKeys(email);
    }

    public void enterPassword(String password){
        this.passwordTextBox.clear();
        this.passwordTextBox.sendKeys(password);
    }

    public void clickSignInButton(){
        signInButton.click();
    }
}
