/**
 * Created by Marta Verenchikova on 20-Jul-16.
 */

package flow;

import core.TestBase;
import org.testng.annotations.Test;
import page.LoginAndInboxFolderPageFlow;


public class FlowLoginAndInboxFolderPOTest extends TestBase {

    @Test
    public void authentificationAndNumberOfLetterCalculationFlowTest(){
        LoginAndInboxFolderPageFlow page = new LoginAndInboxFolderPageFlow(driver);

        page
                .typeIntoInputFieldEmail("strong.zubovich@bk.ru")
                .typeIntoInputFieldPassword("ZXCvbn123!")
                .clickOnButtonForMailEntering()
                .isAuthentificationPass("strong.zubovich@bk.ru")
                .selectAllLettersOnPage()
                .selectALlLettersInFolder()
                .calculateNumberOfLettersInFolder();



    }
}
