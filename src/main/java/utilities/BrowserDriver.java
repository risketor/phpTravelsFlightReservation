package utilities;

import org.openqa.selenium.WebDriver;

/**
 * @author - Alberto Bartolome Sanchez on 09.12.2018.
 * @project phpTravelsFlightReservation
 */
public class BrowserDriver {

    private static WebDriver driver;

    /**
     * Returning the actual driver, or create it if it hasn't been create previously before
     *
     * @return
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                driver = BrowserManager.createChromeDriver();
            } catch (Exception e) {
                Log.exception("There has been an error while creating the driver: " + e);
            }
        }
        return driver;
    }

    public static void loadPage(String aURL) {
        driver = getDriver();
        driver.get(aURL);
    }

    /**
     * Delete all cookies and quit the driver
     */
    public static void quit() {
        if (driver != null) {
            try {
                driver.manage().deleteAllCookies();
                driver.quit();
                driver = null;
            } catch (Exception e) {
                Log.exception("Error occurred whilst tyring to quit webDriver " + e);
            }
        }
    }
}
