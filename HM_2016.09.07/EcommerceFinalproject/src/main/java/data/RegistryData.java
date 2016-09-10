package data;

import helpers.Randomizer;

public class RegistryData {

    public String firstName;
    public String lastName;
    public String password;
    public String day;
    public String month;
    public String year;
    public String company;
    public String address;
    public String city;
    public String state;
    public String postCode;
    public String mobileNumber;


    public RegistryData (){
        this.firstName = Randomizer.getRandomAlphabeticString();
        this.lastName = Randomizer.getRandomAlphabeticString();
        this.password = Randomizer.getRandomAlphanumericString();
        this.day = Randomizer.getRandomDay();
        this.month = Randomizer.getRandomMonth();
        this.year = Randomizer.getRandomYear();
        this.company = Randomizer.getRandomCompany();
        this.address = Randomizer.getRandomAddress();
        this.city = Randomizer.getRandomCity();
        this.state = Randomizer.getRandomState();
        this.postCode = Randomizer.getRandomPostCode();
        this.mobileNumber = Randomizer.getRandomMobilePhone();
    }

}
