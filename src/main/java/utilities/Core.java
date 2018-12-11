package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;


/**
 * @author - Alberto Bartolome Sanchez on 09.12.2018.
 * @project phpTravelsFlightReservation
 * To help with webDriver with visible elements and wait for them
 */
public class Core {
    // Get time out amount in seconds from Test Data config
    private static int timeOut = TestData.RunnerConfig.getTimeOut();

    /**
     * Wait until loaded for one or several WebElements
     *
     * @param elements
     * @return
     */
    public static void waitUntilLoaded(WebElement... elements) {
        List<WebElement> listOfPageElements = new ArrayList<WebElement>();
        for (WebElement element : elements) {
            listOfPageElements.add(element);
        }
        waitForVisibleElements(listOfPageElements, timeOut);
    }

    /**
     * Wait until loaded for a List of WebElements
     *
     * @param elements
     * @return
     */
    public static void waitUntilLoaded(List<WebElement> elements) {
        waitForVisibleElements(elements, timeOut);
    }

    private static void waitForVisibleElements(List<WebElement> elements, int timeToWait) {
        try {
            WebDriverWait wait = new WebDriverWait(BrowserDriver.getDriver(), timeToWait);
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (Exception e) {
            Log.exception("Waiting for visible elements " + e.getMessage());
        }
    }
}
