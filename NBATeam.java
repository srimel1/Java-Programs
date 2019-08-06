import java.util.ArrayList;

import java.util.Collections;

public class NBATeam {

String name;

int age;

ArrayList<String> nameArray = new ArrayList<>();

ArrayList<Integer> ageArray = new ArrayList<>();

private String maxAge, minAge, avgAge, numOfPlayer;

public NBATeam(String a) {

}

public void addAPlayer(String name, int age) {

	nameArray.add(name);

	setName(name);

	ageArray.add(age);

	maxAge = Collections.max(ageArray)+"";

	minAge = Collections.min(ageArray)+"";

	avgAge = ( Integer.parseInt(maxAge) + Integer.parseInt(minAge))/ 2 +"";

	numOfPlayer = nameArray.size()+"";

}

public String getName() {

	return name ;

}

public void setName(String name) {

	this.name = name;

}

public int getAge() {

		return age;

}

public void setAge(int age) {

	this.age = age;

}

public String getMaxAge() {

return maxAge;

}

public void setMaxAge(String maxAge) {

	this.maxAge = maxAge;

}

public String getMinAge() {

	return minAge;

}

public void setMinAge(String minAge) {

	this.minAge = minAge;

}

public String getAvgAge() {

	return avgAge;

}

public void setAvgAge(String avgAge) {

	this.avgAge = avgAge;

}

public String getNumOfPlayer() {

	return numOfPlayer;

}

public void setNumOfPlayer(String numOfPlayer) {

	this.numOfPlayer = numOfPlayer;

}

}

//NBAcourtPanel


