package pages;

import com.codeborne.selenide.SelenideElement;
import helpers.Locators;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static final By CREATE_ACCOUNT_EMAIL_INPUT = Locators.get("createEmailInput");
    private static final By CREATE_ACCOUNT_SUBMIT_BUTTON = Locators.get("createSubmitButton");
    private static final By LOGIN_EMAIL_INPUT = Locators.get("loginEmailInput");
    private static final By LOGIN_PASSWORD_INPUT = Locators.get("loginPasswordInput");
    private static final By LOGIN_SUBMIT_BUTTON = Locators.get("loginSubmitButton");
    private static final By CREATE_ACCOUNT_ERROR_MESSAGE = Locators.get("existingEmailErrorMessage");


    public static void navigateToRegistrationPageByEntering(String email){
        $(CREATE_ACCOUNT_EMAIL_INPUT).setValue(email);
        $(CREATE_ACCOUNT_SUBMIT_BUTTON).click();
    }


    public static void loginByEntering(String email, String password){
        $(LOGIN_EMAIL_INPUT).setValue(email);
        $(LOGIN_PASSWORD_INPUT).setValue(password);
        $(LOGIN_SUBMIT_BUTTON).click();
    }


    public static SelenideElement isAlreadyRegisteredEmailErrorMessageIdenticalTo(String errorMessage){
        return $(CREATE_ACCOUNT_ERROR_MESSAGE).shouldHave(text(errorMessage));
    }
}
