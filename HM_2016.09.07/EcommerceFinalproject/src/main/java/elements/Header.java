package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

import helpers.Locators;


public class Header {

    private static final By CONTACT_US_LINK = Locators.get("contactUsLink");
    private static final By LOGIN_LINK = Locators.get("loginLink");
    private static final By LOGOTYPE = Locators.get("logotype");
    private static final By SEARCH_INPUT_FIELD = Locators.get("searchInput");
    private static final By SHOPPING_CART = Locators.get("shoppingCard");
    private static final By CATALOG_MENU_WOMEN_TAB = Locators.get("womenTabInCatalogMenu");
    private static final By T_SHIRTS_CATALOG_LINK = Locators.get("tShirtsCatalogLink");
    private static final By ACCOUNT_LINK = Locators.get("accountLink");
    private static final By LOGOUT_LINK = Locators.get("logoutLink");


    public static void navigateToContactUsPage(){
        $(CONTACT_US_LINK).click();
    }


    public static void navigateToLoginPage(){
        $(LOGIN_LINK).click();
    }


    public static SelenideElement isInsideDisplayedUserNamePresent(String expectedName){
        return $(ACCOUNT_LINK).shouldHave(text(expectedName));
    }


    public static boolean isUserNameDisappearedFromHeader(){
        return $(ACCOUNT_LINK).is(disappear);
    }


    public static void logout(){
        $(LOGOUT_LINK).click();
    }


    public static void navigateToCartPage(){
        $(SHOPPING_CART).click();
    }


    public static void navigateToMyAccountPage(){
        $(ACCOUNT_LINK).click();
    }


    public static void navigateToHomePage(){
        $(LOGOTYPE).click();
    }


    public static void navigateToTShirtsCatalogPage(){
        $(CATALOG_MENU_WOMEN_TAB).hover();
        $(T_SHIRTS_CATALOG_LINK).click();
    }


    public static void searchFor(String text){
        $(SEARCH_INPUT_FIELD).setValue(text).pressEnter();
    }
}
