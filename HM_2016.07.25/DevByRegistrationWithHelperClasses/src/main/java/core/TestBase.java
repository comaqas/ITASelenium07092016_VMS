package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    public static final String BASE_URL = "https://dev.by/";

    @BeforeTest
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(BASE_URL);
        driver.findElement(MainPage.REGISTRATION_LINK).click();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
