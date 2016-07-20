/**
 * Created by Marta Verenchikova on 20-Jul-16.
 */

package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class LoginAndInboxFolderPageFactory {

    @FindBy(id = "mailbox__login")
    private WebElement emailInputField;

    @FindBy(id = "mailbox__password")
    private WebElement passwordInputField;

    @FindBy(id = "mailbox__auth__button")
    private WebElement enterButton;

    @FindBy(id = "PH_user-email")
    private WebElement userEmailLink;

    @FindBy(css = ".b-dropdown__ctrl .b-checkbox__box")
    private WebElement selectAllLettersOnPageCheckBox;

    @FindBy(css = ".pseudo-link[data-name='selectAllLetters']")
    private WebElement  selectAllLettersInFolderTextLink;

    @FindBy(className = "b-announcement__text")
    private WebElement numberOfLettersInFolderText;



    public void typeIntoInputFieldEmail(String email){
        emailInputField.sendKeys(email);
    }

    public void typeIntoInputFieldPassword(String password){
        passwordInputField.sendKeys(password);
    }

    public void clickOnButtonForMailEntering(){
        enterButton.click();
    }


    public boolean isAuthentificationPass(String email){

        if (userEmailLink.isDisplayed() && userEmailLink.getText().equals(email)){
            return true;
        }
        return false;
    }

    public void selectAllLettersOnPage(){
        selectAllLettersOnPageCheckBox.click();
    }

    public void selectALlLettersInFolder(){
        selectAllLettersInFolderTextLink.click();
    }


    // метод возвращает количетсво писем (Х) путем разбиения строки
    // "Выделено Х писем. Снять выделение со всех писем в папке «Входящие»" на части по символу пробела

    public String calculateNumberOfLettersInFolder() {
        WebElement fullResultMessageWithNumberOfLetters = numberOfLettersInFolderText;

        String shortResultMessageWithNumberOfLetters = fullResultMessageWithNumberOfLetters.getText();

        String[] numberOfLettersInFolder = shortResultMessageWithNumberOfLetters.split(" ");

        return numberOfLettersInFolder[1];
    }


}
