package page.staticPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class InboxPageStatic {

    private static final By CHECK_BOX_SELECT_ALL_LETTERS_ON_PAGE = By.cssSelector(".b-dropdown__ctrl .b-checkbox__box");
    private static final By TEXT_LINK_SELECT_ALL_LETTERS_IN_FOLDER = By.cssSelector(".pseudo-link[data-name='selectAllLetters']");
    private static final By NUMBER_OF_LETTERS_IN_FOLDER = By.className("b-announcement__text");


    public static void selectAllLettersOnPage(WebDriver driver){
        WebElement selectAllLettersOnPageCheckBox = driver.findElement(CHECK_BOX_SELECT_ALL_LETTERS_ON_PAGE);
        selectAllLettersOnPageCheckBox.click();
    }

    public static void selectALlLettersInFolder(WebDriver driver){
        WebElement selectAllLettersInFolderTextLink = driver.findElement(TEXT_LINK_SELECT_ALL_LETTERS_IN_FOLDER);
        selectAllLettersInFolderTextLink.click();
    }


    // метод возвращает количетсво писем (Х) путем разбиения строки
    // "Выделено Х писем. Снять выделение со всех писем в папке «Входящие»" на части по символу пробела

    public static String calculateNumberOfLettersInFolder(WebDriver driver) {
        WebElement fullResultMessageWithNumberOfLetters = driver.findElement(NUMBER_OF_LETTERS_IN_FOLDER);

        String shortResultMessageWithNumberOfLetters = fullResultMessageWithNumberOfLetters.getText();

        String[] numberOfLettersInFolder = shortResultMessageWithNumberOfLetters.split(" ");

        return numberOfLettersInFolder[1];
    }

}
