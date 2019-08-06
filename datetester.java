import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class datetester {

	public static void main(String[] args) {
		Date d3 = new Date(3, 2, 1600);
		System.out.println(d3.isLeapYear());
		System.out.println(d3.monthString(d3));
		System.out.println(d3.getYear(d3));

		Date d1 = new Date(10,13,2018);
		Date d2 = new Date(2,24,2020);
		System.out.println(d1.countDays(d1,d2));
		d1.countDays(d1, d2);
		System.out.println(d1.isLeapYear());
		System.out.println(d2.isLeapYear());
		System.out.println(d1.toString3());
		try {
			System.out.println(d1.getStringDay(d1));
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	

}
