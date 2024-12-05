package org.example.pages.flightreservation;

import org.example.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.AbstractFindByBuilder;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationConfirmationPage extends AbstractPage {


    @FindBy(id = "go-to-flights-search")
    private WebElement goToFlightsSearchButtonElement;

    @FindBy(css = "#registration-confirmation-section p b")
    private WebElement firstNameElement;

    public RegistrationConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(this.goToFlightsSearchButtonElement));
        return this.goToFlightsSearchButtonElement.isDisplayed();
    }

    public void clickOnGoToFlightsSearchButton(){
        this.goToFlightsSearchButtonElement.click();
    }

    public String getFirstName(){
        return this.firstNameElement.getText();
    }
}
