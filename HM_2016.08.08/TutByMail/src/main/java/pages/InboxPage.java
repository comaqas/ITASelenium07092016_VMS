/*
Поскольку при написании теста выполнялись промежуточные проверки,
я оставила все методы, которые использовала
*/

package pages;

import helpers.LocatorsParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class InboxPage {
    public static final By USER_EMAIL = LocatorsParser.get("userEmail");
    public static final By COMPOSE_LETTER_ICON = LocatorsParser.get("composeLetterIcon");
    public static final By RECIPIENT_INPUT = LocatorsParser.get("recipientInput");
    public static final By SUBJECT_INPUT = LocatorsParser.get("subjectInput");
    public static final By MESSAGE_INPUT = LocatorsParser.get("messageInput");
    public static final By SEND_BUTTON = LocatorsParser.get("sendButton");
    public static final By SENT_LETTERS_FOLDER = LocatorsParser.get("sentLettersFolder");


    public static boolean verifyUserEmail(WebDriver driver, String email){
        return driver.findElement(USER_EMAIL).getText().equals(email);
    }

    public static void composeNewLetter(WebDriver driver, String email, String subject, String message){
        driver.findElement(COMPOSE_LETTER_ICON).click();
        driver.findElement(RECIPIENT_INPUT).sendKeys(email);
        driver.findElement(SUBJECT_INPUT).sendKeys(subject);
        driver.switchTo().frame(1).findElement(MESSAGE_INPUT).sendKeys(message);
        driver.switchTo().defaultContent();
        driver.findElement(SEND_BUTTON).click();
    }

    public static void navigateToSentLettersFolder(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        Actions builder = new Actions(driver);
        builder.contextClick(driver.findElement(SENT_LETTERS_FOLDER)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
   }


}

