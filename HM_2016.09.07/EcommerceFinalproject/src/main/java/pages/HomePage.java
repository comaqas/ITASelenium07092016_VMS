package pages;

import com.codeborne.selenide.SelenideElement;
import helpers.Locators;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private static final By HEADING = Locators.get("heading");

    public static SelenideElement isHeadingIdenticalTo(String expectedHeading){
        return $(HEADING).shouldHave(exactText(expectedHeading));
    }
}
