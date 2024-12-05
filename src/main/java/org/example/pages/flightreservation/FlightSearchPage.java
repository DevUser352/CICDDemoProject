package org.example.pages.flightreservation;

import org.example.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage extends AbstractPage {

    @FindBy(id = "passengers")
    private WebElement passengersElement;

    @FindBy(id = "search-flights")
    private WebElement searchFlightElement;


    public FlightSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(this.passengersElement));
        return this.passengersElement.isDisplayed();
    }

    public void selectPassengers(String noOfPassengers){
        Select passengers = new Select(this.passengersElement);
        passengers.selectByValue(noOfPassengers);
    }

    public void searchFlight(){
        this.searchFlightElement.click();
    }


}
