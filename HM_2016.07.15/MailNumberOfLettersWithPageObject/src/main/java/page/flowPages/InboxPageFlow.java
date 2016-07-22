package page.flowPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.fail;


public class InboxPageFlow {

    private final By CHECK_BOX_SELECT_ALL_LETTERS_ON_PAGE = By.cssSelector(".b-dropdown__ctrl .b-checkbox__box");
    private final By TEXT_LINK_SELECT_ALL_LETTERS_IN_FOLDER = By.cssSelector(".pseudo-link[data-name='selectAllLetters']");
    private final By NUMBER_OF_LETTERS_IN_FOLDER = By.className("b-announcement__text");

    private WebDriver driver;

    public InboxPageFlow(WebDriver driver){
        this.driver = driver;
    }

    public InboxPageFlow selectAllLettersOnPage(){
        WebElement selectAllLettersOnPageCheckBox = driver.findElement(CHECK_BOX_SELECT_ALL_LETTERS_ON_PAGE);
        selectAllLettersOnPageCheckBox.click();
        return this;
    }

    public InboxPageFlow selectALlLettersInFolder(){
        WebElement selectAllLettersInFolderTextLink = driver.findElement(TEXT_LINK_SELECT_ALL_LETTERS_IN_FOLDER);
        selectAllLettersInFolderTextLink.click();
        return this;
    }


    // чтобы применить Page Factory пришлось изменить логику метода, поскольку тип возвражщаемого значения
    // не строка (как во всех остальных случаях), а страница

    public InboxPageFlow calculateNumberOfLettersInFolder() {
        WebElement fullResultMessageWithNumberOfLetters = driver.findElement(NUMBER_OF_LETTERS_IN_FOLDER);

        String shortResultMessageWithNumberOfLetters = fullResultMessageWithNumberOfLetters.getText();

        String[] numberOfLettersInFolder = shortResultMessageWithNumberOfLetters.split(" ");

        String numberOfLetters = numberOfLettersInFolder[1];

        if (!numberOfLetters.equals("53")){
            fail("\nIncorrect calculation of letters or, maybe, number of letters in a box weas changed by other users");
        }

        return this;
    }

}
