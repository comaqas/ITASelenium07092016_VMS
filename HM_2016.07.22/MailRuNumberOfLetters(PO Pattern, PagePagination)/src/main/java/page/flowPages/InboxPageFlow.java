package page.flowPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.fail;


public class InboxPageFlow {

    private final By LETTERS_ON_PAGE = By.cssSelector("div.b-datalist__item__panel");
    private final By NEXT_PAGE_BUTTON = By.cssSelector("div[data-name='next']");
    private final By NEXT_PAGE_ARROW = By.cssSelector("i.ico_toolbar_arrow_right");


    private WebDriver driver;

    public InboxPageFlow(WebDriver driver){
        this.driver = driver;
    }


    public InboxPageFlow isAuthentificationPassed(String titleOfInboxPage){
        if  (!driver.getTitle().equals(titleOfInboxPage)){
            fail("\nAuthentification is not passed");
        }
        return this;
    }

    public InboxPageFlow calculateNumberOfLettersInFolder (int expectedNumberOflettersInbox){

        int actualNumberOflettersInbox = 0;
        String nameOfAttribute = "class";
        String flagAboutDisabledState = "b-toolbar__btn_disabled";

        while (true){
            List<WebElement> lettersOnThePage = driver.findElements(LETTERS_ON_PAGE);
            actualNumberOflettersInbox += lettersOnThePage.size();

            WebElement nextPageButton = driver.findElement(NEXT_PAGE_BUTTON);
            WebElement nextPageArrow = driver.findElement(NEXT_PAGE_ARROW);

            if (!nextPageButton.getAttribute(nameOfAttribute).contains(flagAboutDisabledState)) {
                nextPageArrow.click();
            } else {
                break;
            }
        }

        if (actualNumberOflettersInbox != expectedNumberOflettersInbox){
            fail("\nIncorrect calculation of letters or, maybe, number of letters in a box was changed by other users");
        }

        return this;
    }

}
