package org.example.tests.flightreservation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.flightreservation.*;
import org.example.tests.AbstractTest;
import org.example.tests.flightreservation.model.FlightReservationTestData;
import org.example.utils.JsonUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class FlightReservationTest extends AbstractTest {

    private FlightReservationTestData testData;

    @BeforeTest
    @Parameters("testDataPath")
    public void setParameters(String testDataPath){
        this.testData = JsonUtil.getTestData(testDataPath,FlightReservationTestData.class);
    }

    @Test
    public void userRegistrationTest(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
        Assert.assertTrue(registrationPage.isAt());

        registrationPage.enterUserDetails(testData.firstName(), testData.lastName());
        registrationPage.enterUserCredentials(testData.email(), testData.password());
        registrationPage.enterAddress(testData.street(), testData.city(), testData.zip());
        registrationPage.clickRegister();
    }

    @Test(dependsOnMethods = "userRegistrationTest")
    public void RegistrationConfirmationTest(){
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        Assert.assertTrue(registrationConfirmationPage.isAt());
        Assert.assertEquals(registrationConfirmationPage.getFirstName(),testData.firstName());
        registrationConfirmationPage.clickOnGoToFlightsSearchButton();
    }

    @Test(dependsOnMethods = "RegistrationConfirmationTest")
    public void flightSearchTest(){
        FlightSearchPage flightSearchPage = new FlightSearchPage(driver);
        Assert.assertTrue(flightSearchPage.isAt());
        flightSearchPage.selectPassengers(testData.passengersCount());
        flightSearchPage.searchFlight();
    }

   @Test(dependsOnMethods = "flightSearchTest")
    public void flightsSelectionTest() throws InterruptedException {
        FlightSelectionPage flightSelectionPage = new FlightSelectionPage(driver);
        flightSelectionPage.selectFlights();
        flightSelectionPage.confirmFlight();
   }

   @Test(dependsOnMethods = "flightsSelectionTest")
    public void flightReservationConfirmationTest(){
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        Assert.assertTrue(flightConfirmationPage.isAt());
        Assert.assertEquals(flightConfirmationPage.getPrice(),testData.expectedPrice());
   }




}
