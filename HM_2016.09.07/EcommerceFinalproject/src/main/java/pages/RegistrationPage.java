package pages;

import helpers.Locators;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;


public class RegistrationPage {
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


    public static void completeRegistryFormByEntering(String firstName, String lastName, String password, String day,
                                                  String month, String year, String company, String address, String city,
                                                  String state, String postCode, String mobileNumber){
        $(FIRST_NAME_INPUT).setValue(firstName);
        $(LAST_NAME_INPUT).setValue(lastName);
        $(PASSWORD_INPUT).setValue(password);
        $(YEAR_OF_BIRTH).selectOptionByValue(year);
        $(MONTH_OF_BIRTH).selectOptionByValue(month);
        $(DAY_OF_BIRTH).selectOptionByValue(day);
        $(FIRST_NAME_INPUT_IN_ADDRESS).setValue(firstName);
        $(LAST_NAME_INPUT_IN_ADDRESS).setValue(lastName);
        $(COMPANY_INPUT).setValue(company);
        $(FIRST_ADDRESS_INPUT).setValue(address);
        $(CITY_INPUT).setValue(city);
        $(STATE_INPUT).selectOptionByValue(state);
        $(POSTCODE_INPUT).setValue(postCode);
        $(MOBILE_INPUT).setValue(mobileNumber);
        $(SUBMIT_BUTTON).click();
    }

}
