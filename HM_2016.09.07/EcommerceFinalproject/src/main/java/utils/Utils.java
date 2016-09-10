package utils;

import com.codeborne.selenide.Screenshots;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;


public class Utils {

    @Attachment(value = "Failure in method {0}", type = "image/png")
    public static byte[] takeScreenShot(String methodName) throws IOException {
        File lastSelenideScreenshot = Screenshots.takeScreenShotAsFile();
        return com.google.common.io.Files.toByteArray(lastSelenideScreenshot);
    }
}