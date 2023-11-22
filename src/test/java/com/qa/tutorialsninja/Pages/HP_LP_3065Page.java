package com.qa.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HP_LP_3065Page {
    public WebDriver driver;

    @FindBy(xpath = "//p[text() = 'There is no product that matches the search criteria.']")
    private WebElement invalidSearchErrorMessage;

    @FindBy(linkText = "HP LP3065")
    private WebElement HP_LP3065;

    @FindBy(xpath = "//button[text()='Add to Cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
    private WebElement cartOption;

   @FindBy(xpath = "//strong[text()='View Cart']")
    private WebElement viewCartButton;

   public HP_LP_3065Page(WebDriver driver){
       this.driver = driver;
       PageFactory.initElements(driver, this);
   }
    public boolean isHP_LP3065Displayed(){
        boolean isDisplayed = HP_LP3065.isDisplayed();
        return isDisplayed;
    }
    public boolean isInvalidSearchErrorMessageDisplayed(){
        boolean isMessageDisplayed = invalidSearchErrorMessage.isDisplayed();
        return isMessageDisplayed;
    }

   public void clickOnHP_LP3065(){
       HP_LP3065.click();
   }
   public void clickOnAddToCart(){
       addToCartButton.click();
   }
   public void clickOnCartOption(){
       cartOption.click();
   }
   public ShoppingCartPage clickOnViewCart(){
       viewCartButton.click();
       return new ShoppingCartPage(driver);
   }
   public ShoppingCartPage navigateAddingAProductAndViewCart(){
       clickOnHP_LP3065();
       clickOnAddToCart();
       clickOnCartOption();
       clickOnViewCart();
       return new ShoppingCartPage(driver);
   }

}
