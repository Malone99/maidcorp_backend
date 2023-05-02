package com.fmc.maidcorp.helper;

public class Helper {

    public static void  check(String input){
        boolean invalidValue=!(input.matches("^[^0-9]*$"))|| input.isEmpty()|| input.equals("");
        System.out.println(invalidValue);
        if(invalidValue)
            throw new IllegalArgumentException("fill in please valid information-->");
    }

    public static void main(String[] args) {
        Helper.check("22");
    }
}
