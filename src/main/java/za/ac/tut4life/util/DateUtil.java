package za.ac.tut4life.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public String getTime(){
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Long current_system_time = System.currentTimeMillis();
        Date now = new Date(current_system_time);
        return DATE_FORMAT.format(now).toString();

    }


}
