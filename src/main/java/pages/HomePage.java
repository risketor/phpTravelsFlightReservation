package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserDriver;
import utilities.Core;
import java.util.List;

/**
 * @author - Alberto Bartolome Sanchez on 09.12.2018.
 * @project phpTravelsFlightReservation
 */
public class HomePage {

    public HomePage(){
        PageFactory.initElements(BrowserDriver.getDriver(), this);
    }

    private @FindBy(css="#body-section > section > div.cell > div > div > div.col-md-12 > ul > li:nth-child(2) > a") WebElement flightsMenuButton;
    private @FindBy(css="div.bgfade.col-md-3.col-xs-12.search-button") WebElement searchButton;

    private @FindBy(css=".select2-result.select2-result-selectable") List<WebElement> flightFromList;
    private @FindBy(css="select2-results-dept-1 select2-result select2-result-selectable select2-highlighted") WebElement clickOnHighlighted;

    // FROM
    private @FindBy(id="s2id_origin") WebElement flightFromField;
    private @FindBy(css="#select2-drop > div > input") WebElement flightFromTextField;
    private @FindBy(css=".select2-results-dept-0") WebElement flightFromDropdown;

    // TO
    private @FindBy(id="s2id_destination") WebElement flightToField;
    private @FindBy(css="#select2-drop > div > input") WebElement flightToTextField;

    // DATE
    private @FindBy(css="#departure") WebElement departDate;


    public void waitToLoad(){
        Core.waitUntilLoaded(flightsMenuButton);
    }

    public void clickOnFlightsMenuButton(){ flightsMenuButton.click(); }
    public void clickOnSearchButton(){ searchButton.click(); }

    // FLIGHTS - FROM
    public void waitForFlightMenu(){
        Core.waitUntilLoaded(departDate);
        Core.waitUntilLoaded(flightFromField);
        Core.waitUntilLoaded(flightToField);
    }
    public void clickOnFlightFromField() { flightFromField.click(); }
    public void enterFlightFromField(String data){ flightFromTextField.sendKeys(data); }
    public void waitOnFlightDropdownFrom(){ Core.waitUntilLoaded(flightFromDropdown); }
    public void clickOnFlightDropdownFrom(int i){ flightFromList.get(i).click(); }
    public String getFlightFromCity(int i){ return flightFromList.get(i).getText(); }

    // TO
    public void clickOnFlightToField() { flightToField.click(); }
    public void enterFlightToField(String data){ flightToTextField.sendKeys(data); }

    // DATE
    public void clickOnDepartureDate(){ departDate.click(); }
    public void enterDepartureDate(String date){ departDate.sendKeys(date); }
}
