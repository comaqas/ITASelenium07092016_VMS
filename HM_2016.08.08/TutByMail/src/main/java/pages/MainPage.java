/*
Поскольку при написании теста выполнялись промежуточные проверки,
я остаивла все методы, которые использовала
*/

package pages;

import helpers.LocatorsParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {

    public static final By ENTER_LINK = LocatorsParser.get("enterLink");
    public static final By LOGIN_INPUT = LocatorsParser.get("loginInput");
    public static final By PASSWORD_LINK = LocatorsParser.get("passwordInput");
    public static final By ENTER_BUTTON = LocatorsParser.get("enterButton");
    public static final By USER_NAME_NOTATION = LocatorsParser.get("userNameNotation");
    public static final By EMAIL_LINK = LocatorsParser.get("emailLink");

    public static boolean verifyMainPageTitle(WebDriver driver, String title){
        return driver.getTitle().equals(title);
    }


    public static void login(WebDriver driver, String login, String password){
        driver.findElement(ENTER_LINK).click();
        driver.findElement(LOGIN_INPUT).sendKeys(login);
        driver.findElement(PASSWORD_LINK).sendKeys(password);
        driver.findElement(ENTER_BUTTON).click();
   }


    public static boolean verifyUserNameNotation(WebDriver driver, String name){
        return driver.findElement(USER_NAME_NOTATION).getText().equals(name);
    }

    public static void navigateToInbox(WebDriver driver){
        driver.findElement(USER_NAME_NOTATION).click();
        driver.findElement(EMAIL_LINK).click();
    }
}
