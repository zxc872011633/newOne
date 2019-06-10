package com.ToolMethod;

public class CutString {

    public static String[] cutString(String str) {
        String a =	str.replaceAll("[^0-9,]", "");
        String[] s = a.split(",");
        return s;
    }
}
