/**
 * Created by Marta Verenchikova on 20-Jul-16.
 */

package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginAndInboxFolderPageStatic {

    private static final By EMAIL_FIELD = By.id("mailbox__login");
    private static final By PASSWORD_FIELD = By.id("mailbox__password");
    private static final By ENTER_BUTTON = By.id("mailbox__auth__button");
    private static final By USER_EMAIL_LINK = By.id("PH_user-email");
    private static final By CHECK_BOX_SELECT_ALL_LETTERS_ON_PAGE = By.cssSelector(".b-dropdown__ctrl .b-checkbox__box");
    private static final By TEXT_LINK_SELECT_ALL_LETTERS_IN_FOLDER = By.cssSelector(".pseudo-link[data-name='selectAllLetters']");
    private static final By NUMBER_OF_LETTERS_IN_FOLDER = By.className("b-announcement__text");


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


    public static boolean isAuthentificationPass(WebDriver driver, String email){
        WebElement userEmailLink = driver.findElement(USER_EMAIL_LINK);

        if (userEmailLink.isDisplayed() && userEmailLink.getText().equals(email)){
            return true;
        }

        return false;
    }


    public static void selectAllLettersOnPage(WebDriver driver){
        WebElement selectAllLettersOnPageCheckBox = driver.findElement(CHECK_BOX_SELECT_ALL_LETTERS_ON_PAGE);
        selectAllLettersOnPageCheckBox.click();
    }

    public static void selectALlLettersInFolder(WebDriver driver){
        WebElement selectAllLettersInFolderTextLink = driver.findElement(TEXT_LINK_SELECT_ALL_LETTERS_IN_FOLDER);
        selectAllLettersInFolderTextLink.click();
    }


    // метод возвращает количетсво писем (Х) путем разбиения строки
    // "Выделено Х писем. Снять выделение со всех писем в папке «Входящие»" на части по символу пробела

    public static String calculateNumberOfLettersInFolder(WebDriver driver) {
        WebElement fullResultMessageWithNumberOfLetters = driver.findElement(NUMBER_OF_LETTERS_IN_FOLDER);

        String shortResultMessageWithNumberOfLetters = fullResultMessageWithNumberOfLetters.getText();

        String[] numberOfLettersInFolder = shortResultMessageWithNumberOfLetters.split(" ");

        return numberOfLettersInFolder[1];
    }

}
