/**
 * Created by Marta Verenchikova on 7/20/2016.
 */

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LentaPageStatic {

    private static final By LOGOTYPE = By.className("header-logo");

    public static boolean isLogotypePresent(WebDriver driver){
        WebElement logo = driver.findElement(LOGOTYPE);

        if(!logo.isDisplayed()){
            return false;
        }
        return true;
    }
}
