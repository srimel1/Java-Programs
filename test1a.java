public class test1a {
	
	public static void printList(DoublyNameCardList list) {
		
		for(int i = 0; i < list.count; i++) {
			System.out.println("Name Card " + (i) + " is: " + list.get(i));
		}
		System.out.println();
	}
	
	public static void printReverseList(DoublyNameCardList list) {
		
		for(int i = list.count-1; i >= 0; i--) {
			System.out.println("Name Card " + (i) + " is: " + list.get(i));
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		DoublyNameCardList myList = new DoublyNameCardList();
		
		NameCard nc1 = new NameCard("Stephanie", 32, "Georgia State");
		myList.addHead(nc1);
		printList(myList);
	
		
		NameCard nc2 = new NameCard("Brian", 31, "Georgia Tech");
		myList.addTail(nc2);
		printList(myList);
	
		
		NameCard nc3 = new NameCard("Chris", 22, "GSU");
		myList.addTail(nc3);
		printList(myList);
	
		
		NameCard nc4 = new NameCard("Togepi", 23, "Niantic");
		myList.addHead(nc4);
		printList(myList);

		
		NameCard nc5 = new NameCard("Merill", 26, "Niantic");
		myList.add(1, nc5);
		printList(myList);
		
		
		System.out.println("There are " + myList.count + " nodes in myList.\n");
		printList(myList);
		printReverseList(myList);
		
		
		myList.deleteHead();
		printList(myList);
		
		
		myList.deleteTail();
		printList(myList);
		
		
		myList.delete(1);
		printList(myList);
		
		
		NameCard nc6 = new NameCard("Stephanie", 32, "Georgia Tech");
		System.out.println(myList.exist(nc6) + "\n");
	
		printList(myList);
		
		
		
		
		
		
		
		
		
		
		
	
	
	}
}