import java.util.Scanner;

public class DescPriorityQueue {
	int front, rear, MaxSize, queue[];
	
	void createQueue(int size) {
		MaxSize = size;
		queue = new int[MaxSize];
		front = 0;
		rear = -1;
	}
	
	void enqueue(int e) {
		++rear;
		queue[rear] = e;
		for(int i = front; i<rear; i++) {
			for(int j = front; j<rear; j++) {
				if(queue[j]<queue[j+1]) {
					int temp = queue[j];
					queue[j] = queue[j+1];
					queue[j+1] = temp;
				}
			}
		}
	}
	
	boolean isfull() {
		if(rear == MaxSize-1) 
			return true;
		else 
			return false;
	}
	
	int dequeue() {
		int temp = queue[front];
		++front;
		return temp;
	}
	
	boolean isempty() {
		if(rear < front) 
			return true;
		else 
			return false;
	}
	
	void printQueue() {
		for(int i = front; i<=rear; i++) {
			System.out.println(queue[i]);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Size of Queue: ");
		int size = sc.nextInt();
		DescPriorityQueue obj = new DescPriorityQueue();
		obj.createQueue(size);
		int ch;
		do {
			System.out.println("1. Enqueue\n2. Dequeue\n3. Print\n0. Exit\n");
			ch = sc.nextInt();
			switch(ch) {
				case 1:
					if(!obj.isfull()) {
						System.out.println("Enter a Number: ");
						int no = sc.nextInt();
						obj.enqueue(no);
						System.out.println("Enqueued "+no);
					}
					else
						System.out.println("Queue is full");
					break;
					
				case 2:
					if(!obj.isempty()) {
					System.out.println("Dequeued "+obj.dequeue());
					}
					else
						System.out.println("Queue is Empty");
					break;
					
				case 3:
					if(!obj.isempty()) {
						System.out.println("Printing the Elements ");
						obj.printQueue();
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