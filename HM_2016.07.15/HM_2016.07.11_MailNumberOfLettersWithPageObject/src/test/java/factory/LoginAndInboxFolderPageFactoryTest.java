/**
 * Created by Marta Verenchikova on 20-Jul-16.
 */

package factory;

import core.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page.LoginAndInboxFolderPageFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginAndInboxFolderPageFactoryTest extends TestBase {

    @Test
    public void authentificationAndNumberOfLetterCalculationTest(){
        // передаем класс той страницы, которую хотим создать и текущий экземпляр драйвера
        LoginAndInboxFolderPageFactory page  = PageFactory.initElements(driver,  LoginAndInboxFolderPageFactory.class);

        String email = "strong.zubovich@bk.ru";
        String password = "ZXCvbn123!";

        page.typeIntoInputFieldEmail(email);
        page.typeIntoInputFieldPassword(password);
        page.clickOnButtonForMailEntering();
        page.isAuthentificationPass(email);

        assertTrue(page.isAuthentificationPass(email));

        page.selectAllLettersOnPage();
        page.selectALlLettersInFolder();
        page.calculateNumberOfLettersInFolder();

        assertEquals(page.calculateNumberOfLettersInFolder(), "52");

    }
}
