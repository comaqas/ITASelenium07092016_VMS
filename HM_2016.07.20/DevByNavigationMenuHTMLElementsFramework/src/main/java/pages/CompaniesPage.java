package pages;

import blocks.NavigationMenuBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import ru.yandex.qatools.htmlelements.element.Link;

public class CompaniesPage {

    // объявляем блок, который будет использоваться в PageObject
    private NavigationMenuBlock navigationMenuBlock;

    // на старнице с компаниями должна присутсвовать компания ISsoft
    private final By ISSOFT_COMPANY = By.cssSelector("#tablesort [data='ISsoft']");

    // конструктор страницы
    public CompaniesPage(WebDriver driver){
        HtmlElementLoader.populatePageObject(this, driver);
    }

    // проверка наличия компания ISsoft
    public boolean isIsSoftCompanyPresentInTable(WebDriver driver){
        WebElement isSoftCompany = driver.findElement(ISSOFT_COMPANY);

        if (!isSoftCompany.isDisplayed()){
            return false;
        }
        return true;
    }


    // клик по ссылке ЗАРПЛАТЫ в навигационном меню
    public void clickOnSalariesLink(){
        navigationMenuBlock.clickOnSalariesLink();
    }

}
