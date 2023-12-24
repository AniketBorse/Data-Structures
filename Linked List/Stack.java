import java.util.Scanner;

public class Stack {
	Node tos;
	
	void createStack() {
		tos = null;//tos is never created but assigned as per need
		//The 1st node is called as tos
	}
	
	void push(int e) {
		Node n = new Node(e);
		if(tos == null) 
			tos = n;
		else
		{
			n.next = tos; //1
			tos = n; //2
		}
		System.out.println("Pushed");
	}
	
	int pop() {
		if(tos == null) {
			System.out.println("Empty Stack");
			return 0;
		}
		else
		{
			Node t = tos; //1
			tos = tos.next; //2
			System.out.println(t.data + " deleted"); // Automatically done by GC
			return t.data;
		}
	}
	
	void printList(){
		if(tos == null) 
			System.out.println("Empty List");
		else {
			Node t = tos;
			while(t != null) {
				System.out.print("| "+t.data+" |->");
				t = t.next;
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack ll = new Stack();
		int ch;
		do {
			System.out.println("1. Push\n2. Pop\n3. Print\n0. Exit");
			ch = sc.nextInt();
			switch(ch) {
				case 1:
					System.out.println("Enter Element:");
					int nl = sc.nextInt();
					ll.push(nl);
					System.out.println("Pushed "+nl);
					break;
				case 2:
					System.out.println("Popped "+ll.pop());
					break;
				case 3:
					ll.printList();
					break;
				
				case 0:
					System.out.println("Process Exited");
					break;
				default:
					System.out.println("Wrong Choice");	
					break;
			}
		}
		while(ch!=0);
	}
}
