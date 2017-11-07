package model;

public class Util {

    /**
     * 终结符
     */
    public static String[] Vts = new String[]{
            "if", "while", "(", ")", "{", "}", ";", "+", "-", "*", "/", "||", "&&",
            ">", ">=", "<", "<=", "==", "!=", "=", "num", "id", "$"
    };

    /**
     * 保留字
     */
    public static String[] reservedWords = new String[]{
            "class", "public", "protected", "private", "void", "static", "int", "char", "float",
            "double", "String", "if", "else", "switch", "case", "for", "do", "while", "try", "catch"
    };

    /**
     * 字符数组转化为字符串
     *
     * @param chars
     * @return
     */
    public static String charToString(char[] chars) {
        int len = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '\0')
                len++;
        }
        return String.valueOf(chars).substring(0, len);
    }
}
