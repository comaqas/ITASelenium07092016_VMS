package pages;

import core.PageBase;
import elements.Header;
import helpers.Locators;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import org.openqa.selenium.By;

import java.util.List;


public class CartPage extends PageBase{

    private static final By ADD_TO_CART_BUTTON = Locators.get("addProductButton");
    private static final By SELECTED_PRODUCT_NAME_IN_POPUP = Locators.get("selectedProductNameInPopUp");
    private static final By CONTINUE_SHOPPING_BUTTON = Locators.get("continueShoppingButton");
    private static final By SELECTED_PRODUCT_NAME_IN_CART = Locators.get("selectedProductNameInCart");
    private static final By DELETE_PRODUCT_ICON = Locators.get("deleteProductIcon");
    private static final By EMPTY_CART_WARNING_ALERT = Locators.get("emptyCartWarningAlert");
    private static final By TO_CHECKOUT_ON_FIRST_STEP = Locators.get("toCheckOutButtonOnFirstStep");
    private static final By TO_CHECKOUT_ON_THIRD_STEP = Locators.get("toCheckOutButtonOnThirdStep");
    private static final By SHIPPING_CHECKBOX = Locators.get("shippingCheckBox");
    private static final By TO_CHECKOUT_ON_FOURTH_STEP = Locators.get("toCheckOutButtonOnFourthStep");
    private static final By BANK_PAYMENT_METHOD_BUTTON = Locators.get("byBankPaymentMethodButton");
    private static final By CONFIRM_ORDER_BUTTON = Locators.get("confirmOrderButton");
    private static final By ORDER_TEXT = Locators.get("orderText");


    public static boolean addRandomProductToCart(){
        String htmlAttribute = "title";

        List<SelenideElement> products = getListOfProducts();
        int minProductIndex = 0;
        int maxProductIndex = products.size()-1;
        int randomProductIndex = minProductIndex + (int)(Math.random() * ((maxProductIndex - minProductIndex) + 1));
        products.get(randomProductIndex).hover().$(ADD_TO_CART_BUTTON).click();

        String selectedProductNameInPopUp = $(SELECTED_PRODUCT_NAME_IN_POPUP).getAttribute(htmlAttribute);

        $(CONTINUE_SHOPPING_BUTTON).click();

        Header.navigateToCartPage();

        String selectedProductNameInCart = $(SELECTED_PRODUCT_NAME_IN_CART).getAttribute(htmlAttribute);

        return selectedProductNameInCart.equals(selectedProductNameInPopUp);
    }


    public static boolean isEmptyCartMessageAfterAllItemsDeletingDisplayedWith(String alert){
        $(DELETE_PRODUCT_ICON).click();
        return $(EMPTY_CART_WARNING_ALERT).should(Condition.visible).getText().equals(alert);
    }


    public static String getOrderNumberAfterCompletingOrderSteps(){
        $(TO_CHECKOUT_ON_FIRST_STEP).click();
        $(TO_CHECKOUT_ON_THIRD_STEP).click();
        $(SHIPPING_CHECKBOX).click();
        $(TO_CHECKOUT_ON_FOURTH_STEP).click();
        $(BANK_PAYMENT_METHOD_BUTTON).click();
        $(CONFIRM_ORDER_BUTTON).click();

        String fullOrderText = $(ORDER_TEXT).getText();
        String stringForOrderExtraction = "reference";

        int beginIndex = fullOrderText.indexOf(stringForOrderExtraction) + stringForOrderExtraction.length() + 1;
        int orderLength = 9;
        int endIndex = beginIndex + orderLength;

        String orderNumber = fullOrderText.substring(beginIndex, endIndex);
        return orderNumber;
    }

}
