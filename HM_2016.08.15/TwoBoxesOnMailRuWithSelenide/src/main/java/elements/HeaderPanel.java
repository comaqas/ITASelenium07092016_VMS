package elements;

import com.codeborne.selenide.Condition;
import helpers.LocatorsParser;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class HeaderPanel {

    private static final By LOGOUT_LINK = LocatorsParser.get("logoutLink");
    private static final By USER_EMAIL_LINK = LocatorsParser.get("userEmailLink");
    private static final By PERSONAL_DATA_LINK = LocatorsParser.get("personalDataLink");


    public static void logout(){
        $(LOGOUT_LINK).waitUntil(Condition.present, 10000).click();
    }

    public static boolean isCorrectUserEmailDisplayed(String email){
        $(LOGOUT_LINK).waitUntil(Condition.present, 10000).text().equals(email);
        return true;
    }

    public static void navigateToSettings(){
        $(USER_EMAIL_LINK).waitUntil(Condition.present, 10000).click();
        $(PERSONAL_DATA_LINK).waitUntil(Condition.present, 10000).click();
    }
}
