package com.conversor.conversor.Util;

public class InputValidation {

    String inputRegex= "^[0-9]+([.][0-9]+)?$";

    public boolean inputValidate(String input, String from, String to){
        if (from!=null & to!= null){
            return (input.matches(inputRegex));

        }else{
            return false;
        }
    }
}
