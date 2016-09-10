import core.TestBase;
import elements.Header;
import org.testng.annotations.Listeners;
import pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ScreenShooter;

@Listeners(ScreenShooter.class)
public class AuthenticationTest extends TestBase {

    String email = "UserEmail@mail.ru";
    String password = "Password123";
    String expectedUserName = "Tester";


    @Test
    public void authentication_LoginAndLogout_UserNameIsNotDisplayed(){
        Header.navigateToLoginPage();
        LoginPage.loginByEntering(email, password);
        Header.isInsideDisplayedUserNamePresent(expectedUserName);
        Header.logout();
        Assert.assertTrue(Header.isUserNameDisappearedFromHeader(),
                "After logout User Name is still present in Site Header");
    }
}
