public class DoublyNameCardList {
	
	private NameCard head;
	private NameCard tail;
	int count;
	
	
	//adds node to end
	public void addTail(NameCard nc){
		
		System.out.println("\nAdding new node to end of list.\n");
		
		//if the list has zero nodes, the new node is both the head and the tail so both head and tail are set to the new node
		if(count == 0){
			head = nc;
			tail = nc;
		}
		//if the list has at least one node
		else{
			tail.setNext(nc); //make tail node point to nc as next	
			nc.setPrev(tail); //make former tail point back to nc as previous
			tail = nc; //new node nc is now tail of list
		}
		count++; //increase count of nodes in list
	}
	
	//adds node to head
	public void addHead(NameCard nc){
		
		System.out.println("\nAdding new node to begining of list.\n");
		
		//if the list has zero nodes, the new node is both the head and the tail so both head and tail are set to the new node
		if(count == 0){
			head = nc;
			tail = nc;
		}
		//if list has at least one node
		else{
			nc.setNext(head); //make nc node point to current head node as next
			head.setPrev(nc); //make current head node point to nc node as previous
			head = nc; //nc is now head node
		}
		count++;
	}
	
	//adds new node after given index
	public void add(int index, NameCard nc){
		
		System.out.println("\nAdding new node after index: " + index + ".\n");
		
		if(index == 0){
			this.addHead(nc); //if node index is zero, call method addHead() to add nc to head of list
		}
		else if(index  >= count){
			this.addTail(nc); //if node index is equal to or greater than the total number of nodes, call method addEnd() and add nc to tail of list
		}
		else{ //ends with nodes in this order: current <-> nc <-> nextNC 
						
			
			NameCard current = this.get(index); //calls method get() with index value, sets node at this index as node current
			
			NameCard nextNC = current.getNext(); //makes new node nextNC equal to node after node current
			
			
			nc.setNext(nextNC); //make nc node point to nextNC as next 
			
			nc.setPrev(current); //make nc node point to node current as prev
			
			current.setNext(nc); //make node current point to nc as next
			 
			nextNC.setPrev(nc); //make nextNC point to nc as prev
			
			count++;
					
		}
	}
	
	//get NameCard from given index
	public NameCard get(int index){
		
		if(index >= count){ //if the index provided is equal to or greater than the number of nodes in list, returns null as index because that index does not exist
			return null;
		}
		
		NameCard n = head; //makes new node n, sets it at head 
		
		int i = 0; 
		while(i < index){ //iterates through node list until reaching the node equal to index
			
			n = n.getNext(); //sets new node n as the node after the index
			i++;
		}
		return n; //returns new node n at index+1
	}
	
	//counts number of nodes in list
	public int size(){
		
		return count;
	}
	
	//remove node
	public boolean delete(int index){
		
		System.out.println("\nDeleting node at index: " + index + "\n");
		
		if(index < 0 || index >= size()){ //if index is less than or greater than or equal to number of nodes, then the node does not exist
			return false;
		}
		
		NameCard current = head; //makes new node current set as head
		
		for(int i = 0; i < index-1; i++){ //iterates through node list from 0 to index-1 similar to arrays
		
			if(current.getNext() == null){ //if node at index-1 does not have a next then node at index does not exist
				return false;
			}
			current = current.getNext(); //if node at index-1 does have a next, then current is set as node at index
		}
		current.setNext(current.getNext().getNext()); //node at index-1 points to index+1
		current.setPrev(current.getPrev().getPrev()); //node at index+1 points to index-1
		count--; 
		return true;
	}
	
	//remove head node
	public void deleteHead(){
		
		System.out.println("\nDeleting node at begining of list.\n");
		
		if(count == 0){ //if count is zero, the list is empty or doesnt exist
			System.out.println("\nThe list is empty.");
		}
		else{
			head = head.getNext(); //head.next is now head
			count--;
		}
	}
	
	//delete tail node
	public void deleteTail(){

		System.out.println("\nDeleting node to end of list.\n");
		
		if(count == 0){
			System.out.println("\nThe list is empty.\n");
		}
		else if(count == 1){ //if list has only one node, call method deleteHead()
			this.deleteHead();
		}
		else{
			NameCard prevTail = tail.getPrev(); //set new node prevTail as the node before the tail
			tail = prevTail; //make new node prevTail new tail
		}
		count--;
	}
	
	//check if node already exits
	public boolean exist(NameCard nc){
		
		System.out.println("\nChecking if node exists.\n");
		
		NameCard check = head; //set new node check as head
		
		for(int i = 0; i < count; i++){ //iterate through node list from zero to count-1
			
			//if any node in list is has same name and age and company as given node, return true
			if(nc.getName().equals(check.getName())){ 
				
				if(nc.getAge() == check.getAge()){
				
					if(nc.getCom().equals(check.getCom())){
						return true;
					}
				}
			}
		}
		return false; //if any node in list has same name or same age or same company BUT ALL ARE NOT SAME or is completely different, return false
	}

	
}