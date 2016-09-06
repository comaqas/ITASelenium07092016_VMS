package core;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {


    @BeforeTest
    public void navigateToBaseUrl(){
        System.setProperty("webdriver.chrome.driver", "D:\\Installs\\chromedriver.exe");
        System.setProperty("selenide.browser", "chrome");
        Configuration.startMaximized = true;
        open("http://automationpractice.com/index.php");
    }

}
