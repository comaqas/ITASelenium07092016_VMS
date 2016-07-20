/**
 * Created by Marta Verenchikova on 20-Jul-16.
 */

package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.fail;


public class LoginAndInboxFolderPageFlow {

    private final By EMAIL_FIELD = By.id("mailbox__login");
    private final By PASSWORD_FIELD = By.id("mailbox__password");
    private final By ENTER_BUTTON = By.id("mailbox__auth__button");
    private final By USER_EMAIL_LINK = By.id("PH_user-email");
    private final By CHECK_BOX_SELECT_ALL_LETTERS_ON_PAGE = By.cssSelector(".b-dropdown__ctrl .b-checkbox__box");
    private final By TEXT_LINK_SELECT_ALL_LETTERS_IN_FOLDER = By.cssSelector(".pseudo-link[data-name='selectAllLetters']");
    private final By NUMBER_OF_LETTERS_IN_FOLDER = By.className("b-announcement__text");

    private WebDriver driver;

    public LoginAndInboxFolderPageFlow(WebDriver driver){
        this.driver = driver;
    }

    public LoginAndInboxFolderPageFlow typeIntoInputFieldEmail(String email){
        WebElement emailInputField = driver.findElement(EMAIL_FIELD);
        emailInputField.sendKeys(email);
        return this;
    }


    public LoginAndInboxFolderPageFlow typeIntoInputFieldPassword(String password){
        WebElement passwordInputField = driver.findElement(PASSWORD_FIELD);
        passwordInputField.sendKeys(password);
        return this;
    }


    public LoginAndInboxFolderPageFlow clickOnButtonForMailEntering(){
        WebElement enterButton = driver.findElement(ENTER_BUTTON);
        enterButton.click();
        return this;
    }


    public LoginAndInboxFolderPageFlow isAuthentificationPass(String email){
        WebElement userEmailLink = driver.findElement(USER_EMAIL_LINK);

        if (!userEmailLink.isDisplayed() || !userEmailLink.getText().equals(email)){
            fail("\nThe authentification wasn't passed. Please, check your e-mail and password");
        }
        return this;
    }

    public LoginAndInboxFolderPageFlow selectAllLettersOnPage(){
        WebElement selectAllLettersOnPageCheckBox = driver.findElement(CHECK_BOX_SELECT_ALL_LETTERS_ON_PAGE);
        selectAllLettersOnPageCheckBox.click();
        return this;
    }

    public LoginAndInboxFolderPageFlow selectALlLettersInFolder(){
        WebElement selectAllLettersInFolderTextLink = driver.findElement(TEXT_LINK_SELECT_ALL_LETTERS_IN_FOLDER);
        selectAllLettersInFolderTextLink.click();
        return this;
    }


    // чтобы применить Page Factory пришлось изменить логику метода, поскольку тип возвражщаемого значения
    // не строка (как во всех остальных случаях), а страница

    public LoginAndInboxFolderPageFlow calculateNumberOfLettersInFolder() {
        WebElement fullResultMessageWithNumberOfLetters = driver.findElement(NUMBER_OF_LETTERS_IN_FOLDER);

        String shortResultMessageWithNumberOfLetters = fullResultMessageWithNumberOfLetters.getText();

        String[] numberOfLettersInFolder = shortResultMessageWithNumberOfLetters.split(" ");

        String numberOfLetters = numberOfLettersInFolder[1];

        if (!numberOfLetters.equals("52")){
            fail("\nIncorrect calculation of letters or, maybe, number of letters in a box weas changed by other users");
        }

        return this;
    }

}
