package org.example.pages.flightreservation;

import org.example.pages.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FlightSelectionPage extends AbstractPage {


    @FindBy(name = "departure-flight")
    private List<WebElement> departureFlightOptionElements;

    @FindBy(name = "arrival-flight")
    private List<WebElement> arrivalFlightOptionElements;

    @FindBy(id = "confirm-flights")
    private WebElement confirmFlightButtonElement;

    public FlightSelectionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(this.confirmFlightButtonElement));
        return this.confirmFlightButtonElement.isDisplayed();
    }

    public void selectFlights() throws InterruptedException {
        int random = ThreadLocalRandom.current().nextInt(0,departureFlightOptionElements.size());
        Thread.sleep(3000);
        this.departureFlightOptionElements.get(random).click();
        this.departureFlightOptionElements.get(random).click();
    }

    public void confirmFlight(){
        JavascriptExecutor javascriptException = (JavascriptExecutor) this.driver;
        javascriptException.executeScript("arguments[0].click();",this.confirmFlightButtonElement);

    }
}
