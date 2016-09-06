import core.TestBase;
import elements.Header;
import helpers.Randomizer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import pages.RegistrationPage;
import pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.title;


public class RegistryTest extends TestBase{

    String email = Randomizer.getRandomEmail();
    String firstName = Randomizer.getRandomAlphabeticString();
    String lastName = Randomizer.getRandomAlphabeticString();
    String password = Randomizer.getRandomAlphanumericString();
    String day = Randomizer.getRandomDay();
    String month = Randomizer.getRandomMonth();
    String year = Randomizer.getRandomYear();
    String company = Randomizer.getRandomCompany();
    String address = Randomizer.getRandomAddress();
    String city = Randomizer.getRandomCity();
    String state = Randomizer.getRandomState();
    String postCode = Randomizer.getRandomPostCode();
    String mobileNumber = Randomizer.getRandomMobilePhone();

    String myAccountPageTitle = "My account - My Store";


    @Test
    public void accountForm_CompleteRequiredFieldsWithValidData_MyAccountIsOpened(){
        Header.navigateToLoginPage();
        LoginPage.navigateToRegistrationPageByEntering(email);
        RegistrationPage.completeRegistryFormByEntering(firstName, lastName, password, day, month, year, company,
                address, city, state, postCode, mobileNumber);

        Assert.assertTrue(title().equals(myAccountPageTitle), "Account is not created. " +
                "My Account Page is not displayed");
        Header.logout();
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

