package pages;

import helpers.LocatorsParserHelper;
import helpers.RandomHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RegistrationPage {

    public static final By USER_NAME = LocatorsParserHelper.get("UserName");
    public static final By INVALID_USER_NAME_MESSAGE = LocatorsParserHelper.get("InvalidUserNameWarningTooltip");
    public static final By USER_EMAIL = LocatorsParserHelper.get("UserEmail");
    public static final By USER_PASSWORD = LocatorsParserHelper.get("Password");
    public static final By USER_PASSWORD_CONFIRMATION = LocatorsParserHelper.get("PasswordConfirmation");
    public static final By INVALID_PASSWORD_CONFIRMATION_MESSAGE =
            LocatorsParserHelper.get("InvalidUserPasswordConfirmationWarningMessage");
    public static final By USER_FIRST_NAME = LocatorsParserHelper.get("UserFirstName");
    public static final By USER_LAST_NAME = LocatorsParserHelper.get("UserLastName");
    public static final By CURRENT_POSITION = LocatorsParserHelper.get("UserCurrentPosition");
    public static final By COMPANY_DROPDOWN_LABEL = LocatorsParserHelper.get("UserCompanyDropDownLabel");
    public static final By COMPANY_DROPDOWN_INPUT = LocatorsParserHelper.get("UserCompanyDropDownInput");
    public static final By COMPANY_DROPDOWN_RESULT_ITEM = LocatorsParserHelper.get("UserCompanyDropDownResult");
    public static final By AGREEMENT_CHECKBOX = LocatorsParserHelper.get("AgreementCheckbox");
    private static final By UNMARKED_AGREEMENT_WARNING_MESSAGE = LocatorsParserHelper.get("UnmarkedAgreementTooltipMessage");
    public static final By SUBMIT_BUTTON = LocatorsParserHelper.get("SubmitButton");


    private static List<String> itCompanies = Arrays.asList("itransition", "issoft", "epam", "viber", "belhard");

    // метод для позитивного теста
    public static void fillRegistryFormWithValidData(WebDriver driver) {

        String password = RandomHelper.getUserPassword();

        driver.findElement(USER_NAME).sendKeys(RandomHelper.getUserName());
        driver.findElement(USER_EMAIL).sendKeys(RandomHelper.getUserEmail());
        driver.findElement(USER_PASSWORD).sendKeys(password);
        driver.findElement(USER_PASSWORD_CONFIRMATION).sendKeys(password);
        driver.findElement(USER_FIRST_NAME).sendKeys(RandomHelper.getFirstUserName());
        driver.findElement(USER_LAST_NAME).sendKeys(RandomHelper.getLastUserName());
        driver.findElement(CURRENT_POSITION).sendKeys(RandomHelper.getRandomString());
        selectCompany(getRandomCompany(itCompanies), driver);
        driver.findElement(AGREEMENT_CHECKBOX).click();
        driver.findElement(SUBMIT_BUTTON).click();
    }

    // методы для негативных тестов
    public static void fillRegistryFormWithInvalidUserName(WebDriver driver) {

        List<String> forbiddenSymbols = Arrays.asList("$", "@", "!", "%", ",");
        String password = RandomHelper.getUserPassword();

        driver.findElement(USER_NAME).sendKeys(RandomHelper.getUserName().concat(getForbiddenSymbol(forbiddenSymbols)));
        driver.findElement(USER_EMAIL).sendKeys(RandomHelper.getUserEmail());
        driver.findElement(USER_PASSWORD).sendKeys(password);
        driver.findElement(USER_PASSWORD_CONFIRMATION).sendKeys(password);
        driver.findElement(USER_FIRST_NAME).sendKeys(RandomHelper.getFirstUserName());
        driver.findElement(USER_LAST_NAME).sendKeys(RandomHelper.getLastUserName());
        driver.findElement(CURRENT_POSITION).sendKeys(RandomHelper.getRandomString());
        selectCompany(getRandomCompany(itCompanies), driver);
        driver.findElement(AGREEMENT_CHECKBOX).click();
        driver.findElement(SUBMIT_BUTTON).click();
    }

    public static String getForbiddenSymbol(List<String> list){
        Random randomizer = new Random();
        return list.get(randomizer.nextInt(list.size()));
    }

    public static boolean isWarningMessageAboutForbiddenSymbolsDisplayed(WebDriver driver){
        if (driver.findElement(INVALID_USER_NAME_MESSAGE).isDisplayed()){
            return true;
        }return false;
    }

    public static void fillRegistryFormWithDifferentPasswords(WebDriver driver) {

        List<String> forbiddenSymbols = Arrays.asList("$", "@", "!", "%", ",");

        driver.findElement(USER_NAME).sendKeys(RandomHelper.getUserName());
        driver.findElement(USER_EMAIL).sendKeys(RandomHelper.getUserEmail());
        driver.findElement(USER_PASSWORD).sendKeys(RandomHelper.getUserPassword());
        driver.findElement(USER_PASSWORD_CONFIRMATION).sendKeys(RandomHelper.getUserPassword());
        driver.findElement(USER_FIRST_NAME).sendKeys(RandomHelper.getFirstUserName());
        driver.findElement(USER_LAST_NAME).sendKeys(RandomHelper.getLastUserName());
        driver.findElement(CURRENT_POSITION).sendKeys(RandomHelper.getRandomString());
        selectCompany(getRandomCompany(itCompanies), driver);
        driver.findElement(AGREEMENT_CHECKBOX).click();
        driver.findElement(SUBMIT_BUTTON).click();
    }

    public static boolean isWarningMessageAboutUnmatchedUserPasswordsDisplayed(WebDriver driver){
        if (driver.findElement(INVALID_PASSWORD_CONFIRMATION_MESSAGE).isDisplayed()){
            return true;
        }return false;
    }


    public static void fillRegistryFormWithoutAgreementMark(WebDriver driver) {

        String password = RandomHelper.getUserPassword();

        driver.findElement(USER_NAME).sendKeys(RandomHelper.getUserName());
        driver.findElement(USER_EMAIL).sendKeys(RandomHelper.getUserEmail());
        driver.findElement(USER_PASSWORD).sendKeys(password);
        driver.findElement(USER_PASSWORD_CONFIRMATION).sendKeys(password);
        driver.findElement(USER_FIRST_NAME).sendKeys(RandomHelper.getFirstUserName());
        driver.findElement(USER_LAST_NAME).sendKeys(RandomHelper.getLastUserName());
        driver.findElement(CURRENT_POSITION).sendKeys(RandomHelper.getRandomString());
        selectCompany(getRandomCompany(itCompanies), driver);
        driver.findElement(SUBMIT_BUTTON).click();
    }

    public static boolean isWarningMessageAboutUnmarkedAgreementlsDisplayed(WebDriver driver){
        if (driver.findElement(UNMARKED_AGREEMENT_WARNING_MESSAGE).isDisplayed()){
            return true;
        }return false;
    }

    // методы, общие для позитивных и негативных тестов
    public static void selectCompany(String company, WebDriver driver) {
        driver.findElement(COMPANY_DROPDOWN_LABEL).click();
        driver.findElement(COMPANY_DROPDOWN_INPUT).sendKeys(company);
        driver.findElement(COMPANY_DROPDOWN_RESULT_ITEM).click();
    }

    private static String getRandomCompany(List<String> list) {
        Random randomizer = new Random();
        return list.get(randomizer.nextInt(list.size()));
    }
}
