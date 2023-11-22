package com.qa.tutorialsninja.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    public WebDriver driver;

    @FindBy(id = "input-email")
    private WebElement inputEmailBox;

    @FindBy(id = "input-password")
    private WebElement inputPasswordBox;

    @FindBy(id = "button-login")
    private WebElement loginButton;

    @FindBy(id = "button-payment-address")
    private WebElement paymentAddressButton;

    @FindBy(id = "button-shipping-address")
    private WebElement shippingAddressButton;

    @FindBy(id = "button-shipping-method")
    private WebElement shippingMethodButton;
    @FindBy(xpath = "//input[@name = 'agree']")
    private WebElement privacyCheckBox;
    @FindBy(id = "button-payment-method")
    private WebElement paymentMethodButton;
    @FindBy(id = "button-confirm")
    private WebElement confirmButton;
    @FindBy(xpath = "//h1[text() ='Your order has been placed!']")
    private WebElement actualConfirmationMessage;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void validCredentialForLogin(String email, String password){
        inputEmailBox.sendKeys(email);
        inputPasswordBox.sendKeys(password);
        loginButton.click();
    }
    public void checkoutAddedItem(String email, String password){
        validCredentialForLogin(email,password);
        paymentAddressButton.click();
        shippingAddressButton.click();
        shippingMethodButton.click();
        privacyCheckBox.click();
        paymentMethodButton.click();
        confirmButton.click();
    }
    public String getActualConfirmationMessage(){
        return actualConfirmationMessage.getText();
    }
}
