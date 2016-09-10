package utils;

import org.testng.ITestResult;
import org.testng.reporters.ExitCodeListener;

import java.io.IOException;

public class ScreenShooter extends ExitCodeListener {

    @Override
    public void onTestFailure(ITestResult result){
        try {
            Utils.takeScreenShot(result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
