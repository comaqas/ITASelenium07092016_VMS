package core;

import com.codeborne.selenide.Configuration;
import helpers.Randomizer;
import org.testng.annotations.BeforeTest;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    public String emailSender = "testermarusyaivanova@mail.ru";
    public String emailRecipient = "strong.zubovich@bk.ru";
    public String password = "ZXCvbn123!";
    public String subject = Randomizer.getRandomSubject();

    @BeforeTest
    public void navigateToBaseUrl(){
        Configuration.startMaximized = true;
        open("https://mail.ru/");
    }
}
