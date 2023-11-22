package com.qa.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    public WebDriver driver;
    @FindBy(linkText = "My Account")
    private WebElement myAccountDropDown;

    @FindBy(linkText = "Login")
    private WebElement loginOption;

    @FindBy(linkText = "Register")
    private WebElement registerOption;

    @FindBy(xpath = "//div[@id = 'search']/input[@name = 'search']")
    private WebElement searchBox;

    @FindBy(css = "button.btn.btn-default.btn-lg")
    private WebElement searchButton;


    public LandingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterProductNameToSearchBox(String productName){
        searchBox.sendKeys(productName);
    }


    public HP_LP_3065Page clickOnSearchButton(){
        searchButton.click();
        return new HP_LP_3065Page(driver);
    }
    public HP_LP_3065Page searchProduct(String productName){
        searchBox.sendKeys(productName);
        searchButton.click();
        return new HP_LP_3065Page(driver);
    }


    //Action on those Objects
    public void clickOnMyAccountDropdown() {
        myAccountDropDown.click();
    }

    public LoginPage selectLoginOption() {
        loginOption.click();
        return new LoginPage(driver);
    }
    public RegisterPage selectRegisterOption() {

        registerOption.click();
        return new RegisterPage(driver);
    }
    public LoginPage navigateToLoginPage(){
        myAccountDropDown.click();
        loginOption.click();
        return new LoginPage(driver);

    }
    public RegisterPage navigateToRegisterPage(){
        myAccountDropDown.click();
        registerOption.click();
        return new RegisterPage(driver);
    }



}
