import core.TestBase;
import helpers.Randomizer;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InboxPage;
import pages.MainPage;
import pages.SentBoxPage;


public class SendLetterTest extends TestBase {

    @Test
    public void checkPresenceOfSentLetterInsideSentBox() throws InterruptedException {

        String userEmail = "testernumberone@tut.by";
        String userPassword = "ZXCvbn123";
        String subject = Randomizer.getRandomSubject();
        String message = Randomizer.getRandomMessage();


        MainPage.login(driver, userEmail, userPassword);

        String winHandleBefore = driver.getWindowHandle();
        MainPage.navigateToInbox(driver);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        InboxPage.composeNewLetter(driver, userEmail, subject, message);
        InboxPage.navigateToSentLettersFolder(driver);

        driver.navigate().refresh();
        Assert.assertTrue(SentBoxPage.isInterestedLetterPresentInSentBox(driver, subject),
                "Just sent letter is not present in a Sent Box");
    }
}