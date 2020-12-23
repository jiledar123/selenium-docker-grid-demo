package com.newtours.tests;

import com.newtours.pages.*;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegistrationWrokflowTests extends BaseTest {

    private String expectedPrice;
    private String noOfPassanger;

    @BeforeTest
    @Parameters({"noOfPassanger", "expectedPrice"})
    public void setupParameter(String noOfPassanger, String expectedPrice) {
        this.noOfPassanger = noOfPassanger;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void registrationPage() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("selenium", "docker");
        registrationPage.enterCredentials("selenium", "docker");
        registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage() {
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.gotoFlightDetailPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage() {
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectPassanger(noOfPassanger);
        flightDetailsPage.gotToFlightFindPage();
    }

    @Test(dependsOnMethods = "flightDetailsPage")
    public void findFlightPage() {
        FindFlightPage findFlightPage = new FindFlightPage(driver);
        findFlightPage.gotoSecondSubmitPage();
        findFlightPage.goToFlightConfirmationPage();
    }

    @Test(dependsOnMethods = "findFlightPage")
    public void flightBookingConfirmationPage() {
        FlightBookingConfirmationPage flightBookingConfirmationPage = new FlightBookingConfirmationPage(driver);
        String actualPrice = flightBookingConfirmationPage.getPrice();
        Assert.assertEquals(actualPrice, this.expectedPrice);

    }

}
