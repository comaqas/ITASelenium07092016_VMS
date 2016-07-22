package page.staticPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageStatic {

    private static final By EMAIL_FIELD = By.id("mailbox__login");
    private static final By PASSWORD_FIELD = By.id("mailbox__password");
    private static final By ENTER_BUTTON = By.id("mailbox__auth__button");


    public static void typeIntoInputFieldEmail(WebDriver driver, String email){
        WebElement emailInputField = driver.findElement(EMAIL_FIELD);
        emailInputField.sendKeys(email);
    }

    public static void typeIntoInputFieldPassword(WebDriver driver, String password){
        WebElement passwordInputField = driver.findElement(PASSWORD_FIELD);
        passwordInputField.sendKeys(password);
    }


    public static void clickOnButtonForMailEntering(WebDriver driver){
        WebElement enterButton = driver.findElement(ENTER_BUTTON);
        enterButton.click();
    }


    public static String isAuthentificationPass(WebDriver driver){
        String titleOfInboxPage = driver.getTitle();
        return titleOfInboxPage;
    }

}
