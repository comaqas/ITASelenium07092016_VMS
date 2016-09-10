package helpers;

import org.apache.commons.lang3.RandomStringUtils;


public class Randomizer {

    public static String getRandomAlphabeticString(){
        return RandomStringUtils.randomAlphabetic(7);
    }


    public static String getRandomAlphanumericString(){
        return RandomStringUtils.randomAlphanumeric(8);
    }


    public static String getRandomSubjectHeading() {
        final int MIN_MONTH = 1;
        final int MAX_MONTH = 2;
        int randomValue = MIN_MONTH + (int)(Math.random() * ((MAX_MONTH - MIN_MONTH) + 1));
        String randomMonth = String.valueOf(randomValue);
        return randomMonth;
    }


    public static String getRandomEmail() {
        return getRandomAlphabeticString().concat("@yahoo.com");
    }


    public static String getRandomYear() {
        final int MIN_YEAR = 1970;
        final int MAX_YEAR = 2000;
        int randomValue = MIN_YEAR + (int)(Math.random() * ((MAX_YEAR - MIN_YEAR) + 1));
        String randomYear = String.valueOf(randomValue);
        return randomYear;
    }


    public static String getRandomMonth() {
        final int MIN_MONTH = 1;
        final int MAX_MONTH = 12;
        int randomValue = MIN_MONTH + (int)(Math.random() * ((MAX_MONTH - MIN_MONTH) + 1));
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
        final int MIN_STATE = 1;
        final int MAX_STATE = 50;
        int randomValue = MIN_STATE + (int)(Math.random() * ((MAX_STATE - MIN_STATE) + 1));
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

