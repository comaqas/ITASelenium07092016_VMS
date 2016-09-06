import core.TestBase;
import elements.Header;
import pages.CartPage;
import pages.LoginPage;
import pages.myAccountPages.MyAccountPage;
import pages.myAccountPages.OrderHistoryPage;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ShoppingTest extends TestBase {

    String email = "UserEmail@mail.ru";
    String password = "Password123";
    String product = "Dresses";
    String emptyCartTextMessage = "Your shopping cart is empty.";


    @Test
    public void shoppingCart_AddItemToCartAndDeleteItemFromCart_CartIsEmpty(){
        Header.searchFor(product);
        Assert.assertTrue(CartPage.addRandomProductToCart(), "Product is not added to Shopping Cart");
        Assert.assertTrue(CartPage.isEmptyCartMessageAfterAllItemsDeletingDisplayedWith(emptyCartTextMessage),
                "Shopping Cart is not empty");
    }


    @Test
    public void shoppingCart_AddItemToCartAndCompleteOrderSteps_OrderIsPresentInHistory(){
        String targetOrderNumber;

        Header.navigateToLoginPage();
        LoginPage.loginByEntering(email, password);
        Header.searchFor(product);
        CartPage.addRandomProductToCart();

        targetOrderNumber = CartPage.getOrderNumberAfterCompletingOrderSteps();

        Header.navigateToMyAccountPage();
        MyAccountPage.navigateToOrderHistoryPage();
        Assert.assertTrue(OrderHistoryPage.isInsideOrderListPresent(targetOrderNumber),
                "List of all Orders' Numbers doesn't contain a just added product Order Number");
   }
}
