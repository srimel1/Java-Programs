
public class Switch {
	public static void main(String[] args) {
		int score = 90;
		int score1 = 95;
		int score2 = 87;
		int score3 = 70;
		int score4 = 61;
		int score5 = 100;
		int score6 = 20;
		char sc = grade(score);
		char sc1=grade(score1);
		char sc2=grade(score2);
		char sc3=grade(score3);
		char sc4=grade(score4);
		char sc5=grade(score5);
		char sc6 = grade(score6);
		System.out.println(sc);
		System.out.println(sc1);
		System.out.println(sc2);
		System.out.println(sc3);
		System.out.println(sc4);
		System.out.println(sc5);
		System.out.println(sc6);
		
		
		
	}
	public static char grade(int score) {
		char grade;
		switch(score/10) {
		
		case 10: case 9:
			grade = 'A';
			break;
		case 8: 
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6: 
			grade = 'D';
			break;
		default:
			grade = 'F';
		}
		return grade;
	}

}
