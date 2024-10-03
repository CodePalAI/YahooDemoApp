package com.demoapp.utils;

import java.util.Random;

public class GeneralUtils {

    private static final Random random = new Random();

    public static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            result.append(chars.charAt(index));
        }

        return result.toString();
    }

    public static String buildQuery(String tableName, String condition) {
        return "SELECT * FROM " + tableName + " WHERE " + condition;
    }

    public static String concatenateStrings(String str1, String str2) {
        return str1 + str2;
    }

    public static String repeatString(String str, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += str;
        }
        return result;
    }
}
