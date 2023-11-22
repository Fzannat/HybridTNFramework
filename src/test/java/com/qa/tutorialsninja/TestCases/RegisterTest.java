package com.qa.tutorialsninja.TestCases;

import com.qa.tutorialsninja.Pages.AccountSuccessPage;
import com.qa.tutorialsninja.Pages.LandingPage;
import com.qa.tutorialsninja.Pages.RegisterPage;
import com.qa.tutorialsninja.TestBase.TestBase;
import com.qa.tutorialsninja.Utilties.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterTest extends TestBase {

    public WebDriver driver;
    public LandingPage landingPage;
    public RegisterPage registerPage;
    public AccountSuccessPage accountSuccessPage;

    public RegisterTest() throws Exception {
        super();
    }

    @BeforeMethod
    public void loginSetUp(){
        driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
        landingPage = new LandingPage(driver);
        registerPage = landingPage.navigateToRegisterPage();
    }

    @Test(priority=1)
    public void verifyRegisterAccountWithMandatoryDetails() {
        accountSuccessPage = registerPage.registerPageMandatoryDetail(dataprop.getProperty("firstname"),dataprop.getProperty("lastname"),Util.generateEmailWithDateTimeStamp(),
                dataprop.getProperty("telephone"),prop.getProperty("validPassword"));
        Assert.assertTrue(accountSuccessPage.isAccountSuccessfullyCreatedMassageDisplayed());


    }
    @Test(priority=2)
    public void verifyRegisterAccountWithAllDetails() {
        accountSuccessPage = registerPage.registerPageAllDetail(dataprop.getProperty("firstname"),dataprop.getProperty("lastname"),Util.generateEmailWithDateTimeStamp(),
                dataprop.getProperty("telephone"),prop.getProperty("validPassword"));
        Assert.assertTrue(accountSuccessPage.isAccountSuccessfullyCreatedMassageDisplayed());


    }
    @Test(priority=3)

    public void verifyRegisterAccountWithDuplicateEmail() {
        registerPage.registerPageMandatoryDetail(dataprop.getProperty("firstname"),dataprop.getProperty("lastname"),prop.getProperty("validEmail"),
                dataprop.getProperty("telephone"),prop.getProperty("validPassword"));
        Assert.assertTrue(registerPage.getDuplicateEmailErrorMessage().contains(dataprop.getProperty("emailExistWarningMessage")));

    }

    @Test(priority=4)
    public void verifyRegisterAccountWithNoDetails() {
        registerPage.clickOnContinueButton();
        Assert.assertTrue(registerPage.retrieveAllWarningMessagesStatus(dataprop.getProperty("policyWarningMessage"),
                dataprop.getProperty("firstNameWarningMessage"), dataprop.getProperty("lastNameWarningMessage"),
                dataprop.getProperty("emailWarningMessage"),dataprop.getProperty("telephoneWarningMessage"),
                dataprop.getProperty("passwordWarningMessage")));
    }





    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    }



