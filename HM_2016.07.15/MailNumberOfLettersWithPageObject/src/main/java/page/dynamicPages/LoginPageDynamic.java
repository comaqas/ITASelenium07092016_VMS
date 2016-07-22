package page.dynamicPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageDynamic {

    private final By EMAIL_FIELD = By.id("mailbox__login");
    private final By PASSWORD_FIELD = By.id("mailbox__password");
    private final By ENTER_BUTTON = By.id("mailbox__auth__button");
    private final By USER_EMAIL_LINK = By.id("PH_user-email");


    private WebDriver driver;

    public LoginPageDynamic(WebDriver driver){
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


    public String isAuthentificationPass(){
        String titleOfInboxPage = driver.getTitle();
        return titleOfInboxPage;
    }

}
