package com.qa.tutorialsninja.TestCases;

import com.qa.tutorialsninja.Pages.CheckoutPage;
import com.qa.tutorialsninja.Pages.HP_LP_3065Page;
import com.qa.tutorialsninja.Pages.LandingPage;
import com.qa.tutorialsninja.Pages.ShoppingCartPage;
import com.qa.tutorialsninja.TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends TestBase {
    public WebDriver driver;
    public LandingPage landingPage;
    public HP_LP_3065Page hpLp3065Page;
    public ShoppingCartPage shoppingCartPage;
    public CheckoutPage checkoutPage;

    public CheckoutTest() throws Exception {
        setup();
    }

    @BeforeMethod
    public void setup(){
        driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));

    }
    @Test
    public void verifyCheckoutOptionWithValidProduct() throws InterruptedException {
        landingPage = new LandingPage(driver);
        hpLp3065Page = landingPage.searchProduct(dataprop.getProperty("validProduct"));
        shoppingCartPage = hpLp3065Page.navigateAddingAProductAndViewCart();
        checkoutPage = shoppingCartPage.clickOnCheckoutButton();
        checkoutPage.checkoutAddedItem(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
        Assert.assertTrue(checkoutPage.getActualConfirmationMessage().contains(dataprop.getProperty("expectedConfirmationText")));
    }
    @AfterMethod
    public void tearUp(){
        driver.quit();
    }

}
