package com_178karthik.pages.flightreservation;

import com.google.common.util.concurrent.Uninterruptibles;
import com_178karthik.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class FlightsSearchPage extends AbstractPage {
    @FindBy(id="passengers")
    private WebElement passengerSelect;
    @FindBy(id="search-flights")
    private WebElement searchFlightsButton;

    public FlightsSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until((ExpectedConditions.visibilityOf(this.passengerSelect)));
        return this.passengerSelect.isDisplayed();
    }
    public void selectPassengers(String noOfPassengers)
    {
        Select select = new Select(passengerSelect);
        select.selectByValue(noOfPassengers);

    }

    public void searchFlights(){
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        this.searchFlightsButton.click();
    }

}
