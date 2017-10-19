package io;

public class charToString {

    public static String charToString(char[] chars) {
        int len = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '\0')
                len++;
        }
        return String.valueOf(chars).substring(0, len);
    }
}
