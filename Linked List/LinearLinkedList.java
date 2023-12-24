import java.util.Scanner;

public class LinearLinkedList {
	Node root;
	
	void createList() {
		root = null;//root is never created but assigned as per need
		//The 1st node is called as root
	}
	
	void insertLeft(int e) {
		Node n = new Node(e);
		if(root == null) 
			root = n;
		else
		{
			n.next = root; //1
			root = n; //2
		}
		System.out.println("Inserted");
	}
	
	void insertRight(int e) {
		Node n = new Node(e);
		if(root == null) 
			root = n;
		else
		{
			Node t = root; //1
			while(t.next!=null) //2
				t = t.next;
			t.next = n; //3
		}
		System.out.println("Inserted");
	}
	
	void deleteLeft() {
		if(root == null) 
			System.out.println("Empty List");
		else
		{
			Node t = root; //1
			root = root.next; //2
			System.out.println(t.data + " deleted"); // Automatically done by GC
		}
	}
	
	void deleteRight() {
		if(root == null) 
			System.out.println("Empty List");
		else
		{
			Node t = root; //1
			Node t2 = t;//1
			while(t.next !=null) //2
			{
				t2 = t;
				t = t.next;
			}
			if(root == t) //Only one node
			{ 
				root = null; //manual reset
			}
			t2.next = null; //3
			System.out.println(t.data + " deleted");
		}
	}
	
	void printList(){
		if(root == null) 
			System.out.println("Empty List");
		else {
			Node t = root;
			while(t != null) {
				System.out.print("| "+t.data+" |->");
				t = t.next;
			}
		}
		System.out.println();
	}
	
	void SearchList(int k){
		if(root == null) 
			System.out.println("Empty List");
		else {
			Node t = root;
//			while(t != null) {
//				if(k == t.data)
//				{
//					System.out.println("Key found " + k);
//					break;
//				}
//				t = t.next;
//			}
//			if(t == null) {
//				System.out.println("Key Not Found");
//			}
			
			while(t != null && k != t.data) // Reduction in previous code
				t = t.next;
			if(t == null) 
				System.out.println("Key Not Found");
			else
				System.out.println("Key Found " + k);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinearLinkedList ll = new LinearLinkedList();
		int ch;
		do {
			System.out.println("1. Insert Left\n2. Insert Right\n3. Delete Left\n4. Delete Right\n5. Print Linked List\n6. Search Element\n0. Exit");
			ch = sc.nextInt();
			switch(ch) {
				case 1:
					System.out.println("Enter Element:");
					int nl = sc.nextInt();
					ll.insertLeft(nl);
					System.out.println("Inserted "+nl+" at Left");
					break;
				case 2:
					System.out.println("Enter Element:");
					int nr = sc.nextInt();
					ll.insertRight(nr);
					System.out.println("Inserted "+nr+" at Right");
					break;
				case 3:
					ll.deleteLeft();
					break;
				case 4:
					ll.deleteRight();
					break;
				case 5:
					System.out.println("Printing List");
					ll.printList();
					break;
				case 6:
					System.out.println("Enter Key:");
					int sl = sc.nextInt();
					ll.SearchList(sl);
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
		sc.close();
	}
}
