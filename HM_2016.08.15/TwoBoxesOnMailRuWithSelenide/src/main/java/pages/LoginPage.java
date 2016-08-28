package pages;

import helpers.LocatorsParser;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static final By EMAIL_INPUT = LocatorsParser.get("emailInput");
    private static final By PASSWORD_INPUT = LocatorsParser.get("passwordInput");
    private static final By ENTER_BUTTON = LocatorsParser.get("enterButton");

    public static void login(String email, String password){
        $(EMAIL_INPUT).setValue(email);
        $(PASSWORD_INPUT).setValue(password);
        $(ENTER_BUTTON).click();
    }
}
