package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Core;

/**
 * @author - Alberto Bartolome Sanchez on 10.12.2018.
 * @project phpTravelsFlightReservation
 */
public class InvoicePage {

    private @FindBy(css="div:nth-child(2) > table > tbody > tr > td > div:nth-child(2)") WebElement nameAndLastNameField;
    private @FindBy(css="div:nth-child(2) > table > tbody > tr > td > div:nth-child(3)") WebElement addressField;
    private @FindBy(css="div:nth-child(2) > table > tbody > tr > td > div:nth-child(4)") WebElement mobileField;
    private @FindBy(css="tbody > tr:nth-child(2) > td:nth-child(3)") WebElement fromField;
    private @FindBy(css="tbody > tr:nth-child(3) > td:nth-child(3)") WebElement toField;
    private @FindBy(css="tbody > tr:nth-child(2) > td:nth-child(1) > p") WebElement dateField;
    private @FindBy(css=".form-group .btn.btn-default") WebElement payOnArrivalButton;
    private @FindBy(css="#invoiceTable > tbody > tr:nth-child(1) > td > div > b") WebElement reservationStatus;


    public void waitToLoad() {
        Core.waitUntilLoaded(nameAndLastNameField,addressField,mobileField,fromField,toField,dateField,payOnArrivalButton);
    }

    public String getNameAndLastName() {
        return nameAndLastNameField.getText().toLowerCase();
    }
    public String getAddress() { return addressField.getText().toLowerCase(); }
    public String getMobile() {
        return mobileField.getText();
    }
    public String getFrom() {
        return fromField.getText().toLowerCase();
    }
    public String getTo() {
        return toField.getText().toLowerCase();
    }
    public String getDate() { return dateField.getText(); }
    public void waitForReservationStatus(){ Core.waitUntilLoaded(reservationStatus); }
    public String getReservationStatus(){ return reservationStatus.getText(); }
    public void clickOnPayOnArrivalButton() { payOnArrivalButton.click(); }
}
