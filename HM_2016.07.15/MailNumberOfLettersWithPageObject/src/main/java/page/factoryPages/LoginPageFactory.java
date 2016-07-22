package page.factoryPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFactory {

    @FindBy(id = "mailbox__login")
    private WebElement emailInputField;

    @FindBy(id = "mailbox__password")
    private WebElement passwordInputField;

    @FindBy(id = "mailbox__auth__button")
    private WebElement enterButton;

    public void typeIntoInputFieldEmail(String email){
        emailInputField.sendKeys(email);
    }

    public void typeIntoInputFieldPassword(String password){
        passwordInputField.sendKeys(password);
    }

    public void clickOnButtonForMailEntering(){
        enterButton.click();
    }

}
