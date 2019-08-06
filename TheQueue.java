import java.util.Arrays;

//QUEUES are FIRST IN FIRST OUT
public class TheQueue {

	private String[] queueArray;
	private int queueSize;
	
	private int front, numberOfItems, rear = 0;
	
	TheQueue(int size){
		
		queueSize = size;
		
		queueArray = new String[size];
		
		Arrays.fill(queueArray, "-1");
		
	}
//	public void insert(String input) {
//		
//		if(numberOfItems + 1 <= queueSize) {
//			
//			queueArray[rear] = input;
//			
//			rear++;
//			
//			numberOfItems++;
//			
//			displayTheQueue();
//			
//			System.out.println("INSERT: " + input + " was added to the queue\n");
//			
//		}else {
//			System.out.println("The queue is full");
//			
//		}
//	}
	
	public void insertMany(String multipleValues) {
		
		String[] tempString = multipleValues.split(" ");
		
		for(int i = 0; i < tempString.length; i++) {
		
			insert(tempString[i]);
		}
	}
	public void insert (String value){
		
		System.out.println("Queue before entereing : " + value);
		
		displayTheQueue();
		
		if (numberOfItems+1<queueSize){
		
			if (rear==queueSize)rear=0;
		
			queueArray[rear]=value;
		
			rear++;
		
			numberOfItems++;
		
		}
		
		else{System.out.println("Sorry queue is full");}
		
		System.out.println("Status of queue after entering "+value);
		
		displayTheQueue();
		
	}
	
	public void priorityInsert(String input) {
		
		int i;
		
		if(numberOfItems == 0) {
			
			insert(input);
			
			
			
		}else {
			
			for(i = numberOfItems-1; i >= 0; i--) {
				
				if(Integer.parseInt(input) > Integer.parseInt(queueArray[i])) {
				
					queueArray[i+1] = queueArray[i];
					
				}else break;
				
			}
			
			queueArray[i+1] = input;
			
			rear++;
			
			numberOfItems++;
			
			displayTheQueue();
			
		}
	}
	public void remove() {
		
		if(numberOfItems >0) {
		
			System.out.println("REMOVE: " + queueArray[front] + " was removed from the queue\n");
		
			queueArray[front] = "-1";
			
			front++;
			
			numberOfItems--;
		
		} else {
			
			System.out.println("Sorry but the queue is empty");
		}
	}
	public void peek() {
		
		System.out.println("The first element is " + queueArray[front]);
		
	}
	public void displayTheQueue() {
		
		for(int i = 0; i < 61; i++) System.out.print("-");
		
		System.out.println();
		
		for(int i = 0; i < queueSize; i++) {
			
			System.out.format("| %2s " + " ", i);
			
			
		}
		
		System.out.println("|");
		
		for(int i = 0; i < 61; i++)System.out.print("-");
		
		System.out.println();
		
		for(int i = 0; i < queueSize; i++) {
			
			if(queueArray[i].equals("-1")) System.out.print("|     ");
			
			else System.out.print(String.format("| %2s "+ " ", queueArray[i]));
			
			
		}
		
		System.out.println("|");
		
		for(int i = 0; i < 61; i++)System.out.print("-");
		
		System.out.println();
		
		 int spacesBeforeFront = 3*(2*(front+1)-1);
		
		 for(int k = 1; k < spacesBeforeFront; k++) {
			 System.out.print(" ");
		 }

		
		System.out.print("F");
	
		int spacesBeforeRear = (2*(3*rear)-1) - (spacesBeforeFront);

		
		for(int l = 0; l < spacesBeforeRear; l++) {
			System.out.print(" ");
		}

	
		System.out.print("R");
		
		System.out.println("\n");
		
	}
	public static void main(String[] args) {
		
		TheQueue theQueue = new TheQueue(10);
		
		
		theQueue.priorityInsert("16");
		theQueue.insert("25");
		
		theQueue.insertMany("12 14 15 34 11");
		
		theQueue.remove();
		
		
		
	}
}
