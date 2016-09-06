package helpers;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Randomizer {

    public static String getRandomAlphabeticString(){
        return RandomStringUtils.randomAlphabetic(7);
    }


    public static String getRandomAlphanumericString(){
        return RandomStringUtils.randomAlphanumeric(8);
    }


    public static String getRandomSubjectHeading() {
        int minMonth = 1;
        int maxMonth = 2;
        int randomValue = minMonth + (int)(Math.random() * ((maxMonth - minMonth) + 1));
        String randomMonth = String.valueOf(randomValue);
        return randomMonth;
    }


    public static String getRandomEmail() {
        //String[] emails = {"@tut.by", "@yahoo.com", "@gmail.com", "@mail.ru", "@bk.ru"};
        return getRandomAlphabeticString().concat("@yahoo.com");
    }


    public static String getRandomYear() {
        int minYear = 1970;
        int maxYear = 2000;
        int randomValue = minYear + (int)(Math.random() * ((maxYear - minYear) + 1));
        String randomYear = String.valueOf(randomValue);
        return randomYear;
    }


    public static String getRandomMonth() {
        int minMonth = 1;
        int maxMonth = 12;
        int randomValue = minMonth + (int)(Math.random() * ((maxMonth - minMonth) + 1));
        String randomMonth = String.valueOf(randomValue);
        return randomMonth;
    }


    public static String getRandomDay() {
        int minDay = 1;

        if(getRandomMonth() == "4" || getRandomMonth() == "6" || getRandomMonth() == "9" || getRandomMonth() == "11"){
            int maxDay = 30;
            int randomValue = minDay + (int)(Math.random() * ((maxDay - minDay) + 1));
            String randomDay = String.valueOf(randomValue);
            return randomDay;
        }else if (getRandomMonth() == "2"){
            int maxDay = 28;
            int randomValue = minDay + (int)(Math.random() * ((maxDay - minDay) + 1));
            String randomDay = String.valueOf(randomValue);
            return randomDay;
        }else{
            int maxDay = 31;
            int randomValue = minDay + (int)(Math.random() * ((maxDay - minDay) + 1));
            String randomDay = String.valueOf(randomValue);
            return randomDay;
        }
    }


    public static String getRandomCompany() {
        return "Company #".concat(RandomStringUtils.randomNumeric(2));
    }


    public static String getRandomAddress() {
        return "Street #".concat(RandomStringUtils.randomNumeric(3)) + ", "
                + "P.O. Box #".concat(RandomStringUtils.randomNumeric(3));
    }


    public static String getRandomCity() {
        String[] cities = {"Chicago", "Phoenix", "Los Angeles", "Dallas", "Seattle", "Detroit", "Portland",
                "Washington", "Las Vegas", "Atlanta"};
        int randomValue = (int)(Math.random()*10);
        return cities[randomValue];
    }


    public static String getRandomState() {
        int minState = 1;
        int maxState = 50;
        int randomValue = minState + (int)(Math.random() * ((maxState - minState) + 1));
        String randomState = String.valueOf(randomValue);
        return randomState;
    }


    public static String getRandomPostCode() {
        return RandomStringUtils.randomNumeric(5);
    }


    public static String getRandomMobilePhone() {
        return (RandomStringUtils.randomNumeric(3)) + "-" + (RandomStringUtils.randomNumeric(3)) + "-"
                + (RandomStringUtils.randomNumeric(2));
    }

}

