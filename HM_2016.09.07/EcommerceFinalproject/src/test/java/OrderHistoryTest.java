import core.TestBase;
import elements.Header;
import org.testng.annotations.AfterTest;
import pages.LoginPage;
import pages.myAccountPages.MyAccountPage;
import pages.myAccountPages.OrderHistoryPage;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class OrderHistoryTest extends TestBase{

    String email = "UserEmail@mail.ru";
    String password = "Password123";
    String expectedFileName = "IN000899";


    @Test
    public void orderHistory_DownloadInvoice_InvoiceIsPresentInFolder() throws FileNotFoundException {
        Header.navigateToLoginPage();
        LoginPage.loginByEntering(email, password);
        MyAccountPage.navigateToOrderHistoryPage();
        OrderHistoryPage.isDownloadFileNameIdenticalTo(expectedFileName);
    }

    @AfterTest
    public void logout(){
        Header.logout();
    }
}
