package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author - Alberto Bartolome Sanchez on 09.12.2018.
 * @project phpTravelsFlightReservation
 */
public class BrowserManager {
    /**
     * Create webDriver Chrome browser
     * window maximized
     * @return
     */
    public static WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // driver.manage().window().maximize();

        return driver;
    }
}