package blocks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;


// описываем блок, состоящий из отдельных веб-элементов
@Name("NavigationMenuBlock")
@Block(@FindBy(css = ".dev-container.header-nav"))
public class NavigationMenuBlock extends HtmlElement{


    // описываем элемент и методы работы с ним
    @Name("LentaLink")
    @FindBy(css = ".menu>li>a[href='https://dev.by/lenta']")
    private Link lenta;

    public void clickOnLentaLink(){
        lenta.click();
    }

    // описываем элемент и методы работы с ним
    @Name("CompaniesLink")
    @FindBy(css = ".menu>li>a[href='https://companies.dev.by/']")
    private Link companies;

    public void clickOnCompaniesLink(){
        companies.click();
    }


    // описываем элемент и методы работы с ним
    @Name("SalariesLink")
    @FindBy(css = ".menu>li>a[href='https://salaries.dev.by/']")
    private Link salaries;

    public void clickOnSalariesLink(){
        salaries.click();
    }


    // описываем элемент и методы работы с ним
    @Name("VacanciesLink")
    @FindBy(css = ".menu>li>a[href='https://jobs.dev.by/']")
    private Link vacancies;

    public void clickOnVacanciesLink(){
        vacancies.click();
    }


    // методы были добавлены самим фрэймворком, иначе не было возможности работать
    public Rectangle getRect() {
        return null;
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }
}
