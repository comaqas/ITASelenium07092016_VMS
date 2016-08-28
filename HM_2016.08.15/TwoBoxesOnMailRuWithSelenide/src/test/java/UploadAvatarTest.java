import core.TestBase;
import elements.HeaderPanel;
import pages.LoginPage;
import pages.SettingsPage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadAvatarTest extends TestBase{

    String pathToInitialAvatar = "Avatar.png";
    String pathToUpdateAvatar = "BlackSquare.png";

   @BeforeMethod
    public void loginMailBox(){
        LoginPage.login(emailSender, password);
        HeaderPanel.isCorrectUserEmailDisplayed(emailSender);
    }

    @Test
    public void udploadAvatar(){
        HeaderPanel.navigateToSettings();
        SettingsPage.uploadAvatar(pathToInitialAvatar);
    }

    @AfterTest
    public void updateAvatar(){
        SettingsPage.uploadAvatar(pathToUpdateAvatar);
        HeaderPanel.logout();
    }
}
