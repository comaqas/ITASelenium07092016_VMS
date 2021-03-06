/**
 * Created by Marta Verenchikova on 7/19/2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


// Проблема теста в том, что он считает только письма на первой странице

public class NumberOfLettersCalculationSecondClassTest {

    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void numberOfLettersCalculationSecondTest() {

        driver.get("https://mail.ru/");

        // вводим имя почтового ящика
        WebElement login = driver.findElement(By.id("mailbox__login"));
        login.sendKeys("strong.zubovich");

        // создаем объект класса Select для работы с drop-down list
        Select mailDomainsDropDownList = new Select(driver.findElement(By.id("mailbox__login__domain")));

        // проверяем размер drop-down list
        assertEquals(4, mailDomainsDropDownList.getOptions().size());

        // выбираем необходимый вариант почтового ящика
        mailDomainsDropDownList.selectByValue("bk.ru");

        // работа с полем пароля
        WebElement password = driver.findElement(By.id("mailbox__password"));
        password.sendKeys("ZXCvbn123!");

        // нажатие на кнопку "Войти"
        WebElement enterButton = driver.findElement(By.id("mailbox__auth__button"));
        enterButton.click();

        /*
         Для подсчета писем в почтовом ящике используем локатор .b-datalist__item__panel, который
         означает классы, применяемые к каждому из писем
        */

        List<WebElement> numberOfCheckBox = driver.findElements(By.className("b-datalist__item__panel"));

        int numberOfLetters = numberOfCheckBox.size();

        System.out.println("There are " +  numberOfLetters + " letters in a Box");
    }


    @AfterTest
    public void teardown(){
        driver.quit();
    }

}

