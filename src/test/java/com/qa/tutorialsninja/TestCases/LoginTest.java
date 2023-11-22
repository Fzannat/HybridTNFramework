package com.qa.tutorialsninja.TestCases;

import com.qa.tutorialsninja.Pages.AccountPage;
import com.qa.tutorialsninja.Pages.LandingPage;
import com.qa.tutorialsninja.Pages.LoginPage;
import com.qa.tutorialsninja.TestBase.TestBase;
import com.qa.tutorialsninja.Utilties.ExcelCode;
import com.qa.tutorialsninja.Utilties.Util;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    public WebDriver driver;
    public LandingPage landingPage;
    public LoginPage loginPage;
    public AccountPage accountPage;

    public LoginTest() throws Exception {
        super();
    }

    @BeforeMethod
    public void loginSetUp(){
        driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
        landingPage = new LandingPage(driver);
        loginPage = landingPage.navigateToLoginPage(); //this leads to loginPage
    }
    @Test(priority=1, dataProvider = "TN", dataProviderClass = ExcelCode.class)
    public void verifyLoginWithValidCredentials(String excelEmail, String excelPassword){
        accountPage = loginPage.navigateToAccountPage(excelEmail, excelPassword);
        Assert.assertTrue(accountPage.isEditYourAccountInformationLinkDisplayed());

    }

    @Test(priority=2)
    public void verifyLoginWithValidEmailInvalidPassword(){
        loginPage.navigateToAccountPage(prop.getProperty("validEmail"),dataprop.getProperty("invalidPassword"));
        Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(dataprop.getProperty("loginWarningMessage")));
    }
    @Test(priority=3)
    public void verifyLoginWithInvalidEmailValidPassword() {
        loginPage.navigateToAccountPage(Util.generateEmailWithDateTimeStamp(),prop.getProperty("validPassword"));
        Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(dataprop.getProperty("loginWarningMessage")));
    }
    @Test(priority=4)
    public void verifyLoginWithInvalidCredentials() {
        loginPage.navigateToAccountPage(Util.generateEmailWithDateTimeStamp(),dataprop.getProperty("invalidPassword"));
        Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(dataprop.getProperty("loginWarningMessage")));
    }

    @Test(priority=5)
    public void verifyLoginWithNoCredentials() {
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(dataprop.getProperty("loginWarningMessage")));
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
