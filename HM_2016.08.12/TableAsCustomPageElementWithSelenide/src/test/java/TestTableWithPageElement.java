import com.codeborne.selenide.SelenideElement;
import core.TestBase;
import elements.TablePageElement;
import org.testng.annotations.Test;


public class TestTableWithPageElement extends TestBase {

    SelenideElement webTable;

    TablePageElement table = new TablePageElement(webTable);

    @Test
    public void testExample(){
        System.out.println(table.getColumnsNumber());
    }
}
