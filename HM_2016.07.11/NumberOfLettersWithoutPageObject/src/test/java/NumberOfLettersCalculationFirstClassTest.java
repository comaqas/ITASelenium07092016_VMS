/**
 * Created by Marta Verenchikova on 7/19/2016.
 */

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


// Проблема теста в том, что он считает только письма на первой странице

public class NumberOfLettersCalculationFirstClassTest {

    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void numberOfLettersCalculationFirstTest() {

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
         Для подсчета писем в почтовом ящике сперва подсчитываем количесвто чек-боксов, затем
         отнимаем из полученного числа 1, поскольку 1 чек-бокс используется под контрол "Выделить все"
        */

        List<WebElement> numberOfCheckBox = driver.findElements(By.className("b-checkbox__box"));

        int numberOfLetters = numberOfCheckBox.size()-1;
        System.out.println("There are " + numberOfLetters + " letters in a Box");

        }


    @AfterTest
    public void teardown(){
        driver.quit();
    }

}

