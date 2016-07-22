package pages;

import blocks.NavigationMenuBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import ru.yandex.qatools.htmlelements.element.Link;


public class SalariesPage {

    // объявляем блок, который будет использоваться в PageObject
    private NavigationMenuBlock navigationMenuBlock;

    // на старнице с зарплатами должно присутствовать выражение "Зарплата в ИТ"
    private final By SALARY_IN_IT_TEXT = By.cssSelector(".input.info-count>h3");

    // конструктор страницы
    public SalariesPage(WebDriver driver){
        HtmlElementLoader.populatePageObject(this, driver);
    }


    // проверка наличия выражение "Зарплата в ИТ"
    public boolean isSalaryInItTextPresent(WebDriver driver){
        WebElement salaryInItText = driver.findElement(SALARY_IN_IT_TEXT);

        if(!salaryInItText.getText().equals("Зарплата в ИТ")){
            return false;
        }
        return true;
    }


    // клик по ссылке ВАКАНСИИ в навигационном меню
    public void clickOnVacanciesLink(){
        navigationMenuBlock.clickOnVacanciesLink();
    }


}
