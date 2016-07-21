/**
 * Created by Marta Verenchikova on 7/20/2016.
 */

import core.TestBase;
import elements.NavigationMenuPageElementStatic;
import org.testng.annotations.Test;
import pages.CompaniesPageStatic;
import pages.LentaPageStatic;
import pages.SalariesPageStatic;
import pages.JobsPageStatic;

import static org.testng.Assert.assertTrue;


public class SiteNavigationTest extends TestBase{

    @Test
    public void navigateThrougthTheSite(){

        NavigationMenuPageElementStatic.clickOnLentaInNavigationMenu(driver);
        assertTrue(LentaPageStatic.isLogotypePresent(driver));

        NavigationMenuPageElementStatic.clickOnCompaniesInNavigationMenu(driver);
        assertTrue(CompaniesPageStatic.isIsSoftCompanyPresentInTable(driver));

        NavigationMenuPageElementStatic.clickOnSalariesInNavigationMenu(driver);
        assertTrue(SalariesPageStatic.isSalaryInItTextPresent(driver));

        NavigationMenuPageElementStatic.clickOnVacanciesInNavigationMenu(driver);
        assertTrue(JobsPageStatic.isVacanciesSearchTextPresent(driver));

    }

}
