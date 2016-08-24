/*
Поскольку при написании теста выполнялись промежуточные проверки,
я оставила все методы, которые использовала
*/

package pages;

import helpers.LocatorsParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SentBoxPage {

    public static final By SENT_LABEL = LocatorsParser.get("sentLabel");
    public static final By SENT_LETTER_SUBJECT = LocatorsParser.get("sentLetterSubject");


    public static boolean verifySentLabelText(WebDriver driver, String text){
        return driver.findElement(SENT_LABEL).getText().equals(text);
    }


    public static boolean isInterestedLetterPresentInSentBox(WebDriver driver, String subject){
        List<WebElement> listOfSentLetters = driver.findElements(SENT_LETTER_SUBJECT);
        ArrayList<String> listOfSentLettersSubjects = new ArrayList<String>();

        for(int i =0; i < listOfSentLetters.size(); ++i){
            listOfSentLettersSubjects.add(listOfSentLetters.get(i).getAttribute("title"));
        }
        return listOfSentLettersSubjects.contains(subject);
    }
}
