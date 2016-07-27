package pages;

import helpers.LocatorsParserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    public static final By REGISTRATION_LINK = LocatorsParserHelper.get("LoginLink");
    public static final By CONFIRMATION_REGISTRATION_POPUP_MESSAGE = LocatorsParserHelper.get("ConfirmationRegistryPopup");

    public static boolean isSuccessRegistrationPopupMessageDisplayed(WebDriver driver){
        if (driver.findElement(CONFIRMATION_REGISTRATION_POPUP_MESSAGE).isDisplayed()){
            return true;
        }return false;
    }

}
