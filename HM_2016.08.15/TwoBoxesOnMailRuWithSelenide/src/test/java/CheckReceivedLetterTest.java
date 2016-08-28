import core.PageBase;
import core.TestBase;
import elements.HeaderPanel;
import pages.LoginPage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckReceivedLetterTest extends TestBase{

    @BeforeMethod
    public void loginMailBox() {
        LoginPage.login(emailRecipient, password);
        HeaderPanel.isCorrectUserEmailDisplayed(emailRecipient);
    }

    @Test
    public void checkInboxFolder_CalculateNumberOfLetters() {
        PageBase.isTargetLetterPresentOnTheFirstPageInsideFolder(subject);
        PageBase.calculateNumberOfLettersInsideFolder();
    }


    @AfterTest
    public void logoutMailBox(){
        HeaderPanel.logout();
    }
}
