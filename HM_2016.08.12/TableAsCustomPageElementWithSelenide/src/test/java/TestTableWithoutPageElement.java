import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$$;
import org.openqa.selenium.By;

import core.TestBase;

import org.testng.annotations.Test;

import java.util.List;

public class TestTableWithoutPageElement extends TestBase {

    @Test
    public void verifyRowsNumber(){
        $$(By.cssSelector("#forecast tr")).shouldHaveSize(31);
    }

    @Test
    public void verifyColumnsNumber(){
        List<SelenideElement> rows = $$(By.cssSelector("#forecast tr"));
        rows.get(0).$$(By.tagName("td")).shouldHaveSize(6);
    }


    @Test
    public void verifyTableHeaderText(){

        String [] cellsTextFromHeader = new String[6];
        cellsTextFromHeader[0] = "Дата";
        cellsTextFromHeader[1] = "Температура воздуха, °C";
        cellsTextFromHeader[2] = "Облачность, погодные явления и осадки";
        cellsTextFromHeader[3] = "Скорость и направление ветра, м/с";
        cellsTextFromHeader[4] = "Атмосферное давление, гПа";
        cellsTextFromHeader[5] = "Влажность воздуха, %";

        $$(By.cssSelector("#forecast tr")).get(0)
                .$$(By.tagName("td")).shouldHave(CollectionCondition.texts(cellsTextFromHeader));
    }

}
