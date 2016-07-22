package pages;

import blocks.NavigationMenuBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import ru.yandex.qatools.htmlelements.element.Link;


public class LentaPage {

    // объявляем блок, который будет использоваться в PageObject
    private NavigationMenuBlock navigationMenuBlock;


    // на странице Lenta должен присутсвовать логотип
    private final By LOGOTYPE = By.className("header-logo");


    // конструктор страницы
    public LentaPage(WebDriver driver){
        HtmlElementLoader.populatePageObject(this, driver);
    }


    // клик по ссылке ЛЕНТА в навигационном меню
    public void clickOnLentaLink(){
        navigationMenuBlock.clickOnLentaLink();
    }


    // клик по ссылке КОМПАНИИ в навигационном меню
    public void clickOnCompaniesLink(){
        navigationMenuBlock.clickOnCompaniesLink();
    }

    // проверка наличия логотипа
    public boolean isLogotypePresent(WebDriver driver){
        WebElement logo = driver.findElement(LOGOTYPE);

        if(!logo.isDisplayed()){
            return false;
        }
        return true;
    }
}
