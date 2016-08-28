import core.PageBase;
import core.TestBase;
import elements.FolderNavigation;
import elements.HeaderPanel;
import pages.LoginPage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ComposeNewLetterTest extends TestBase {

    @BeforeMethod
    public void loginMailBox() {
        LoginPage.login(emailSender, password);
        HeaderPanel.isCorrectUserEmailDisplayed(emailSender);
    }

    @Test
    public void composeNewLetter_CheckSentFolder() {
        PageBase.composeLetter(emailRecipient, subject);
        FolderNavigation.navigateToSentFolder();
        PageBase.isTargetLetterPresentOnTheFirstPageInsideFolder(subject);
   }

    @AfterTest
    public void logoutMailBox(){
        HeaderPanel.logout();
    }
}
