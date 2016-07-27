package registrationTests;

import core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegistrationPage;

public class NegativeRegistrationTest extends TestBase {

    @Test
    public void fillingRegistrationFormWithInvalidUserName(){

        RegistrationPage.fillRegistryFormWithInvalidUserName(driver);

        Assert.assertTrue(RegistrationPage.isWarningMessageAboutForbiddenSymbolsDisplayed(driver),
                "Registration is passed in spite of invalid User Name typing");
    }


    @Test
    public void fillingRegistrationFormWithDifferentPasswords(){

        RegistrationPage.fillRegistryFormWithDifferentPasswords(driver);

        Assert.assertTrue(RegistrationPage.isWarningMessageAboutUnmatchedUserPasswordsDisplayed(driver),
                "Registration is passed in spite of unmatched User Passwords typing");
    }


    @Test
    public void fillingRegistrationFormWithoutAgreementMark(){

        RegistrationPage.fillRegistryFormWithoutAgreementMark(driver);

        Assert.assertTrue(RegistrationPage.isWarningMessageAboutUnmarkedAgreementlsDisplayed(driver),
                "Registration is passed in spite of unmarked Agreement check-box");
    }

}
