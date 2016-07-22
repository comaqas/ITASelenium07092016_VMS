package pages;

import blocks.NavigationMenuBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import ru.yandex.qatools.htmlelements.element.Link;

public class JobsPage {

    // объявляем блок, который будет использоваться в PageObject
    private NavigationMenuBlock navigationMenuBlock;

    // на старнице с вакансиями должно присутствовать выражение "Поиск вакансий:"
    private final By VACANCIES_SEARCH_TEXT =  By.cssSelector(".column-left>h3");


    // конструктор страницы
    public JobsPage(WebDriver driver){
        HtmlElementLoader.populatePageObject(this, driver);
    }

    // проверка наличия выражения "Поиск вакансий:"
    public boolean isVacanciesSearchTextPresent(WebDriver driver){
        WebElement vacanciesSearchText = driver.findElement(VACANCIES_SEARCH_TEXT);

        if(!vacanciesSearchText.getText().equals("Поиск вакансий:")){
            return false;
        }
        return true;
    }
}
