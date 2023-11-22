package com.qa.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    public WebDriver driver;

    @FindBy(css = "a.btn.btn-primary")
    private WebElement checkoutButton;




    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public CheckoutPage clickOnCheckoutButton(){
        checkoutButton.click();
        return new CheckoutPage(driver);
    }
}
