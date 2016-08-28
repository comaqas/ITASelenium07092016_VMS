package elements;

import com.codeborne.selenide.Condition;
import helpers.LocatorsParser;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class FolderNavigation {

    private static final By SENT_FOLDER_LINK = LocatorsParser.get("sentFolderLink");

    public static void navigateToSentFolder(){
        $(SENT_FOLDER_LINK).waitUntil(Condition.not(Condition.hidden), 10000).click();
    }
}
