package utilities;

import org.junit.Assert;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author - Alberto Bartolome Sanchez on 09.12.2018.
 * @project phpTravelsFlightReservation
 * Methods to be called from the Hooks in the test, so they are reusable for other hooks.
 * Setting up and tearing down.
 */
public class TestHooksMethods {

    protected static TestDataManager testData = null;

    /**
     * Set up before tests
     * Save current date.time in system properties, to be used in logs and screenshot names.
     * Initialize Test Data file location and name
     */
    public static void setUp() {

        // Set system property with current date, to be used in logs and screenshot names.
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        System.setProperty("current.date.time", dateFormat.format(new Date()));

        // Initialize the test data manager object with the test data file location and name
        testData = new TestDataManager("./" + TestData.TESTDATA_LOCATION);
    }

    /**
     * Tearing down after the test
     * If failed, a screenshot is taken
     * Quit the driver (close browser)
     * @param result
     * @param testClassName
     */
    public static void tearDown(ITestResult result, String testClassName) {

        if (ITestResult.FAILURE == result.getStatus()) {

            // Taking a screenshot if the test failed
            try {
                String fileName = "FAILED_" + System.getProperty("current.date.time");
                Screenshots.takeScreenshot(fileName);
            } catch (Exception e) {
                Log.info("Exception while taking screenshot " + e.getMessage());
            }
        } else if (ITestResult.SUCCESS == result.getStatus()) {
            Log.info("TEST PASSED: " + testClassName);
        } else {
            Assert.fail("Test Status not expected: " + result.getStatus());
        }

        BrowserDriver.quit();
    }
}
