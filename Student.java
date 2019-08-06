
public class Student{
	private String name;
	private int age;
	public Student(String n, int a) {
		name = n; 
		age = a;
	}
	public String getName() {
		return name;
	}
	public static void displayStudent(LinkedList<Node> n, int i) {
		Node temp = n.getFirst();
		int j = 0;
		while(j<i) {
			temp = temp.next;
			j++;
		}
		System.out.println("The student at position "+i+" is student " +temp.student.getName());
	}
	public static void main(String[] args) {
		LinkedList<Student> ll = new LinkedList<Student>();
		Student steph = new Student("Stephanie", 32);
		ll.addFirst(steph);
	}
}
 class Node {
	Student student;
	Node next;
}