package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class FacebookPage extends PageObject{

    public FacebookPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="email")
    private WebElement emailTextBox;

    @FindBy(id="pass")
    private WebElement passwordTextBox;

    @FindBy(xpath="//span[contains(text(), 'Mahfoudh')]")
    private WebElement facebookName;

    @FindBy(css="label#loginbutton input")
    private WebElement logInButton;

    @FindBy(id="fbCoverImageContainer")
    private WebElement coverImage;

    @FindBy(xpath="//span[contains(text(), 'Compose Post')]")
    private WebElement composePost;

    @FindBy(xpath = "//div[contains(@data-testid, 'status-attachment-mentions-input')]")
    private WebElement facebookPostArea;

    @FindBy(xpath = "//button[contains(@data-testid, 'react-composer-post-button')]")
    private WebElement postButton;

    @FindBy(css = "div.userContent div p")
    private List<WebElement> postTextElement;

    @FindBy(xpath="//span[contains(text(),'Log Out')]")
    private WebElement logOutLink;

    @FindBy(id="userNavigationLabel")
    private WebElement userNavigationLabel;

    @FindBy(xpath = "//span[contains(text(), 'Create Page')]")
    private WebElement createPageInUserNavigation;

    @FindBy(xpath = "//div[contains(@aria-label, 'Create a post')]")
    private WebElement postSection;

    @FindBy(css = "div.fbTimelineComposerUnit div.uiContextualLayerParent")
    private By postSectionLocator;

    @FindBy(id="userNavigationLabel")
    private By userNavigationLabelLocator;

    @FindBy(xpath = "//img[contains(@data-testid, 'react-composer-throbber')]")
    private WebElement postLoadingIcon;

    @FindBy(css="a[href='https://www.facebook.com/?ref=logo']")
    private By facebookLogoLocator;

    @FindBy(css="a[href='https://www.facebook.com/?ref=logo']")
    private WebElement facebookLogo;

    public void enterMail(String email){
        this.emailTextBox.clear();
        this.emailTextBox.sendKeys(email);
    }

    public void enterPassword(String password){
        this.passwordTextBox.clear();
        this.passwordTextBox.sendKeys(password);
    }

    public void clickLogIn(){
        logInButton.click();
        waitForElementVisibility(facebookName);
    }

    public void clickOnFacebookName(){
        waitForElementVisibility(facebookName);
        facebookName.click();
        waitForElementVisibility(coverImage);
    }

    public void clickOnFacebookPostTextArea(){
        composePost.click();
        facebookPostArea.click();
    }

    public void enterTestPost(String post){
        this.facebookPostArea.clear();
        this.facebookPostArea.sendKeys(post);
    }

    public void clickOnPost(){
        postButton.click();
        waitForElementClickable(userNavigationLabelLocator);
    }

    public String getLatestPost(){
        waitForElementVisibility(postTextElement.get(0));
        return postTextElement.get(0).getText();
    }

    public void clickUserNavigationLabel(){
        facebookLogo.click();
        waitForElementVisibility(userNavigationLabel);
        userNavigationLabel.click();
        waitForElementVisibility(createPageInUserNavigation);
    }

    public void logOutOfFacebook(){
        logOutLink.click();
        waitForElementVisibility(emailTextBox);
        driver.navigate().refresh();
    }

    public void checkLatestPost(String postText){
        Assert.assertTrue("Latest Post is not visible in FB page - " + postText,
                this.getLatestPost().contains(postText));
    }
}
