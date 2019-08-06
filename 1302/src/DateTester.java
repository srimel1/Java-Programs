
public class DateTester {

	public static void main(String[] args) {
		Date d = new Date(1600 , 07 , 12);
		Date d1 = new Date(2007, 05, 31);
		Date d2 = new Date(2018, 07, 27);
		Date d3 = new Date(2018, 07, 30);
		Date d4 = new Date(2000, 01, 30);
		Date d5 = new Date(1999, 11, 4);
		Date d6 = new Date(2020, 10, 16);
		
		System.out.println(d2.toString2());
		System.out.println(d2.countDays(d2,d3));
		d2.addWeeks(1);
		System.out.println(d2.toString());
		d2.addDays(10);
		System.out.println(d2.toString());
		System.out.println(d6.isLeapYear());
		System.out.println(d5.getDay());
		System.out.println(d4.getMonth());
		System.out.println(d3.getDaysInMonth());
		System.out.println(d.isLeapYear());
	}

}
