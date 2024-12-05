package org.example.pages.flightreservation;

import org.example.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends AbstractPage {



    @FindBy(id = "firstName")
    private WebElement firstNameElement;

    @FindBy(id = "lastName")
    private WebElement lastNameElement;

    @FindBy(id = "email")
    private WebElement emailElement;

    @FindBy(id = "password")
    private WebElement passwordElement;

    @FindBy(name = "street")
    private WebElement streetElement;

    @FindBy(name = "city")
    private WebElement cityElement;

    @FindBy(id = "inputState")
    private WebElement stateElement;

    @FindBy(name = "zip")
    private WebElement zipElement;

    @FindBy(id = "register-btn")
    private WebElement registerButtonElement;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameElement));
        return this.firstNameElement.isDisplayed();
    }


    public void goTo(String url){
        this.driver.get(url);
    }

    public void enterUserDetails(String firstName, String lastName){
        this.firstNameElement.sendKeys(firstName);
        this.lastNameElement.sendKeys(lastName);
    }

    public void enterUserCredentials(String email,String password){
        this.emailElement.sendKeys(email);
        this.passwordElement.sendKeys(password);
    }

    public void enterAddress(String street, String city, String zip){
        this.streetElement.sendKeys(street);
        this.cityElement.sendKeys(city);
        this.zipElement.sendKeys(zip);
    }

    public void clickRegister(){
        this.registerButtonElement.click();
    }
}
