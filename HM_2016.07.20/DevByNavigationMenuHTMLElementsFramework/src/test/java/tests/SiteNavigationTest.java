package tests;

import blocks.NavigationMenuBlock;
import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CompaniesPage;
import pages.JobsPage;
import pages.LentaPage;
import pages.SalariesPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class SiteNavigationTest extends TestBase{

    private CompaniesPage companiesPage = new CompaniesPage(driver);
    private LentaPage lentaPage = new LentaPage(driver);
    private SalariesPage salariesPage= new SalariesPage(driver);
    private JobsPage jobsPage = new JobsPage(driver);


    @Test
    public void navigateThroughTheSite(){

        lentaPage.clickOnLentaLink();
        assertTrue(lentaPage.isLogotypePresent(driver));
        lentaPage.clickOnCompaniesLink();

        assertTrue(companiesPage.isIsSoftCompanyPresentInTable(driver));
        companiesPage.clickOnSalariesLink();

        assertTrue(salariesPage.isSalaryInItTextPresent(driver));
        salariesPage.clickOnVacanciesLink();

        assertTrue(jobsPage.isVacanciesSearchTextPresent(driver));

    }
}
