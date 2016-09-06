package pages.myAccountPages;

import helpers.Locators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$$;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class OrderHistoryPage {

    private static final By ORDER_LINK = Locators.get("orderLink");
    private static final By INVOICE_DOWNLOAD_LINK = Locators.get("invoiceDownloadLink");


    public static boolean isInsideOrderListPresent(String targetOrderNumber){
        List<SelenideElement> elements = $$(ORDER_LINK);
        ArrayList<String> ordersNumbersList = new ArrayList<String>();

        for (int i = 0; i < elements.size(); i++){
            ordersNumbersList.add(elements.get(i).getText());
        }

        for (int i = 0; i < ordersNumbersList.size(); i++){
            if (ordersNumbersList.get(i).contains(targetOrderNumber)){
                return true;
            }
        }
        return false;
    }


    public static boolean isDownloadFileNameIdenticalTo(String expectedName) throws FileNotFoundException {
        File invoice = $$(INVOICE_DOWNLOAD_LINK).get(0).download();
        return invoice.getName().contains(expectedName);
    }
}
