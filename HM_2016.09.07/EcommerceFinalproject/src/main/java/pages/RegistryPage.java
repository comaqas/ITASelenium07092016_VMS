package pages;

import data.RegistryData;

import helpers.Locators;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;


public class RegistryPage {
    private static final By FIRST_NAME_INPUT = Locators.get("firstNameInput");
    private static final By LAST_NAME_INPUT = Locators.get("lastNameInput");
    private static final By PASSWORD_INPUT = Locators.get("passwordInput");
    private static final By DAY_OF_BIRTH = Locators.get("daysDropDownList");
    private static final By MONTH_OF_BIRTH = Locators.get("monthsDropDownList");
    private static final By YEAR_OF_BIRTH = Locators.get("yearsDropDownList");
    private static final By FIRST_NAME_INPUT_IN_ADDRESS = Locators.get("firstNameInAddressData");
    private static final By LAST_NAME_INPUT_IN_ADDRESS = Locators.get("lastNameInAddressData");
    private static final By COMPANY_INPUT = Locators.get("company");
    private static final By FIRST_ADDRESS_INPUT = Locators.get("firstAddress");
    private static final By CITY_INPUT = Locators.get("city");
    private static final By STATE_INPUT = Locators.get("stateDropDownList");
    private static final By POSTCODE_INPUT = Locators.get("postCode");
    private static final By MOBILE_INPUT = Locators.get("mobilePhone");
    private static final By SUBMIT_BUTTON = Locators.get("accountSubmitButton");


    public static void completeRegistryFormByEntering(RegistryData data){
        $(FIRST_NAME_INPUT).setValue(data.firstName);
        $(LAST_NAME_INPUT).setValue(data.lastName);
        $(PASSWORD_INPUT).setValue(data.password);
        $(YEAR_OF_BIRTH).selectOptionByValue(data.year);
        $(MONTH_OF_BIRTH).selectOptionByValue(data.month);
        $(DAY_OF_BIRTH).selectOptionByValue(data.day);
        $(FIRST_NAME_INPUT_IN_ADDRESS).setValue(data.firstName);
        $(LAST_NAME_INPUT_IN_ADDRESS).setValue(data.lastName);
        $(COMPANY_INPUT).setValue(data.company);
        $(FIRST_ADDRESS_INPUT).setValue(data.address);
        $(CITY_INPUT).setValue(data.city);
        $(STATE_INPUT).selectOptionByValue(data.state);
        $(POSTCODE_INPUT).setValue(data.postCode);
        $(MOBILE_INPUT).setValue(data.mobileNumber);
        $(SUBMIT_BUTTON).click();
    }

}
