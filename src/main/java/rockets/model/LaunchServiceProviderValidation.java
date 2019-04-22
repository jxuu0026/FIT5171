package rockets.model;

import java.util.Calendar;

public class LaunchServiceProviderValidation {

    public static void yearCanNotGreaterThanCurrentYear(int year) {

        //Year founded cannot be greater than the current year

        if (Calendar.getInstance().get(Calendar.YEAR) < year)
            throw new IllegalArgumentException("Year founded can not greater than the current year");
    }
}
