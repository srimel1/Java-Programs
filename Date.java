import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
public class Date {

	private String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	private static int JANUARY  =  1;
	private int FEBRUARY =  2;
	private int DECEMBER = 12;
	private int DAYS_PER_WEEK      =   7;
	private int DAYS_PER_YEAR      = 365;
	private int DAYS_PER_LEAP_YEAR = 366;
	private int[] DAYS_PER_MONTH = { -1,

			31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31,
	};
	private int year;
	private int month;
	private int day;
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

	/***
	 * generic constructor
	 */
	public Date() {

	}
	/***
	 * 
	 * @param year
	 * @param month
	 * @param day
	 */
	public Date(int month, int day, int year) {
		this.year = year;
		this.month = month;
		this.day = day;
		if (month < 1 || month > 12 || day < 1 || day > getDaysInMonth()) {
            throw new IllegalArgumentException("Invalid day or month: " + toString());
        }

	}
	/***
	 * 
	 * getters 
	 */
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
	public String getDay(Date d) {
		return day+"";
	}
	public String getMonth(Date d) {
		return ""+month;
	}
	public String getYear(Date d) {
		return year+"";
	}
	public int getMonthI(Date d) {
		return month;
	}
	/***
	 * 
	 * @param Date d 
	 * @return the string representation of the the month. 
	 */
	public String monthString(Date d) {
		return months[getMonthI(d)-1];
	}
	/***
	 * 
	 * toString
	 */
	public String toString2() {
		return month+" "+day+" "+year;
	}
	public String toString() {
		return month + "/" + (day) + "/" + (year);
	}
	/***
	 * 
	 * @return true if the date is a leap year.
	 * @return false if the date is not a leap year
	 */
	/***
	 * 
	 * @return true if it is a leap year.
	 * @return false if it is not a leap year
	 */
	public boolean isLeapYear() {
		if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
		return true;
		else {return false;
		
		}
	}
	/***
	 * Method to add days to the given date
	 * 
	 */
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
	/***
	 * method to add weeks to the given date.
	 * 
	 */
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
    public String toString3() {
    	return day +"/"+ month +"/"+year;
    }
    public String getStringDay(Date d) throws ParseException {
    	String date = d.toString3();
    	SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
    	  java.util.Date dt1=format1.parse(date);
    	  DateFormat format2=new SimpleDateFormat("EEEE"); 
    	  String finalDay=format2.format(dt1);
		return finalDay;
    	  
    }
	/***
	 * 
	 * @param start date
	 * @param end date
	 * @return the difference in days between the start date and the end date. 
	 */
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
	public String dayToString(Date d) {
		return day + "";
	}
	public String monthToString(Date d) {
		return month + "";
	}
	public String yearToString(Date d) {
		return year + "";
	}

}
