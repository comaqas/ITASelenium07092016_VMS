package core;

import helpers.LocatorsParser;
import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import java.util.List;


public class PageBase {

    private static final By COMPOSE_LETTER_BUTTON = LocatorsParser.get("composeLetterButton");
    private static final By RECIPIENT_EMAIL_INPUT = LocatorsParser.get("recipientEmailInput");
    private static final By EMAIL_SUBJECT_INPUT = LocatorsParser.get("subjectInput");
    private static final By EMOTION_ICONS = LocatorsParser.get("emotionIcons");
    private static final By TARGET_EMOTION_ICON = LocatorsParser.get("targetEmotionIcon");
    private static final By SEND_BUTTON = LocatorsParser.get("sendButton");
    private static final By APPROVAL_SENT_MESSAGE = LocatorsParser.get("sentMessage");
    private static final By LETTERS_DATA = LocatorsParser.get("dataAboutLetters");
    private static final By LETTERS_ON_PAGE = LocatorsParser.get("letters");
    private static final By NEXT_PAGE_BUTTON = LocatorsParser.get("nextPageButton");
    private static final By NEXT_PAGE_ARROW = LocatorsParser.get("nexrPageArrow");


    public static void composeLetter(String email, String subject){
        $(COMPOSE_LETTER_BUTTON).waitUntil(visible, 10000).click();
        $(RECIPIENT_EMAIL_INPUT).waitUntil(visible, 10000).sendKeys(email);
        $(EMAIL_SUBJECT_INPUT).waitUntil(visible, 10000).setValue(subject);
        $(EMOTION_ICONS).click();
        $(TARGET_EMOTION_ICON).click();
        $(SEND_BUTTON).waitUntil(visible, 10000).click();
        $(APPROVAL_SENT_MESSAGE).shouldBe(visible);
    }

    public static boolean isTargetLetterPresentOnTheFirstPageInsideFolder(String subject){
        List<SelenideElement> lettersData = $$(LETTERS_DATA);
        String[] subjectsOftLetters = new String[lettersData.size()];

        for (int i = 0; i < lettersData.size(); i++){
            subjectsOftLetters[i] = lettersData.get(i).getText();
        }

        for (int i = 0; i<subjectsOftLetters.length; i++){
            if (subjectsOftLetters[i].contains(subject)){
                return true;
            }
        }
        
       return false;
    }


    public static int calculateNumberOfLettersInsideFolder (){

        int actualNumberOfletters = 0;
        String nameOfAttribute = "class";
        String flagAboutDisabledState = "b-toolbar__btn_disabled";

        while (true){
            List<SelenideElement> lettersOnThePage = $$(LETTERS_ON_PAGE);
            actualNumberOfletters += lettersOnThePage.size();

            if (!$(NEXT_PAGE_BUTTON).getAttribute(nameOfAttribute).contains(flagAboutDisabledState)) {
                $(NEXT_PAGE_ARROW).click();
            } else {
                break;
            }
        }
        return actualNumberOfletters;
    }
}
