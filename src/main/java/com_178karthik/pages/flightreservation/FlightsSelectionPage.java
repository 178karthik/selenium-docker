package com_178karthik.pages.flightreservation;

import com.google.common.util.concurrent.Uninterruptibles;
import com_178karthik.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FlightsSelectionPage extends AbstractPage {

    @FindBy(name = "departure-flight")
    private List<WebElement> departureFlightOptions;
    @FindBy(name = "arrival-flight")
    private List<WebElement> arrivalFlightOptions;
    @FindBy(id = "confirm-flights")
    private WebElement confirmFlightsButton;

    public FlightsSelectionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(confirmFlightsButton));
        return this.confirmFlightsButton.isDisplayed();
    }

    public void selectFlights(){
        int random = ThreadLocalRandom.current().nextInt(0,departureFlightOptions.size());
        this.departureFlightOptions.get(random).click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        this.arrivalFlightOptions.get(random).click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
}

 public void confirmFlights()
 {
     this.confirmFlightsButton.click();
     Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
 }

}
