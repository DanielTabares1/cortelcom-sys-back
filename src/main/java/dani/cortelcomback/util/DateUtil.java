package dani.cortelcomback.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static Calendar calendar = Calendar.getInstance();

    public DateUtil(int year, int month){
        calendar.set(year, month, 1, 0, 0, 0);
    }

    public Date getStartOfMonth(){
        calendar.add(Calendar.SECOND, -1);
        return calendar.getTime();
    }

    public Date getEndOfMonth(){
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.SECOND, 1);
        return calendar.getTime();
    }

}
