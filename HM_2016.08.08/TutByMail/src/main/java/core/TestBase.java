package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    String BASE_URL = "http://www.tut.by/";

    @BeforeTest
    public void setup(){
        driver = new FirefoxDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

//    @AfterTest
//    public void teardown(){
//        driver.quit();
//    }
}
