/*
1 - Возникли проблемы с паттерном Flow (поскольку все методы возвращают сами страницы)
2 - в паттерне PageFactory не получилось метод c driver.getTitle описать в самой странице, пришлось вынести в тест
 */

package factory;

import core.TestBase;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.factoryPages.InboxPageFactory;
import page.factoryPages.LoginPageFactory;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class PageFactoryTest extends TestBase {

    String titleOfInboxPage = "Входящие - Почта Mail.Ru";
    int expectedNumberOfLettersInbox = 53;

    @BeforeTest
    public void setup(){

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ru/");

        // передаем класс той страницы, которую хотим создать и текущий экземпляр драйвера
        LoginPageFactory loginPage  = PageFactory.initElements(driver, LoginPageFactory.class);

        String email = "strong.zubovich@bk.ru";
        String password = "ZXCvbn123!";

        loginPage.typeIntoInputFieldEmail(email);
        loginPage.typeIntoInputFieldPassword(password);
        loginPage.clickOnButtonForMailEntering();
   }


    @Test
    public void calculateNumberOfLettersInFolder(){

        InboxPageFactory inboxPage  = PageFactory.initElements(driver, InboxPageFactory.class);

        // проверяем, что авторизация прошла успешно
        Assert.assertEquals(driver.getTitle(), titleOfInboxPage);

        // проверяем, что количество писем подсчитано верно
        int actualNumberOfLettersInbox = inboxPage.calculateNumberOfLettersInFolder();
        Assert.assertEquals(actualNumberOfLettersInbox, expectedNumberOfLettersInbox);
    }
}
