import java.io.*;

import java.util.Scanner;

public class NewC{

	public static void main(String args[])

	{

		int a,i=0,c,c024=0,c2549=0,c5074=0,c7599=0;

		int c100124=0,c125149=0,c150174=0,c175200=0;

		float b;

		String s;

		Scanner in = new Scanner(System.in);

		System.out.println("enter the no. of students");

		c=in.nextInt();

		for(i=0;i<c;i++)

		{

			System.out.println("Enter an marks");

			a = in.nextInt();

			if(0<=a && a<=24){c024+=1;}

			else if(25<=a && a<=49){c2549+=1;}

			else if(50<=a && a<=74){c5074+=1;}

			else if(75<=a && a<=99){c7599+=1;}

			else if(100<=a && a<=124){c100124+=1;}

			else if(125<=a && a<=149){c125149+=1;}

			else if(150<=a && a<=174){c150174+=1;}

			else if(175<=a && a<=200){c175200+=1;}

		}

		System.out.println(" marks 0 to 24="+c024+" marks 25 to 49="+c2549+" "

+ " marks 50 to 74="+c5074+" marks 75 to 99 "+c7599

+" marks 100 to 124="+c100124+" marks 125 to 149="+c125149+

" marks 150 to 174="+c150174+" marks 175 to 200"+c175200);



	}

}

View comments (2) 
More Answers
FlexibleLion7482
FlexibleLion7482 answered this Was this answer helpful?

		0
		0
		1,291 answers
		import java.io.*;

import java.util.Scanner;



public class ArithematicProgression{



	static int[] count=new int[8];



	public static void main(String[] args) throws IOException {



		// TODO Auto-generated method stub



		file_handle();



		output();



	}





	private static void output() {



		// TODO Auto-generated method stub



		int i;



		for(i=0;i<8;i++)



			System.out.println(count[i]);



	}





	public static void file_handle() throws IOException {



		// TODO Auto-generated method stub

		int val;

		for(int i = 0;i<8;i++)

			count[i]=0;

		Scanner text = new Scanner(new File("./file.txt"));

		while(text.hasNextInt()){

			val = text.nextInt();

			System.out.println(val);

			do_val(val);

		}



	}





	public static void do_val(int val) {



		// TODO Auto-generated method stub



		int choice=0;



		System.out.println(val);

		if(val>=0&&val<=24)

		{

			choice=1;

		}

		else if(val>=25&&val<=29)

		{

			choice=2;

		}

		else if(val>=30&&val<=54)

		{

			choice=3;

		}

		else if(val>=55&&val<=79)

		{

			choice=4;

		}

		else if(val>=80&&val<=104)

		{

			choice=5;

		}

		else if(val>=105&&val<=129)

		{

			choice=6;

		}

		else if(val>=130&&val<=154)

		{

			choice=7;

		}

		else if(val>=155&&val<=179)

		{

			choice=8;

		}

		switch(choice)

		{

		case 1:count[0]=count[0]+1;

		break;

		case 2:count[1]=count[1]+1;

		break;

		case 3:count[2]=count[2]+1;

		break;

		case 4:count[3]=count[3]+1;

		break;

		case 5:count[4]=count[4]+1;

		break;

		case 6:count[5]=count[5]+1;

		break;

		case 7:count[6]=count[6]+1;

		break;

		case 8:count[7]=count[7]+1;

		break;

		}

	}





}