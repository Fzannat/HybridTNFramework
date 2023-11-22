package com.qa.tutorialsninja.TestCases;

import com.qa.tutorialsninja.Pages.HP_LP_3065Page;
import com.qa.tutorialsninja.Pages.LandingPage;
import com.qa.tutorialsninja.TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchProductTest  extends TestBase {
    public WebDriver driver;
    public LandingPage landingPage;
    public HP_LP_3065Page hpLp3065Page;


    public SearchProductTest() throws Exception {
        super();
    }
    @BeforeMethod
    public void searchSetUp(){
        driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
        landingPage = new LandingPage(driver);

    }

    @Test(priority=1)
    public void verifySearchWithValidProduct() {
        hpLp3065Page = landingPage.searchProduct(dataprop.getProperty("validProduct"));
        Assert.assertTrue(hpLp3065Page.isHP_LP3065Displayed());

    }
    @Test(priority=2)
    public void verifySearchWithInvalidProduct() {
        hpLp3065Page = landingPage.searchProduct(dataprop.getProperty("invalidProduct"));
        Assert.assertTrue(hpLp3065Page.isInvalidSearchErrorMessageDisplayed());

    }

    @Test(priority=3)
    public void verifySearchWithNoProduct() {
        hpLp3065Page = landingPage.clickOnSearchButton();
        Assert.assertTrue(hpLp3065Page.isInvalidSearchErrorMessageDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
