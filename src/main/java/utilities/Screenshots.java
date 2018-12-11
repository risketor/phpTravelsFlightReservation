package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;

/**
 * @author - Alberto Bartolome Sanchez on 09.12.2018.
 * @project phpTravelsFlightReservation
 */
public class Screenshots {

        /**
         * Take screenshot to Log folder, throw exception otherwise
         */
        public static void takeScreenshot(String nameFile) {
            try {
                File screenshot = ((TakesScreenshot) BrowserDriver.getDriver()).getScreenshotAs(OutputType.FILE);
                String folderName = "logs/" + nameFile + ".png";
                FileUtils.copyFile(screenshot, new File(folderName));
                Log.info("Screenshot created: " + folderName);
            } catch (Exception e) {
                Log.exception("Screenshot: " + e.getMessage());
            }
        }
    }
