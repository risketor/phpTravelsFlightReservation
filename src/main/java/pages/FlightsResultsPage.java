package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserDriver;
import utilities.Core;
import java.util.ArrayList;
import java.util.List;

/**
 * @author - Alberto Bartolome Sanchez on 10.12.2018.
 * @project phpTravelsFlightReservation
 */
public class FlightsResultsPage {

    private @FindBy(css=".strong") List<WebElement> priceList;
    private @FindBy(id="bookbtn") List<WebElement> bookNowButtonList;
    private @FindBy(css=".panel.panel-default") List<WebElement> panelHeadingList;

    // Wait for all elements to load
    public void waitForSearchResultsToLoad(){

        Core.waitUntilLoaded(panelHeadingList);
        // Javascript trick to scroll down to the bottom, so all the prices/bookNow buttons are displayed, as the they are readable until displayed.
        JavascriptExecutor jse = (JavascriptExecutor)BrowserDriver.getDriver();
        for(int i  = 0 ; i < 200 ; i ++){
            jse.executeScript("window.scrollBy(0,20)", "");
        }
        Core.waitUntilLoaded(bookNowButtonList);
        Core.waitUntilLoaded(priceList);
    }

    /**
     * Returning a list of strings with the prices in that page
     * @return
     */
    public List<Integer> getPrices(){
        List<Integer> listPrices = new ArrayList<Integer>();
        for(WebElement e : priceList){
            if(e.getText()!=null) {
                // -1 to remove the $ character
                listPrices.add(Integer.parseInt(e.getText().substring(0, e.getText().length() - 1)));
            }
        }
        return listPrices;
    }

    public void clickOnBookNowButton(int i){ bookNowButtonList.get(i).click(); }
}
