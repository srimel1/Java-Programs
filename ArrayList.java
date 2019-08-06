import java.util.Arrays;
import java.util.Random;

public class ArrayList {
	private Object array[]; //"ArrayList" itself
	private int capacity;	//how large the list is, not how many elements
	int num;				//amount of objects within the array
	static final int DEFAULT = 10;
	
	/*CONSTRUCTORS*/
	public ArrayList(){
		array = new Object[DEFAULT];
	}
	
	public ArrayList(int capacity){
		this.capacity = capacity;
		array = new Object[capacity];		//full of null values
		num = 0;
	}
	
	/*SETTERS*/
	//Takes in an object and places the value at the end of the ArrayList
	public void add(Object obj){
		if (num == capacity) {
	 	 	 Object[] tempArray = new Object[num + 1];
			 for (int i = 0; i < num; i++) {
	 	 	 	 tempArray[i] = array[i];
			 }
			 array = tempArray;
			 capacity = capacity + 1;
	 	 }
	 	 array[num] = obj;
	 	 num++;
	}
	
	//Takes in an object and places th value at a given location in ArrayList
	public void add(int index, Object obj){
		Object[] tempArray = new Object[capacity++];
		for (int i = 0; i < index; i++){
			tempArray[i] = array[i];
		}
		tempArray[index] = obj;
		for(int i = index+1; i < array.length; i++){
			tempArray[i] = array[i - 1];
		}
		array = tempArray;
	}
	
	//Takes in an object and removes the 1st occurrence of an object starting from location 0
	public void remove(Object obj){
		  Object[] tempArray = new Object[capacity--];
		     int k = 0;
		     for(int i = 0; i < array.length; i++) {
		        if(array[i] != obj)
		           tempArray[k++] = array[i];
		     }
		     array = tempArray;
		  }
	
	//Takes an array in and shuffles elements within an ArrayList
	public void shuffle(){
		int index;
		Object temp;
		
		Random rand = new Random();
		for (int i = array.length - 1; i > 0; i--){
			index = rand.nextInt(i + 1);
			temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	}
	
	/*GETTERS*/
	//Takes in an interger for the index and retrieves then returns a value from a given location
	public Object get(int index){
		Object value = array[index];
		return value;
	}
	
	//Returns the number of elements currently in the ArrayList
	public int size(){
		int size = 0;
		for (int i = 0; i < array.length; i++){
			if(array[i] != null){
				size++;
			}
		}
		return size;
	}
	
	//Test if ArrayList is empty
	public boolean isEmpty(){
		if (array == null){
			return true;
		}
		return false;
	}
	
	//Checks if particular object already exist in ArrayList
	public boolean isIn(Object obj){
		if(find(obj) == -1){
			return false;
		}
		return true;
	}
	
	//Returns the location of the first occurrence of an Object
	public int find(Object obj){
		for (int i = 0; i < capacity; i++){
			if (array[i].equals(obj)){
				return i;
			}
		}
		return -1;
	}
	
	/**PRINT METHOD***/
	public String toString(){
		return Arrays.toString(array);
	}
}