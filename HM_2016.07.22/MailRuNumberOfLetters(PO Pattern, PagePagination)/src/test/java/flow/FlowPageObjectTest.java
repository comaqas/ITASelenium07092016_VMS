/*
1 - Возникли проблемы с паттерном Flow (поскольку все методы возвращают сами страницы)
2 - в паттерне PageFactory не получилось метод c driver.getTitle описать в самой странице, пришлось вынести в тест
 */

package flow;

import core.TestBase;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.flowPages.InboxPageFlow;
import page.flowPages.LoginPageFlow;
import page.staticPages.InboxPageStatic;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


public class FlowPageObjectTest extends TestBase {

    String titleOfInboxPage = "Входящие - Почта Mail.Ru";
    int expectedNumberOfLettersInbox = 53;

    @BeforeTest
    public void setup(){

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ru/");

        LoginPageFlow loginPage = new LoginPageFlow(driver);

        loginPage
                    .typeIntoInputFieldEmail("strong.zubovich@bk.ru")
                    .typeIntoInputFieldPassword("ZXCvbn123!")
                    .clickOnButtonForMailEntering();
   }


    @Test
    public void calculateNumberOfLettersInFolder(){

        InboxPageFlow inboxPage= new InboxPageFlow(driver);

        // проверяем, что авторизация прошла успешно


        inboxPage
                .isAuthentificationPassed(titleOfInboxPage)
                .calculateNumberOfLettersInFolder(expectedNumberOfLettersInbox);

    }
}
