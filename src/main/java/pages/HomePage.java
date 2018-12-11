package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Core;
import java.util.List;

/**
 * @author - Alberto Bartolome Sanchez on 09.12.2018.
 * @project phpTravelsFlightReservation
 */
public class HomePage {

    private @FindBy(css="#body-section > section > div.cell > div > div > div.col-md-12 > ul > li:nth-child(2) > a") WebElement flightsMenuButton;
    private @FindBy(css="#flights > form > div.bgfade.col-md-3.col-xs-12.search-button > button") WebElement searchButton;
    private @FindBy(css=".select2-result.select2-result-selectable") List<WebElement> flightFromList;
    private @FindBy(css="select2-results-dept-1 select2-result select2-result-selectable select2-highlighted") WebElement clickOnHighlighted;

    // FROM
    private @FindBy(css="#s2id_location_from > a") WebElement flightFromField;
    private @FindBy(css="*[id=location_from]") WebElement flightFromTextField;
    private @FindBy(css=".select2-results-dept-0") WebElement flightFromDropdown;

    // TO
    private @FindBy(css="#s2id_location_to > a") WebElement flightToField;
    private @FindBy(css="*[id=location_to]") WebElement flightToTextField;

    // DATE
    private @FindBy(css="#flights > form > div:nth-child(3) > div > input") WebElement departDate;


    public void waitToLoad(){

        Core.waitUntilLoaded(flightToTextField);


        Core.waitUntilLoaded(flightsMenuButton);
    }

    public void clickOnFlightsMenuButton(){ flightsMenuButton.click(); }
    public void clickOnSearchButton(){ searchButton.click(); }

    // FLIGHTS - FROM
    public void waitForFlightMenu(){ Core.waitUntilLoaded(flightFromField,flightToField); }
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
