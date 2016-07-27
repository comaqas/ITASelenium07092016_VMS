package helpers;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class RandomHelper {

    public static String getRandomString() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(20);
    }

    public static String getUserName() {
        return getRandomString();
    }

    public static String getUserEmail() {
        return getRandomString().concat("@mail.ru");
    }

    public static String getUserPassword() {
        return "P".concat(getRandomString());
    }

    public static String getFirstUserName() {
        return getRandomString().substring(5);
    }

    public static String getLastUserName() {
        return getRandomString().substring(7);
    }
}
