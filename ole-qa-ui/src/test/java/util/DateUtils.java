package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

    public static SimpleDateFormat COMPAS_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat RESTRICTED_DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
    public static SimpleDateFormat NORMALIZED_DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");

    public static String getRandomDOB() {

        GregorianCalendar gc = new GregorianCalendar();

        int year = randBetween(1930, 1950);

        gc.set(gc.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        return gc.get(gc.MONTH) + "/" + gc.get(gc.DAY_OF_MONTH) + "/" + gc.get(gc.YEAR);

    }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

    public static String getFirstDayOfFutureMonth(int numberOfMonths) {
        Date nextMonth = org.apache.commons.lang3.time.DateUtils.addMonths(new Date(), 1);

        Calendar cal = Calendar.getInstance();
        cal.setTime(nextMonth);

        String month = Integer.toString(cal.get(Calendar.MONTH) + numberOfMonths);
        if(month.length()==1) month = "0"+month;

        return  month + "/01/" + Integer.toString(cal.get(Calendar.YEAR));
    }

    public static String getDOBofPersonTurningAgeToday(int age) {
        Date dob = org.apache.commons.lang3.time.DateUtils.addYears(new Date(), -age);
        return RESTRICTED_DATE_FORMAT.format(dob);
    }
    public static String getDOBInNormalDateFormat(int age) {
        Date dob = org.apache.commons.lang3.time.DateUtils.addYears(new Date(), -age);
        return NORMALIZED_DATE_FORMAT.format(dob);
    }
    public static String convertDate(String date, SimpleDateFormat format) {
        Date dt;
        if(date.contains("-")){
            try {
                dt = COMPAS_DATE_FORMAT.parse(date);
            } catch (ParseException e) {
                return "";
            }
        } else {
            dt = new Date(date);
        }
        return format.format(dt);
    }
    public static String getFirstDayOfPastMonth(int numberOfMonths) {

        Date pastMonth = org.apache.commons.lang3.time.DateUtils.addMonths(new Date(), numberOfMonths);

        Calendar cal = Calendar.getInstance();
        cal.setTime(pastMonth);
        String month = Integer.toString(pastMonth.getMonth()+1);//Integer.toString(cal.get(Calendar.MONTH) - numberOfMonths;

        if(month.length()==1) month = "0"+month;
        return  month + "/01/" + Integer.toString(cal.get(Calendar.YEAR));
    }

}
