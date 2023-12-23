import java.util.Scanner;

public class Sliding_Window {
	int front, rear, MaxSize, queue[], max;
	
	void createQueue(int size) {
		MaxSize = size;
		queue = new int[MaxSize];
		front = 0;
		rear = -1;
	}
	
	void enqueue(int e) {
		++rear;
		queue[rear] = e;
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
	
	void sliding_window(int size) {
		if((rear - front)+1<size) {
			max = queue[front];
			for(int i = front + 1; i <= rear; i++) {
				if(queue[i]>max) {
					max = queue[i];
				}
			}
			System.out.println(max);
		}
		else {
			for(int i = front; i <= rear-size+1; i++) {
				max = queue[i];
				for(int j = i+1; j<=i+size-1; j++) {
					if(queue[j]>max) {
						max = queue[j];
					}
				}
				System.out.println(max);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Size of Queue: ");
		int size = sc.nextInt();
		Sliding_Window obj = new Sliding_Window();
		obj.createQueue(size);
		int ch;
		do {
			System.out.println("1. Enqueue\n2. Dequeue\n3. Print\n4. Sliding Window\n0. Exit\n");
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
					
				case 4:
					if(!obj.isempty()) {
						System.out.println("Sliding Window Output");
						System.out.println("Enter size of window");
						int sz = sc.nextInt();
						obj.sliding_window(sz);
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