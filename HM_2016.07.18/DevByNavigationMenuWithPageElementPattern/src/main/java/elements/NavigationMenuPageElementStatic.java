/**
 * Created by Marta Verenchikova on 7/20/2016.
 */

package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationMenuPageElementStatic {

    private static final By LENTA = By.cssSelector(".menu>li>a[href='https://dev.by/lenta']");
    private static final By COMPANIES = By.cssSelector(".menu>li>a[href='https://companies.dev.by/']");
    private static final By SALARIES = By.cssSelector(".menu>li>a[href='https://salaries.dev.by/']");
    private static final By VACANCIES = By.cssSelector(".menu>li>a[href='https://jobs.dev.by/']");


    public static void clickOnLentaInNavigationMenu(WebDriver driver){
        WebElement lenta = driver.findElement(LENTA);
        lenta.click();
    }

    public static void clickOnCompaniesInNavigationMenu(WebDriver driver){
        WebElement companies = driver.findElement(COMPANIES);
        companies.click();
    }

    public static void clickOnSalariesInNavigationMenu(WebDriver driver){
        WebElement salaries = driver.findElement(SALARIES);
        salaries.click();
    }

    public static void clickOnVacanciesInNavigationMenu(WebDriver driver){
        WebElement vacancies = driver.findElement(VACANCIES);
        vacancies.click();
    }

}
