package core;

import elements.Header;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import org.openqa.selenium.By;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TestBase  {

    @BeforeTest
    public void navigateToBaseUrl(){
        Configuration.startMaximized = true;
        open("http://automationpractice.com/index.php");
    }

    @AfterMethod
    public void logout(){
        if ($(By.cssSelector(".logout")).exists() == true){
            Header.logout();
        }
    }
}
