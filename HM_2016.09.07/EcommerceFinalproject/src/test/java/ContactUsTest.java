import core.TestBase;
import data.ContactUsData;
import elements.Header;
import org.testng.annotations.Listeners;
import pages.ContactUsPage;

import org.testng.annotations.Test;
import utils.ScreenShooter;

@Listeners(ScreenShooter.class)
public class ContactUsTest extends TestBase {

      String emptyMessage = null;
      String successText = "Your message has been successfully sent to our team.";
      String errorText = "There is 1 error The message cannot be blank.";


    @Test
    public void contactUsMessageForm_CompleteWithTextEntering_SuccessIsDisplayed(){
        ContactUsData contactUsData = new ContactUsData();
        Header.navigateToContactUsPage();
        ContactUsPage.completeMessageFormWith(contactUsData);
        ContactUsPage.isSuccessAlertDisplayedWith(successText);
    }


    @Test
    public void contactUsMessageForm_CompleteWithoutTextEntering_WarningIsDisplayed(){
        ContactUsData contactUsData = new ContactUsData(emptyMessage);
        Header.navigateToContactUsPage();
        ContactUsPage.completeMessageFormWith(contactUsData);
        ContactUsPage.isWarningAlertDisplayedWith(errorText);
    }
}
