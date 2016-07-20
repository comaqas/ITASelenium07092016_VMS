/**
 * Проблемы, с которыми столкнулась при выполнении задания:
 * 1 - страниц у нас 2 (1 - это LoginPage, 2 - это InboxFolderPage), но пришлось использовать 1 page object,
 * потому что нельзя начать второй тест без повторного залогинивания. Чтобы использовать одинаковую аннотацию
 * @BeforeTest в классе TestBase, пришлось все лепит в один Page Object
 *
 * 2 - последняя проверка в тесте (их всего две) будет проходить только в том случае, если заранее известно
 * количесвто писем (с этим значением я сравниваю полученных в ходе теста результат)
 */

package dynamic;

import core.TestBase;
import org.testng.annotations.Test;
import page.LoginAndInboxFolderPageDynamic;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class DynamicLoginAndInboxFolderPOTest extends TestBase {

    @Test
    public void authentificationAndNumberOfLetterCalculationTest(){

        LoginAndInboxFolderPageDynamic page = new LoginAndInboxFolderPageDynamic(driver);

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
