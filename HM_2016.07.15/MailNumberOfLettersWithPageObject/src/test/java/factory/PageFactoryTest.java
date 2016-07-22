/*
1 - В аннотации @BeforeTest имеется проверка на то, что после авторизации загружена страница с письмами.
Поскольку название страницы уже относится к странице InboxPage, возможно, эту проверку необходимо было делать
в @Test.
2 - Возникли проблемы с паттерном Flow в плане проверок: необходимо возвращать страницу, а мне нужно было количетсво писем.
 */

package factory;

import core.TestBase;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.factoryPages.InboxPageFactory;
import page.factoryPages.LoginPageFactory;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class PageFactoryTest extends TestBase {

    @BeforeTest
    public void setup(){

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ru/");


        // передаем класс той страницы, которую хотим создать и текущий экземпляр драйвера
        LoginPageFactory loginPage  = PageFactory.initElements(driver,  LoginPageFactory.class);

        String email = "strong.zubovich@bk.ru";
        String password = "ZXCvbn123!";
        String titleOfInboxPage = "Входящие - Почта Mail.Ru";

        loginPage.typeIntoInputFieldEmail(email);
        loginPage.typeIntoInputFieldPassword(password);
        loginPage.clickOnButtonForMailEntering();

        assertEquals(driver.getTitle(), titleOfInboxPage);

    }


    @Test
    public void calculateNumberOfLettersInFolder(){

        InboxPageFactory inboxPage  = PageFactory.initElements(driver,  InboxPageFactory.class);

        //assertTrue(page.isAuthentificationPass(email));

        inboxPage.selectAllLettersOnPage();
        inboxPage.selectALlLettersInFolder();
        inboxPage.calculateNumberOfLettersInFolder();

        assertEquals(inboxPage.calculateNumberOfLettersInFolder(), "53");

    }
}
