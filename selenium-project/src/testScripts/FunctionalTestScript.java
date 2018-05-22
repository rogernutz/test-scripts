package testScripts;

import org.junit.Test;
import pageObjects.*;
import java.util.Random;

public class FunctionalTestScript extends BasePage {
    HomePage homePage = new HomePage(driver);
    PlanPage planPage = new PlanPage(driver);
    ProfilePage profilePage = new ProfilePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    FacebookPage facebookPage = new FacebookPage(driver);

    private String email = "naemakthar89@gmail.com";
    private String password = "pass123$";

    Random rand = new Random();
    int  n = rand.nextInt(100) + 1;
    private String postText = "Test Post " + Integer.toString(n);

    @Test
    public void loginAndCheckMailInAccount(){
        homePage.invokeHomePage();
        homePage.isHomePageLoaded();
        homePage.clickBuyNowButton();
        planPage.isPlanPageLoaded();
        planPage.clickLoginLink();
        loginPage.enterMail(email);
        loginPage.enterPassword(password);
        loginPage.clickSignInButton();
        planPage.isPlanPageLoadedAfterLogin();
        planPage.clickMyAccountLink();
        profilePage.isProfilePageLoadedAfterLogin();
        profilePage.checkEmail(email);
    }

    @Test
    public void facebookPost(){
        homePage.invokeHomePage();
        homePage.isHomePageLoaded();
        homePage.clickBuyNowButton();
        planPage.isPlanPageLoaded();
        planPage.clickLoginLink();
        planPage.clickFacebookIcon();
        planPage.changeUserControlToNewTab();
        facebookPage.enterMail(email);
        facebookPage.enterPassword(password);
        facebookPage.clickLogIn();
        facebookPage.clickOnFacebookName();
        facebookPage.clickOnFacebookPostTextArea();
        facebookPage.enterTestPost(postText);
        facebookPage.clickOnPost();
        facebookPage.clickUserNavigationLabel();
        facebookPage.logOutOfFacebook();
        facebookPage.enterMail(email);
        facebookPage.enterPassword(password);
        facebookPage.clickLogIn();
        facebookPage.clickOnFacebookName();
        facebookPage.checkLatestPost(postText);
    }
}
