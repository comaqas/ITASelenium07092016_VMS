import core.TestBase;
import elements.Header;
import utils.ScreenShooter;
import pages.SearchResultPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;


@Listeners(ScreenShooter.class)
public class SearchTest extends TestBase{

    String firstTargetProductName = "Blouse";
    String secondTargetProductName = "Dresses";
    int expectedNumberOfProducts = 7;


    @Test
    public void search_ExecuteValidSearch_TargetProductIsPresentInEachResult(){
        Header.searchFor(firstTargetProductName);
        Assert.assertTrue(SearchResultPage.isInsideEachProductNameFromListPresent(firstTargetProductName),
                "Not each result contains a target Product Name");
    }


    @Test
    public void search_ExecuteValidSearch_NumberOfProductsInResultsIsCorrect(){
        Header.searchFor(secondTargetProductName);
        SearchResultPage.isNumberOfProductsEqualTo(expectedNumberOfProducts);
    }
}
