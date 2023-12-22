import java.util.Scanner;

public class Reverse {
	int stack[];
	int tos;
	int MaxSize;
	
	void createStack(int size) {
		stack = new int[size];
		MaxSize = size;
		tos = -1;
	}
	
	void push(int e) {
		++tos;
		stack[tos] = e;
	}
	
	int pop() {
		int temp = stack[tos];
		tos--;
		return temp;
	}
	
	boolean is_full() {
		if(tos==MaxSize-1)
			return true;
		else
			return false;
	}
	
	boolean is_empty() {
		if(tos == -1)
			return true;
		else
			return false;
	}
	
	void print_stack() {
		for(int i = tos; i>=0; i--)
			System.out.println(stack[i]);
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size");
		int size = sc.nextInt();
		Reverse obj = new Reverse();
		Reverse rev = new Reverse();
		obj.createStack(size);
		rev.createStack(size);
		
		for(int i = 0; i<size; i++) {
			if(!obj.is_full()) {
				System.out.println("Enter a Number: ");
				int no = sc.nextInt();
				obj.push(no);
				System.out.println("Pushed "+no);
			}
		}
		
		System.out.println("Original Stack Entries are: ");
		while(!obj.is_empty()) {
			int temp = obj.pop();
			System.out.print(temp);
			rev.push(temp);
		}
		
		System.out.println("\nReverse Stack Entries are: ");
		while(!rev.is_empty()) {
			System.out.print(rev.pop());
		}
	}
}