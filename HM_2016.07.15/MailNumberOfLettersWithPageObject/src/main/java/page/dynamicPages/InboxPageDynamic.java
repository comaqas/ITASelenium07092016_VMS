package page.dynamicPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class InboxPageDynamic {

    private final By CHECK_BOX_SELECT_ALL_LETTERS_ON_PAGE = By.cssSelector(".b-dropdown__ctrl .b-checkbox__box");
    private final By TEXT_LINK_SELECT_ALL_LETTERS_IN_FOLDER = By.cssSelector(".pseudo-link[data-name='selectAllLetters']");
    private final By NUMBER_OF_LETTERS_IN_FOLDER = By.className("b-announcement__text");

    private WebDriver driver;

    public InboxPageDynamic(WebDriver driver){
        this.driver = driver;
    }

    public void selectAllLettersOnPage(){
        WebElement selectAllLettersOnPageCheckBox = driver.findElement(CHECK_BOX_SELECT_ALL_LETTERS_ON_PAGE);
        selectAllLettersOnPageCheckBox.click();
    }

    public void selectALlLettersInFolder(){
        WebElement selectAllLettersInFolderTextLink = driver.findElement(TEXT_LINK_SELECT_ALL_LETTERS_IN_FOLDER);
        selectAllLettersInFolderTextLink.click();
    }


    // метод возвращает количетсво писем (Х) путем разбиения строки
    // "Выделено Х писем. Снять выделение со всех писем в папке «Входящие»" на части по символу пробела

    public String calculateNumberOfLettersInFolder() {
        WebElement fullResultMessageWithNumberOfLetters = driver.findElement(NUMBER_OF_LETTERS_IN_FOLDER);

        String shortResultMessageWithNumberOfLetters = fullResultMessageWithNumberOfLetters.getText();

        String[] numberOfLettersInFolder = shortResultMessageWithNumberOfLetters.split(" ");

        return numberOfLettersInFolder[1];
    }

}
