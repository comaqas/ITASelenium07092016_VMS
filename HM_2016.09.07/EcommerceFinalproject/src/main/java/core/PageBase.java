package core;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$$;

import helpers.Locators;

import java.util.ArrayList;
import java.util.List;


public class PageBase {

    private static final By PRODUCT_NAME = Locators.get("productName");
    private static final By PRODUCT = Locators.get("productItem");


    public static boolean isInsideEachProductNameFromListPresent(String targetProductName){
        List<SelenideElement> elements = $$(PRODUCT_NAME);
        ArrayList<String> listOfProductsNames = new ArrayList<String>();

        for (int i = 0; i < elements.size(); i++){
            listOfProductsNames.add(elements.get(i).getAttribute("title"));
        }

        for (int i = 0; i < listOfProductsNames.size(); i++){
            if (listOfProductsNames.get(i).contains(targetProductName)){
                return true;
            }
        }
        return false;
    }


    public static ElementsCollection isNumberOfProductsEqualTo(int expectedNumber){
        return $$(PRODUCT_NAME).shouldHaveSize(expectedNumber);
    }


    public static ElementsCollection getListOfProducts(){
        return $$(PRODUCT);
    }

}
