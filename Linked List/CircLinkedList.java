import java.util.Scanner;

public class CircLinkedList {
	Node root;
	Node last;
	
	void createList() {
		root = null;//root is never created but assigned as per need
		//The 1st node is called as root
		last = null;
	}
	
	void insertLeft(int e) {
		Node n = new Node(e);
		if(root == null) {
			root = n;
			last = n;
			last.next = root;
		}
		else
		{
			n.next = root; //1
			root = n; //2
			last.next = root;//3
		}
		System.out.println("Inserted");
	}
	
	void insertRight(int e) {
		Node n = new Node(e);
		if(root == null) {
			root = n;
			last = n;
			last.next = root;
		}
		else
		{
			last.next = n;
			last = n;
			last.next = root;
		}
		System.out.println("Inserted");
	}
	
	void deleteLeft() {
		if(root == null) 
			System.out.println("Empty List");
		else
		{
			Node t = root; //1
			if(root == last)//single node
			{
				root = last = null;
			}
			else {
				root = root.next; //2
				last.next = root;
			}
			System.out.println(t.data + " deleted"); // Automatically done by GC
		}
	}
	
	void deleteRight() {
		if(root == null) 
			System.out.println("Empty List");
		else
		{
			Node t=root;//1
	        Node t2=t;//1
	        while(t!=last)//2
	        {
	        	t2=t;
	        	t=t.next; 
	        }
	        if(root==last)//only one node
	        {
	        	root=last=null;
	        }//manual reset
	        else
	        {
	        	last=t2;
	            last.next=root;
	        }
	        System.out.println(t.data+" deleted");
		}
	}
	
	void printList(){
		if(root == null) 
			System.out.println("Empty List");
		else {
			Node t = root;
			do {
				System.out.print("| "+t.data+" |->");
				t = t.next;
			}
			while(t != root);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CircLinkedList ll = new CircLinkedList();
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
