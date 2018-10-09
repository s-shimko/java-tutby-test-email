package by.test.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

  public static String getDateTimeNow(String format){
    Date date = new Date();
    SimpleDateFormat formatForDateNow = new SimpleDateFormat(format);
    return formatForDateNow.format(date);
  }
}
