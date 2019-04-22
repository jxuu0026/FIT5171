package rockets.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation {

    public static void checkCorrectEmailFormat(String emailString){

        Pattern mailREGX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        Matcher matcher = mailREGX.matcher(emailString);

        if(!matcher.find())
            throw new IllegalArgumentException("input email is invalid");
    }

    public static void isEmpty(String str){

        if(str.isEmpty())
            throw new IllegalArgumentException("input email is invalid") ;

    }


}