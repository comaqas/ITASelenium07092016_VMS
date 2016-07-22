/*
1 - В аннотации @BeforeTest имеется проверка на то, что после авторизации загружена страница с письмами.
Поскольку название страницы уже относится к странице InboxPage, возможно, эту проверку необходимо было делать
в @Test.
2 - Возникли проблемы с паттерном Flow в плане проверок: необходимо возвращать страницу, а мне нужно было количетсво писем.
 */

package flow;

import core.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.flowPages.InboxPageFlow;
import page.flowPages.LoginPageFlow;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


public class FlowPageObjectTest extends TestBase {

    @BeforeTest
    public void setup(){

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ru/");

        LoginPageFlow loginPage = new LoginPageFlow(driver);

        String titleOfInboxPage = "Входящие - Почта Mail.Ru";

        loginPage
                    .typeIntoInputFieldEmail("strong.zubovich@bk.ru")
                    .typeIntoInputFieldPassword("ZXCvbn123!")
                    .clickOnButtonForMailEntering();

        assertEquals(driver.getTitle(), titleOfInboxPage);
    }


    @Test
    public void calculateNumberOfLettersInFolder(){

        InboxPageFlow inboxPage= new InboxPageFlow(driver);

        inboxPage
                .selectAllLettersOnPage()
                .selectALlLettersInFolder()
                .calculateNumberOfLettersInFolder();

    }
}
