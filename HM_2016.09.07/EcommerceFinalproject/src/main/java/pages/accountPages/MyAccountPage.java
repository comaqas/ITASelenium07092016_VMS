package pages.accountPages;

import helpers.Locators;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;


public class MyAccountPage {

    private static final By ORDER_HISTORY_LINK = Locators.get("orderHistoryLink");

    public static void navigateToOrderHistoryPage(){
        $(ORDER_HISTORY_LINK).click();
    }
}
