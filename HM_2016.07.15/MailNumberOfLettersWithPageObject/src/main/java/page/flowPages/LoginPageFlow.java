package page.flowPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPageFlow {

    private final By EMAIL_FIELD = By.id("mailbox__login");
    private final By PASSWORD_FIELD = By.id("mailbox__password");
    private final By ENTER_BUTTON = By.id("mailbox__auth__button");
    private final By USER_EMAIL_LINK = By.id("PH_user-email");

    private WebDriver driver;

    public LoginPageFlow(WebDriver driver){
        this.driver = driver;
    }

    public LoginPageFlow typeIntoInputFieldEmail(String email){
        WebElement emailInputField = driver.findElement(EMAIL_FIELD);
        emailInputField.sendKeys(email);
        return this;
    }

    public LoginPageFlow typeIntoInputFieldPassword(String password){
        WebElement passwordInputField = driver.findElement(PASSWORD_FIELD);
        passwordInputField.sendKeys(password);
        return this;
    }

    public LoginPageFlow clickOnButtonForMailEntering(){
        WebElement enterButton = driver.findElement(ENTER_BUTTON);
        enterButton.click();
        return this;
    }

}
