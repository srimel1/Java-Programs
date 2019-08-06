import java.util.Arrays;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
public class NBATeam{

String name;
int age;
public ArrayList<String>nameArray = new ArrayList<>();
public ArrayList<Integer>ageArray = new ArrayList<>();

private String maxAge, minAge, avgAge, numOfPlayer;

public NBATeam(String s){
}

public void addAPlayer(String name, int age)
{
nameArray.add(name);
ageArray.add(age);
maxAge = Collections.max(ageArray)+"";
minAge = Collections.min(ageArray)+"";
avgAge = (Integer.parseInt(maxAge) + Integer.parseInt(minAge))/2 + "";
numOfPlayer = nameArray.size()+"";

}

public String getName()
{
return name;
}
public void setName(String name)
{
this.name = name;
}

public int getAge()
{
return age;
}
public void setAge(int age)
{
this.age = age;
}

public String getMaxAge()
{
return maxAge;
}

public void setMaxAge()
{
this.maxAge = maxAge;
}

public String getMinAge()
{
return minAge;
}

public String getAverage()
{
return avgAge;
}

public String getNumOfPlayer()
{
return numOfPlayer;
}

}


//public class NBATeam {
//	private String teamName;
//	private int nWin;
//	private int nLoss;
//	private int numPlayer;
//	
//	private String [] playerArray = new String [numPlayer];
//	
//	//constructors
//	public NBATeam(String teamName){
//		this.teamName = teamName;
//	}
//	
//	//instance methods
//	public int nWin(){
//		//returns number of wins
//		return nWin;
//	}
//	public int nLoss(){
//		//returns number of loss
//		return nLoss;
//	}
//	public String getTeamName(){		
//		//gets team's Name
//		return teamName;
//	}
//	
//	public void setWin(int win){	
//		//adds to nWin if game is won
//		nWin = win;
//	}
//	public void setLoss(int loss){
//		//adds nLoss if game is lost
//		nLoss = loss;
//	}
//	
//	public void winAGame(NBATeam team2){
//		//stimulate the playing of a game
//		nWin++;
//		team2.setLoss(team2.nLoss()+1);
//	}
//	
//	public void addAplayer(String player){	
//		String temp[] = playerArray;
//		playerArray = Arrays.copyOf(temp, temp.length + 1);
//		playerArray[numPlayer] = player;
//		numPlayer++;
//	}
//	
//	public String toString(){		
//		//prints final status game
//		return teamName + Arrays.toString(playerArray)+ "Wins: " + nWin + 
//				" Loses: " + nLoss;
//	}
//	
//}