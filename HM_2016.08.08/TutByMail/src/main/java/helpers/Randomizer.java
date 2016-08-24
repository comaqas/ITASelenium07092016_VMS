package helpers;

import java.util.*;

public class Randomizer {

    public static String getRandomString() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(20);
    }

    public static String getRandomSubject(){
        return getRandomString() + "_" + new Date().toString().replaceAll(" ", "").replaceAll(":", "");
    }

    public static String getRandomMessage(){
        return UUID.randomUUID().toString();
    }
}

