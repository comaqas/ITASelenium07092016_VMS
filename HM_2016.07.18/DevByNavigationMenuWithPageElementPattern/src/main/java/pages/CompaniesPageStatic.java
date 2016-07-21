/**
 * Created by Marta Verenchikova on 7/20/2016.
 */

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CompaniesPageStatic {

    private static final By ISSOFT_COMPANY = By.cssSelector("#tablesort [data='ISsoft']");

    public static boolean isIsSoftCompanyPresentInTable(WebDriver driver){
        WebElement isSoftCompany = driver.findElement(ISSOFT_COMPANY);

        if (!isSoftCompany.isDisplayed()){
            return false;
        }
        return true;
    }
}
