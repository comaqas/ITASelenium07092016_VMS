import core.TestBase;
import elements.Header;
import pages.ContactUsPage;
import helpers.Randomizer;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ContactUsTest extends TestBase {

    String subject = Randomizer.getRandomSubjectHeading();
    String email = Randomizer.getRandomEmail();
    String order = Randomizer.getRandomAlphanumericString();
    String pathToFile = "Test.txt";
    String messageText = Randomizer.getRandomAlphabeticString();
    String successText = "Your message has been successfully sent to our team.";
    String errorText = "There is 1 error The message cannot be blank.";


    @Test
    public void contactUsMessageForm_CompleteWithTextEntering_SuccessIsDisplayed(){
        Header.navigateToContactUsPage();
        ContactUsPage.completeMessageFormWithData(subject, email, order, pathToFile, messageText);
        ContactUsPage.isSuccessAlertDisplayedWith(successText);
    }


    @Test
    public void contactUsMessageForm_CompleteWithoutTextEntering_WarningIsDisplayed(){
        Header.navigateToContactUsPage();
        ContactUsPage.completeMessageFormWithData(subject, email, order, pathToFile, null);
        ContactUsPage.isWarningAlertDisplayedWith(errorText);
    }
}
