/*
1 - В аннотации @BeforeTest имеется проверка на то, что после авторизации загружена страница с письмами.
Поскольку название страницы уже относится к странице InboxPage, возможно, эту проверку необходимо было делать
в @Test.
2 - Возникли проблемы с паттерном Flow в плане проверок: необходимо возвращать страницу, а мне нужно было количетсво писем.
 */


package dynamic;

import core.TestBase;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.dynamicPages.InboxPageDynamic;
import page.dynamicPages.LoginPageDynamic;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


public class DynamicPageObjectTest extends TestBase {

    @BeforeTest
    public void setup(){

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ru/");

        LoginPageDynamic loginPage = new LoginPageDynamic(driver);

        String email = "strong.zubovich@bk.ru";
        String password = "ZXCvbn123!";
        String titleOfInboxPage = "Входящие - Почта Mail.Ru";

        loginPage.typeIntoInputFieldEmail(email);
        loginPage.typeIntoInputFieldPassword(password);
        loginPage.clickOnButtonForMailEntering();

        assertEquals(loginPage.isAuthentificationPass(), titleOfInboxPage);

    }


    @Test
    public void calculateNumberOfLettersTestMethod(){

        InboxPageDynamic inboxPage = new InboxPageDynamic(driver);

        inboxPage.selectAllLettersOnPage();
        inboxPage.selectALlLettersInFolder();
        inboxPage.calculateNumberOfLettersInFolder();

        assertEquals(inboxPage.calculateNumberOfLettersInFolder(), "53");

    }

}
