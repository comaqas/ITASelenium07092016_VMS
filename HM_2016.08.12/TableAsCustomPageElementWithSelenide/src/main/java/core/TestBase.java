package core;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.open;

import org.testng.annotations.BeforeTest;


public class TestBase {

    @BeforeTest
    public void setUp(){
        open("http://6.pogoda.by/");
        Configuration.startMaximized = true;
    }
}
