import java.util.Scanner;

public class DoubleEnded {
	int front1, front2, rear1, rear2, MaxSize, queue[], mid;
	
	void createQueue(int size) {
		MaxSize = size;
		queue = new int[size];
		mid = size/2;
		front1 = mid;
		front2 = mid-1;
		rear1 = mid-1;
		rear2 = mid;
	}
	
	void enqueue1(int e) {
		++rear1;
		queue[rear1] = e;
	}
	
	void enqueue2(int e) {
		--rear2;
		queue[rear2] = e;
	}
	
	boolean isfull1() {
		if(rear1 == MaxSize-1) 
			return true;
		else 
			return false;
	}
	
	boolean isfull2() {
		if(rear2 == 0) 
			return true;
		else 
			return false;
	}
	
	int dequeue1() {
		int temp = queue[front1];
		++front1;
		return temp;
	}
	
	int dequeue2() {
		int temp = queue[front2];
		--front2;
		return temp;
	}
	
	boolean isempty1() {
		if(rear1 < front1) 
			return true;
		else 
			return false;
	}
	
	boolean isempty2() {
		if(rear2 > front2) 
			return true;
		else 
			return false;
	}

	void print1() {
		for(int i = front1; i<=rear1; i++) {
			System.out.println(queue[i]);
		}
	}
	
	void print2() {
		for(int i = front2; i>=rear2; i--) {
			System.out.println(queue[i]);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Size of Queue: ");
		int size = sc.nextInt();
		DoubleEnded obj = new DoubleEnded();
		obj.createQueue(size);
		int ch;
		do {
			System.out.println("1. Enqueue_left\n2. Enqueue_right\n3. Dequeue_left\n4. Dequeue_right\n5. Print_left\n6. Print_right\n0. Exit\n");
			ch = sc.nextInt();
			switch(ch) {
				case 1:
					System.out.println("Enqueue Left");
					if(!obj.isfull1()) {
						System.out.println("Enter a Number: ");
						int no = sc.nextInt();
						obj.enqueue1(no);
						System.out.println("Enqueued "+no);
					}
					else
						System.out.println("Queue is full");
					break;
					
				case 2:
					System.out.println("Enqueue Right");
					if(!obj.isfull2()) {
						System.out.println("Enter a Number: ");
						int no = sc.nextInt();
						obj.enqueue2(no);
						System.out.println("Enqueued "+no);
					}
					else
						System.out.println("Queue is full");
					break;
					
				case 3:
					System.out.println("Dequeue Left");
					if(!obj.isempty1()) {
						System.out.println("Dequeued Left "+ obj.dequeue1());
					}
					else
						System.out.println("Queue is Empty");
					break;
					
				case 4:
					System.out.println("Dequeue Right");
					if(!obj.isempty2()) {
						System.out.println("Dequeued Left "+ obj.dequeue2());
					}
					else
						System.out.println("Queue is Empty");
					break;
					
				case 5:
					if(!obj.isempty1()) {
						System.out.println("Printing Left ");
						obj.print1();
					}
					else
						System.out.println("Queue is Empty");
					break;
					
				case 6:
					if(!obj.isempty1()) {
						System.out.println("Printing Right ");
						obj.print2();
					}
					else
						System.out.println("Queue is Empty");
					break;
				
				case 0:
					System.out.println("Process Exited");
					break;
					
				default:
					System.out.println("Wrong Choice");	
			}
		}
		while(ch != 0);
	}
}