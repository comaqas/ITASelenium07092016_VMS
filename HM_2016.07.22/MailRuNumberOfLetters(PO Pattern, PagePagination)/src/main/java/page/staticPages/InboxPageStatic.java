package page.staticPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class InboxPageStatic {

    private static final By LETTERS_ON_PAGE = By.cssSelector("div.b-datalist__item__panel");
    private static final By NEXT_PAGE_BUTTON = By.cssSelector("div[data-name='next']");
    private static final By NEXT_PAGE_ARROW = By.cssSelector("i.ico_toolbar_arrow_right");

   public static boolean isAuthentificationPassed(WebDriver driver, String titleOfInboxPage){
        if(!driver.getTitle().equals(titleOfInboxPage)){
            return false;
        }
        return true;
    }


    public static int calculateNumberOfLettersInFolder (WebDriver driver){

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
        return actualNumberOflettersInbox;
    }

}
