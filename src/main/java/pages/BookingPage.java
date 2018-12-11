package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Core;

/**
 * @author - Alberto Bartolome Sanchez on 10.12.2018.
 * @project phpTravelsFlightReservation
 */
public class BookingPage {

    private @FindBy(css="#guestform > div:nth-child(1) > div:nth-child(2) > input") WebElement firstNameField;
    private @FindBy(css="#guestform > div:nth-child(1) > div:nth-child(3) > input") WebElement lastNameField;
    private @FindBy(css="#guestform > div:nth-child(2) > div:nth-child(2) > input") WebElement emailField;
    private @FindBy(css="#guestform > div:nth-child(2) > div:nth-child(3) > input") WebElement confirmEmailField;
    private @FindBy(css="#guestform > div:nth-child(3) > div.col-md-10.col-xs-10 > input") WebElement mobileField;
    private @FindBy(css="#guestform > div:nth-child(4) > div.col-md-10.col-xs-10 > input") WebElement addressField;
    private @FindBy(css=".btn.btn-success.btn-lg") WebElement confirmBookingButton;
    private @FindBy(id="s2id_autogen1") WebElement countryDropdown;
    private @FindBy(css=".select2-drop .select2-search .select2-input") WebElement countryTextSearchField;

    // Wait for all elements to load
    public void waitToLoad(){
        Core.waitUntilLoaded(firstNameField,lastNameField,emailField,confirmEmailField,mobileField,addressField,confirmBookingButton);
    }

    public void enterName(String name) { firstNameField.sendKeys(name); }
    public void enterLastName(String lastName) { lastNameField.sendKeys(lastName); }
    public void enterEmail(String email) { emailField.sendKeys(email); }
    public void enterConfirmEmail(String email) { confirmEmailField.sendKeys(email); }
    public void enterMobile(String mobile) { mobileField.sendKeys(mobile); }
    public void enterAddress(String address) { addressField.sendKeys(address); }
    public void clickConfirmButton(){ confirmBookingButton.click(); }
    public void enterCountry(String country) {
        countryDropdown.click();
        countryTextSearchField.sendKeys(country);
        countryTextSearchField.sendKeys(Keys.ENTER);
    }
}
