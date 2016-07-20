/**
 * Created by Marta Verenchikova on 20-Jul-16.
 */

package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginAndInboxFolderPageDynamic {

    private final By EMAIL_FIELD = By.id("mailbox__login");
    private final By PASSWORD_FIELD = By.id("mailbox__password");
    private final By ENTER_BUTTON = By.id("mailbox__auth__button");
    private final By USER_EMAIL_LINK = By.id("PH_user-email");
    private final By CHECK_BOX_SELECT_ALL_LETTERS_ON_PAGE = By.cssSelector(".b-dropdown__ctrl .b-checkbox__box");
    private final By TEXT_LINK_SELECT_ALL_LETTERS_IN_FOLDER = By.cssSelector(".pseudo-link[data-name='selectAllLetters']");
    private final By NUMBER_OF_LETTERS_IN_FOLDER = By.className("b-announcement__text");

    private WebDriver driver;

    public LoginAndInboxFolderPageDynamic(WebDriver driver){
        this.driver = driver;
    }

    public void typeIntoInputFieldEmail(String email){
        WebElement emailInputField = driver.findElement(EMAIL_FIELD);
        emailInputField.sendKeys(email);
    }


    public void typeIntoInputFieldPassword(String password){
        WebElement passwordInputField = driver.findElement(PASSWORD_FIELD);
        passwordInputField.sendKeys(password);
    }


    public void clickOnButtonForMailEntering(){
        WebElement enterButton = driver.findElement(ENTER_BUTTON);
        enterButton.click();
    }


    public boolean isAuthentificationPass(String email){
        WebElement userEmailLink = driver.findElement(USER_EMAIL_LINK);

        if (userEmailLink.isDisplayed() && userEmailLink.getText().equals(email)){
            return true;
        }
        return false;
    }


    public void selectAllLettersOnPage(){
        WebElement selectAllLettersOnPageCheckBox = driver.findElement(CHECK_BOX_SELECT_ALL_LETTERS_ON_PAGE);
        selectAllLettersOnPageCheckBox.click();
    }

    public void selectALlLettersInFolder(){
        WebElement selectAllLettersInFolderTextLink = driver.findElement(TEXT_LINK_SELECT_ALL_LETTERS_IN_FOLDER);
        selectAllLettersInFolderTextLink.click();
    }


    // метод возвращает количетсво писем (Х) путем разбиения строки
    // "Выделено Х писем. Снять выделение со всех писем в папке «Входящие»" на части по символу пробела

    public String calculateNumberOfLettersInFolder() {
        WebElement fullResultMessageWithNumberOfLetters = driver.findElement(NUMBER_OF_LETTERS_IN_FOLDER);

        String shortResultMessageWithNumberOfLetters = fullResultMessageWithNumberOfLetters.getText();

        String[] numberOfLettersInFolder = shortResultMessageWithNumberOfLetters.split(" ");

        return numberOfLettersInFolder[1];
    }

}
