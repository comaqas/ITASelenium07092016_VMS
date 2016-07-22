package page.factoryPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class InboxPageFactory {

    @FindBy(css = ".b-dropdown__ctrl .b-checkbox__box")
    private WebElement selectAllLettersOnPageCheckBox;

    @FindBy(css = ".pseudo-link[data-name='selectAllLetters']")
    private WebElement  selectAllLettersInFolderTextLink;

    @FindBy(className = "b-announcement__text")
    private WebElement numberOfLettersInFolderText;

    public void selectAllLettersOnPage(){
        selectAllLettersOnPageCheckBox.click();
    }

    public void selectALlLettersInFolder(){
        selectAllLettersInFolderTextLink.click();
    }


    // метод возвращает количетсво писем (Х) путем разбиения строки
    // "Выделено Х писем. Снять выделение со всех писем в папке «Входящие»" на части по символу пробела

    public String calculateNumberOfLettersInFolder() {
        WebElement fullResultMessageWithNumberOfLetters = numberOfLettersInFolderText;

        String shortResultMessageWithNumberOfLetters = fullResultMessageWithNumberOfLetters.getText();

        String[] numberOfLettersInFolder = shortResultMessageWithNumberOfLetters.split(" ");

        return numberOfLettersInFolder[1];
    }


}
