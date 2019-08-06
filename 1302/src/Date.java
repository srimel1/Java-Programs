import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
public class Date {
     
    private static int JANUARY  =  1;
    private int FEBRUARY =  2;
    private int DECEMBER = 12;
    private int DAYS_PER_WEEK      =   7;
    private int DAYS_PER_YEAR      = 365;
    private int DAYS_PER_LEAP_YEAR = 366;
    private int[] DAYS_PER_MONTH = { -1,
    //   1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31,
    };
    
    // fields
    private int year;
    private int month;
    private int day;

   
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        
        if (month < 1 || month > 12 || day < 1 || day > getDaysInMonth()) {
            throw new IllegalArgumentException("Invalid day or month: " + toString());
        }
    }
    
    public void addDays(int days) {
        while (days > getDaysInYear()) {
            days -= getDaysInYear();
            year++;
        }
        
        for (int i = 1; i <= days; i++) {
            nextDay();
        }
    }
    public void addWeeks(int weeks) {
    	int days = weeks*7;
        while (days > getDaysInYear()) {
            days -= getDaysInYear();
            year++;
        }
        
        for (int i = 1; i <= days; i++) {
            nextDay();
        }
    }
    public int getDay() {
        return day;
    }

    public int getDaysInMonth() {
        int result = DAYS_PER_MONTH[month];
        if (month == FEBRUARY && isLeapYear()) {
            result++;
        }
        return result;
    }
    
    public int getDaysInYear() {
        if (isLeapYear()) {
            return 366;
        } else {
            return 365;
        }
    }

  
    public int getMonth() {
        return month;
    }
  
    public int getYear() {
        return year;
    }
    
   
    public boolean isLeapYear() {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
    
  
    public void nextDay() {
        day++;
        if (day > getDaysInMonth()) {
            // wrap to next month
            month++;
            day = 1;
            if (month > DECEMBER) {
                // wrap to next year
                year++;
                month = JANUARY;
            }
        }
    }
    public void nextWeek() {
        day+=7;
        if (day > getDaysInMonth()) {
            // wrap to next month
            month++;
            day = 1;
            if (month > DECEMBER) {
                // wrap to next year
                year++;
                month = JANUARY;
            }
        }
    }
    

    public String toString() {
        return year + "/" + (month) + "/" + (day);
    }
    public String countDays(Date start, Date end) {
		SimpleDateFormat myFormat = new SimpleDateFormat("MM dd yyyy");
		String inputString1 = start.toString2();
		String inputString2 = end.toString2();
		long diff = 0;
		try {
			java.util.Date date1 = myFormat.parse(inputString1);
			java.util.Date date2 = myFormat.parse(inputString2);
			diff = date2.getTime() - date1.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) +" days between " + start.toString() +" and "+ end.toString() + ".";
	}
    public String toString2() {
		return month+" "+day+" "+year;
	}

    
}