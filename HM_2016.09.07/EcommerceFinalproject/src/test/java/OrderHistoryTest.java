import core.TestBase;
import elements.Header;
import pages.LoginPage;
import pages.accountPages.MyAccountPage;
import pages.accountPages.OrderHistoryPage;
import utils.ScreenShooter;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import java.io.FileNotFoundException;


@Listeners(ScreenShooter.class)
public class OrderHistoryTest extends TestBase{

    String email = "UserEmail@mail.ru";
    String password = "Password123";


    @Test
    public void orderHistory_DownloadInvoice_InvoiceIsPresentInFolder() throws FileNotFoundException {
        Header.navigateToLoginPage();
        LoginPage.loginByEntering(email, password);
        MyAccountPage.navigateToOrderHistoryPage();
        Assert.assertTrue(OrderHistoryPage.isFirstFileDownloadingSuccessful(),
                "File doesn't exist in download Folder");
    }

}
