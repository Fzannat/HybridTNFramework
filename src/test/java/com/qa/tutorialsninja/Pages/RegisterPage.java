package com.qa.tutorialsninja.Pages;

import com.qa.tutorialsninja.Utilties.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    public WebDriver driver;
    @FindBy(id = "input-firstname")
    private WebElement firstNameAddress;
    @FindBy(id = "input-lastname")
    private WebElement lastNameAddress;

    @FindBy(id = "input-email")
    private WebElement emailAddress;

    @FindBy(id = "input-telephone")
    private WebElement telephone;

    @FindBy(id = "input-password")
    private WebElement passwordAddress;

    @FindBy(id = "input-confirm")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@name = 'newsletter' and @value = '1']")
    private WebElement subscribeNewsLetterCheckBox;

    @FindBy(xpath = "//input[@name = 'agree']")
    private WebElement privacyPolicyCheckBox;

    @FindBy(css = "input.btn.btn-primary")
    private WebElement continueButton;

    @FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
    private WebElement duplicateEmailErrorMessage;

    @FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
    private WebElement privacyPolicyWarningMessage;

    @FindBy(xpath = "//div[text() = 'First Name must be between 1 and 32 characters!']")
    private WebElement firstNameWarningMessage;

    @FindBy(xpath = "//div[text() = 'Last Name must be between 1 and 32 characters!']")
    private WebElement lastNameWarningMessage;

    @FindBy(xpath = "//div[text() = 'E-Mail Address does not appear to be valid!']")
    private WebElement emailWarningMessage;

    @FindBy(xpath = "//div[text() = 'Telephone must be between 3 and 32 characters!']")
    private WebElement telephoneWarningMessage;

    @FindBy(xpath = "//div[text() = 'Password must be between 4 and 20 characters!']")
    private WebElement passwordWarningMessage;







    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void enterFirstName(String firstName){
        firstNameAddress.sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        lastNameAddress.sendKeys(lastName);
    }

    public void enterEmail(String email){
        emailAddress.sendKeys(email);
    }
    public void enterTelephoneNumber(String telephoneNumber){
        telephone.sendKeys(telephoneNumber);
    }
    public void enterPassword(String password){
        passwordAddress.sendKeys(password);
    }
    public void enterConfirmPassword(String password){
        confirmPassword.sendKeys(password);
    }
    public void clickOnNewsLetterCheckBox(){
        subscribeNewsLetterCheckBox.click();
    }
    public void clickOnPrivacyPolicyCheckBox(){
        privacyPolicyCheckBox.click();
    }
    public void clickOnContinueButton(){
        continueButton.click();
    }

    public String getDuplicateEmailErrorMessage(){
        String errorMessage = duplicateEmailErrorMessage.getText();
        return errorMessage;
    }

    public String getPrivacyPolicyWarningMessage(){
        String warningMassage = privacyPolicyWarningMessage.getText();
        return warningMassage;
    }
    public String getFirstNameWarningMessage(){
        String warningMassage = firstNameWarningMessage.getText();
        return warningMassage;
    }

    public String getLastNameWarningMessage(){
        String warningMassage = lastNameWarningMessage.getText();
        return warningMassage;
    }

    public String getEmailWarningMessage(){
        String warningMassage = emailWarningMessage.getText();
        return warningMassage;
    }

    public String getTelephoneWarningMessage(){
        String warningMassage = telephoneWarningMessage.getText();
        return warningMassage;
    }

    public String getPasswordWarningMessage(){
        String warningMassage = passwordWarningMessage.getText();
        return warningMassage;
    }

    public AccountSuccessPage registerPageMandatoryDetail(String firstName, String lastName, String email, String telephoneNumber, String passWord){
        firstNameAddress.sendKeys(firstName);
        lastNameAddress.sendKeys(lastName);
        emailAddress.sendKeys(email);
        telephone.sendKeys(telephoneNumber);
        passwordAddress.sendKeys(passWord);
        confirmPassword.sendKeys(passWord);
        privacyPolicyCheckBox.click();
        continueButton.click();
        return new AccountSuccessPage(driver);

    }
    public AccountSuccessPage registerPageAllDetail(String firstName, String lastName, String email, String telephoneNumber, String passWord){
        firstNameAddress.sendKeys(firstName);
        lastNameAddress.sendKeys(lastName);
        emailAddress.sendKeys(email);
        telephone.sendKeys(telephoneNumber);
        passwordAddress.sendKeys(passWord);
        confirmPassword.sendKeys(passWord);
        subscribeNewsLetterCheckBox.click();
        privacyPolicyCheckBox.click();
        continueButton.click();
        return new AccountSuccessPage(driver);

    }

    public boolean retrieveAllWarningMessagesStatus(String expectedPrivacyPolicyMessage, String expectedFirstNameErrorMassage,
                                                    String expectedLastNameErrorMassage, String expectedEmailErrorMassage,
                                                    String expectedTelephoneErrorMassage, String expectedPasswordErrorMassage){
        boolean privacyPolicyWarningStatus = getPrivacyPolicyWarningMessage().contains(expectedPrivacyPolicyMessage);
        boolean firstNameWarningStatus = getFirstNameWarningMessage().contains(expectedFirstNameErrorMassage);
        boolean lastNameWarningStatus = getLastNameWarningMessage().contains(expectedLastNameErrorMassage);
        boolean emailWarningStatus = getEmailWarningMessage().contains(expectedEmailErrorMassage);
        boolean telephoneWarningStatus = getTelephoneWarningMessage().contains(expectedTelephoneErrorMassage);
        boolean passwordWarningStatus = getPasswordWarningMessage().contains(expectedPasswordErrorMassage);

        return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && emailWarningStatus
                && telephoneWarningStatus && passwordWarningStatus;


    }
}
