package rockets.model;

import java.util.Calendar;
import java.util.Set;

public class LaunchValidation {

    public static void yearCanNotGreaterThanCurrentYear(int year){

    //launch date can not greater than the current year
        if(Calendar.getInstance().get(Calendar.YEAR) < year)
            throw new IllegalArgumentException("Year can not greater than current year") ;


    }


    public static void setIsEmpty(Set<String> payloads){

        if(payloads.isEmpty())
            throw new IllegalArgumentException("Payloads set cannot be empty") ;

    }

    public static void listIsEmpty(Set<Payload> payloads){

        if(payloads.isEmpty())
            throw new IllegalArgumentException("Payloads set cannot be empty") ;

    }


}
