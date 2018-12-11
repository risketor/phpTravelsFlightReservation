import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BookingPage;
import pages.FlightsResultsPage;
import pages.HomePage;
import pages.InvoicePage;
import utilities.*;
import java.util.List;

/**
 * @author - Alberto Bartolome Sanchez on 09.12.2018.
 * @project phpTravelsFlightReservation
 */
public class ReserveFlightTest {

    private WebDriver driver = BrowserDriver.getDriver();

    @BeforeMethod
    public void setup() {
        TestHooksMethods.setUp();
    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        TestHooksMethods.tearDown(result,getClass().getName());
    }

    @Test
    public void test_flight_Test() {
        Log.info("Starting test: " + getClass().getName());

        // Initiate Page Factory objects
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        FlightsResultsPage flightsResultsPage = PageFactory.initElements(driver, FlightsResultsPage.class);
        BookingPage bookingPage = PageFactory.initElements(driver, BookingPage.class);
        InvoicePage invoicePage = PageFactory.initElements(driver, InvoicePage.class);

        // Local test data read from the Test Data
        String date = TestData.Flight.getDate();
        String toCity = TestData.Flight.getToCity().toLowerCase();
        String fromCity = TestData.Flight.getFromCity().toLowerCase();
        String address = TestData.User.getAddress().toLowerCase();
        String name = TestData.User.getName().toLowerCase();
        String lastName = TestData.User.getLastName().toLowerCase();
        String email = TestData.User.getEmail().toLowerCase();
        String mobile = TestData.User.getMobile();
        String country = TestData.User.getCountry().toLowerCase();
        String url = TestData.Environment.getURL();

        // HOME PAGE - Open the Test URL from the Test Data file and wait for Home Page to load
        BrowserDriver.loadPage(url);
        homePage.waitToLoad();

        // Selecting Flights menu
        homePage.clickOnFlightsMenuButton();
        homePage.waitForFlightMenu();

        // From field
        homePage.clickOnFlightFromField();
        homePage.enterFlightFromField(fromCity);
        homePage.waitOnFlightDropdownFrom();
        // As we are entering in the search field the full name of the airport, the result is the top one, position 0
        homePage.clickOnFlightDropdownFrom(0);

        // To field
        homePage.clickOnFlightToField();
        homePage.enterFlightToField(toCity);
        homePage.waitOnFlightDropdownFrom();
        // As we are entering in the search field the full name of the airport, the result is the top one, position 0
        homePage.clickOnFlightDropdownFrom(0);

        // Date field
        homePage.clickOnDepartureDate();
        homePage.enterDepartureDate(date);
        homePage.clickOnSearchButton();


        // FLIGHTS RESULTS - click on the lowest price booking
        flightsResultsPage.waitForSearchResultsToLoad();
        // Finding lowest price position, from a list with all the prices, to click on Book Now for that position
        List<Integer> listPrices = flightsResultsPage.getPrices();
        int lowestPricePosition = findLowestPrice(listPrices);
        flightsResultsPage.clickOnBookNowButton(lowestPricePosition);


        // BOOKING PAGE - enter details and click on confirm button
        bookingPage.waitToLoad();

        bookingPage.enterName(name);
        bookingPage.enterLastName(lastName);
        bookingPage.enterEmail(email);
        bookingPage.enterConfirmEmail(email);
        bookingPage.enterMobile(mobile);
        bookingPage.enterAddress(address);
        bookingPage.enterCountry(country);

        bookingPage.clickConfirmButton();


        // INVOICE PAGE - Asserting data displayed in confirmation page with the test data
        invoicePage.waitToLoad();

        String nameAndLastName = name + " " + lastName;
        Log.info("Asserting details in Invoice Page:");
        Log.assertTrue("'" + invoicePage.getNameAndLastName() + "' vs '" + nameAndLastName + "'", invoicePage.getNameAndLastName().equals(nameAndLastName));
        Log.assertTrue("'" + invoicePage.getAddress() + "' vs '" + address + "'", invoicePage.getAddress().equals(address));
        Log.assertTrue("'" + invoicePage.getMobile() + "' vs '" + mobile+ "'", invoicePage.getMobile().equals(mobile));
        Log.assertTrue("'" + invoicePage.getFrom() + "' vs '" + fromCity + "'", invoicePage.getFrom().equals(fromCity));
        Log.assertTrue("'" + invoicePage.getTo() + "' vs '" + toCity + "'", invoicePage.getTo().equals(toCity));
        // Not asserting the Date, as it is displayed wrongly in booking and invoice page.
        // Log.assertTrue("Confirmation Page: '" + invoicePage.getDate() + "' VS '" + date + "'", invoicePage.getDate().equals(date));
        // Not asserting the price is the right one, it seems random in invoice page.

        // Clicking on Pay On Arrival button.
        invoicePage.clickOnPayOnArrivalButton();

        // Switch to the alert and accept it, click Yes to the confirmation for pay on arrival
        Alert alert = driver.switchTo().alert();
        alert.accept();

        // Wait for the reservation status and assert that it is as reserved
        invoicePage.waitForReservationStatus();
        Log.assertTrue("'Reservation completed: '" + invoicePage.getReservationStatus() + "'", invoicePage.getReservationStatus().equals("RESERVED"));
    }

    /**
     * Given a list of integers with the prices, returns the position for the lowest price
     * And saves de lowest price in a test variable (not anymore as that variable is not used)
     *
     * @param list
     * @return
     */
    private static int findLowestPrice(List<Integer> list) {
        int lowestPriceAmount = list.get(0);
        int lowestPricePosition = 0;
        int i = 0;
        for (int s : list) {
            int amount = s;


            if (amount < lowestPriceAmount) {
                lowestPriceAmount = amount;
                lowestPricePosition = i;
            }
            i++;
        }
        Log.info("Lowest flight Lowest Price found is: " + lowestPriceAmount + "$ in position: " + lowestPricePosition);

        // Price variable not used, as the price is not stable during the booking process in the website.
        //flightLowestPrice = lowestPriceAmount;

        return lowestPricePosition;
    }
}
