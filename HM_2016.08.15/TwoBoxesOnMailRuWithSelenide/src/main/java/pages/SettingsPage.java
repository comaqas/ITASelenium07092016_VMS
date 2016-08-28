package pages;

import helpers.LocatorsParser;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

import java.io.File;


public class SettingsPage {

    private static final By UPLOAD_AVATAR_BUTTON = LocatorsParser.get("uploadAvatarButton");
    private static final By SAVE_AVATAR_BUTTON = LocatorsParser.get("saveAvatarButton");


    public static void uploadAvatar(String pathToAvatar) {
        $(UPLOAD_AVATAR_BUTTON).uploadFile(new File(pathToAvatar));
        $(SAVE_AVATAR_BUTTON).click();
    }
}
