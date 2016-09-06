import core.TestBase;
import elements.Header;
import pages.HomePage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends TestBase{

    String expectedHeading = "Automation Practice Website";

    @Test
    public void logotype_ContactUsAndHomePagesNavigation_HomePageIsOpened(){
        Header.navigateToContactUsPage();
        Header.navigateToHomePage();
        HomePage.isHeadingIdenticalTo(expectedHeading);
    }


    @Test
    public void logotype_LoginAndHomePagesNavigation_HomePageIsOpened(){
        Header.navigateToLoginPage();
        Header.navigateToHomePage();
        HomePage.isHeadingIdenticalTo(expectedHeading);
    }


    @Test
    public void logotype_CartAndHomePagesNavigation_HomePageIsOpened(){
        Header.navigateToCartPage();
        Header.navigateToHomePage();
        HomePage.isHeadingIdenticalTo(expectedHeading);
    }


    @Test
    public void logotype_TShirtsCatalogAndHomePagesNavigation_HomePageIsOpened(){
        Header.navigateToTShirtsCatalogPage();
        Header.navigateToHomePage();
        HomePage.isHeadingIdenticalTo(expectedHeading);
    }
}
