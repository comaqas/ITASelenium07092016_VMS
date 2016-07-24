/*
1 - Возникли проблемы с паттерном Flow (поскольку все методы возвращают сами страницы)
2 - в паттерне PageFactory не получилось метод c driver.getTitle описать в самой странице, пришлось вынести в тест
*/

package dynamic;

import core.TestBase;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.dynamicPages.InboxPageDynamic;
import page.dynamicPages.LoginPageDynamic;
import page.staticPages.InboxPageStatic;

import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;


public class DynamicPageObjectTest extends TestBase {

    String titleOfInboxPage = "Входящие - Почта Mail.Ru";
    int expectedNumberOfLettersInbox = 53;


    @BeforeTest
    public void setup(){

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ru/");

        LoginPageDynamic loginPage = new LoginPageDynamic(driver);

        String email = "strong.zubovich@bk.ru";
        String password = "ZXCvbn123!";

        loginPage.typeIntoInputFieldEmail(email);
        loginPage.typeIntoInputFieldPassword(password);
        loginPage.clickOnButtonForMailEntering();
   }


    @Test
    public void calculateNumberOfLettersInFolder(){

        InboxPageDynamic inboxPage = new InboxPageDynamic(driver);

        // проверяем, что авторизация прошла успешно
        Assert.assertTrue(inboxPage.isAuthentificationPassed(titleOfInboxPage));


        // проверяем, что количество писем подсчитано верно
        int actualNumberOfLettersInbox = inboxPage.calculateNumberOfLettersInFolder();
        Assert.assertEquals(actualNumberOfLettersInbox, expectedNumberOfLettersInbox);

    }

}
