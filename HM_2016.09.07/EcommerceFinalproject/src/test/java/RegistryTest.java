import core.TestBase;
import data.RegistryData;
import elements.Header;
import helpers.Randomizer;
import pages.RegistryPage;
import utils.ScreenShooter;
import pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Selenide.title;


@Listeners(ScreenShooter.class)
public class RegistryTest extends TestBase{

    String email = Randomizer.getRandomEmail();
    String myAccountPageTitle = "My account - My Store";


    @Test
    public void accountForm_CompleteRequiredFieldsWithValidData_MyAccountIsOpened(){
        Header.navigateToLoginPage();
        LoginPage.navigateToRegistrationPageByEntering(email);

        RegistryData registryData = new RegistryData();
        RegistryPage.completeRegistryFormByEntering(registryData);

        Assert.assertTrue(title().equals(myAccountPageTitle), "Account is not created. " +
                "My Account Page is not displayed");
    }


    @Test
    public void accountForm_EnterAlreadyRegisteredEmail_ErrorMessageIsShown(){
        String existingEmail = "UserEmail@mail.ru";
        String expectedMessage = "An account using this email address has already been registered. " +
                "Please enter a valid password or request a new one. ";

        Header.navigateToLoginPage();
        LoginPage.navigateToRegistrationPageByEntering(existingEmail);
        LoginPage.isAlreadyRegisteredEmailErrorMessageIdenticalTo(expectedMessage);
    }


}

