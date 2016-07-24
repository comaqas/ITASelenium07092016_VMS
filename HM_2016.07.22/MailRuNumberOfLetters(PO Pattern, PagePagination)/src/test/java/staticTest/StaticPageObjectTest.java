/*
1 - Возникли проблемы с паттерном Flow (поскольку все методы возвращают сами страницы)
2 - в паттерне PageFactory не получилось метод c driver.getTitle описать в самой странице, пришлось вынести в тест
 */

package staticTest;

import core.TestBase;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.staticPages.InboxPageStatic;
import page.staticPages.LoginPageStatic;

import java.util.concurrent.TimeUnit;


public class StaticPageObjectTest extends TestBase {

    String titleOfInboxPage = "Входящие - Почта Mail.Ru";
    int expectedNumberOfLettersInbox = 53;


    @BeforeTest
    public void setup(){

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ru/");

        String email = "strong.zubovich@bk.ru";
        String password = "ZXCvbn123!";

        LoginPageStatic.typeIntoInputFieldEmail(driver, email);
        LoginPageStatic.typeIntoInputFieldPassword(driver,password);
        LoginPageStatic.clickOnButtonForMailEntering(driver);
    }


    @Test
    public void calculateNumberOfLettersInFolder(){

        // проверяем, что авторизация прошла успешно
        Assert.assertTrue(InboxPageStatic.isAuthentificationPassed(driver, titleOfInboxPage));

        // проверяем, что количество писем подсчитано верно
        int actualNumberOfLettersInbox = InboxPageStatic.calculateNumberOfLettersInFolder(driver);
        Assert.assertEquals(actualNumberOfLettersInbox, expectedNumberOfLettersInbox);
    }
}
