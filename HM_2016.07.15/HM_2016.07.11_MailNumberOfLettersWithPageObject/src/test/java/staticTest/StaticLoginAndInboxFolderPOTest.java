/**
 * Created by Marta Verenchikova on 20-Jul-16.
 */

package staticTest;

import core.TestBase;
import org.testng.annotations.Test;
import page.LoginAndInboxFolderPageStatic;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class StaticLoginAndInboxFolderPOTest extends TestBase {

    @Test
    public void authentificationAndNumberOfLetterCalculationTest(){

        String email = "strong.zubovich@bk.ru";
        String password = "ZXCvbn123!";

        LoginAndInboxFolderPageStatic.typeIntoInputFieldEmail(driver, email);
        LoginAndInboxFolderPageStatic.typeIntoInputFieldPassword(driver,password);
        LoginAndInboxFolderPageStatic.clickOnButtonForMailEntering(driver);
        LoginAndInboxFolderPageStatic.isAuthentificationPass(driver, email);

        assertTrue(LoginAndInboxFolderPageStatic.isAuthentificationPass(driver, email));

        LoginAndInboxFolderPageStatic.selectAllLettersOnPage(driver);
        LoginAndInboxFolderPageStatic.selectALlLettersInFolder(driver);
        LoginAndInboxFolderPageStatic.calculateNumberOfLettersInFolder(driver);

        assertEquals(LoginAndInboxFolderPageStatic.calculateNumberOfLettersInFolder(driver), "52");

    }

}
