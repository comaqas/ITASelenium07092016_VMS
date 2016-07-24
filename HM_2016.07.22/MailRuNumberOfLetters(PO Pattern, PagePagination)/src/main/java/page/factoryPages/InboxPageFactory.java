package page.factoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;


public class InboxPageFactory {

    // можно использовать также @FindAll({@FindBy(css = "div.b-datalist__item__panel")})
    @FindBys({@FindBy(css = "div.b-datalist__item__panel")})
    private List<WebElement> lettersOnThePage;

    @FindBy(css = "div[data-name='next']")
    private WebElement nextPageButton;

    @FindBy(css = "i.ico_toolbar_arrow_right")
    private WebElement nextPageArrow;


    public int calculateNumberOfLettersInFolder (){

        int actualNumberOflettersInbox = 0;
        String nameOfAttribute = "class";
        String flagAboutDisabledState = "b-toolbar__btn_disabled";

        while (true){
            actualNumberOflettersInbox += lettersOnThePage.size();

            if (!nextPageButton.getAttribute(nameOfAttribute).contains(flagAboutDisabledState)) {
                nextPageArrow.click();
            } else {
                break;
            }
        }
        return actualNumberOflettersInbox;
    }

}
