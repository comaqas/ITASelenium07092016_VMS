package registrationTests;

import core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegistrationPage;

public class PositiveRegistrationTest extends TestBase{

    @Test
    public void fillingRegistrationFormWithValidData(){

        RegistrationPage.fillRegistryFormWithValidData(driver);

        Assert.assertTrue(MainPage.isSuccessRegistrationPopupMessageDisplayed(driver), "Registration is not passed");
    }

}
