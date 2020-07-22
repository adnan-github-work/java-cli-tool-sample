package com.cli.tool.operations;

public class FormatString  {

    private static String value;

    public FormatString(String value){
        this.value = value;
    }

    public String toAlternateCase() {
        char[] chars = value.toCharArray();
        String st = "";
        for (int i = 0; i < chars.length; i++){
            char ch = chars[i];
            if ((i+1) % 2 == 0){
                st += (ch +"").toUpperCase();
            }else {
                st += (ch +"").toLowerCase();
            }
        }
        return st;
    }

    public String toUpperCase() {
        return value.toUpperCase();
    }

}
