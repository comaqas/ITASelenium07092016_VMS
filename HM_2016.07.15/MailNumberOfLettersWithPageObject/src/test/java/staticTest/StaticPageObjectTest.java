/*
1 - В аннотации @BeforeTest имеется проверка на то, что после авторизации загружена страница с письмами.
Поскольку название страницы уже относится к странице InboxPage, возможно, эту проверку необходимо было делать
в @Test.
2 - Возникли проблемы с паттерном Flow в плане проверок: необходимо возвращать страницу, а мне нужно было количетсво писем.
 */

package staticTest;

import core.TestBase;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.staticPages.InboxPageStatic;
import page.staticPages.LoginPageStatic;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;



public class StaticPageObjectTest extends TestBase {

    @BeforeTest
    public void setup(){

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ru/");

        String email = "strong.zubovich@bk.ru";
        String password = "ZXCvbn123!";
        String titleOfInboxPage = "Входящие - Почта Mail.Ru";

        LoginPageStatic.typeIntoInputFieldEmail(driver, email);
        LoginPageStatic.typeIntoInputFieldPassword(driver,password);
        LoginPageStatic.clickOnButtonForMailEntering(driver);
        LoginPageStatic.isAuthentificationPass(driver);

        assertEquals(LoginPageStatic.isAuthentificationPass(driver), titleOfInboxPage);

    }

    @Test
    public void calculateNumberOfLettersInFolder(){

        InboxPageStatic.selectAllLettersOnPage(driver);
        InboxPageStatic.selectALlLettersInFolder(driver);
        InboxPageStatic.calculateNumberOfLettersInFolder(driver);

        assertEquals(InboxPageStatic.calculateNumberOfLettersInFolder(driver), "53");

    }

}
