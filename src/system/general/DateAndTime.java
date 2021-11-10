package system.general;

import java.util.Calendar;
import java.util.Date;

public class DateAndTime {

    public static int currentDay, currentMonth, currentYear;
    public static Calendar currentDate;

    public static void setCurrentDate() {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        currentDay = cal.get(Calendar.DAY_OF_MONTH);
        currentMonth = cal.get(Calendar.MONTH) + 1;
        currentYear = cal.get(Calendar.YEAR);

        currentDate = cal;

    }
}
