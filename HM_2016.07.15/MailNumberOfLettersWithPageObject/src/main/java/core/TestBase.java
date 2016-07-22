package core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class TestBase {

    protected WebDriver driver;

    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
