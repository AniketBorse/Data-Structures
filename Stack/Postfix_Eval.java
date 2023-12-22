import java.util.Scanner;
import java.lang.Math;

public class Postfix_Eval {
	int stack[];
	int tos;
	int MaxSize;
	
	void createStack(int size) {
		stack = new int[size];
		MaxSize = size;
		tos = -1;
	}
	
	void push(int i) {
		++tos;
		stack[tos] = i;
	}
	
	int pop() {
		int temp = stack[tos];
		tos--;
		return temp;
	}
	
	int peek() {
		return stack[tos];
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
		System.out.println("Enter Infix Expression");
		String exp = sc.nextLine();
		Postfix_Eval pr = new Postfix_Eval();
		pr.createStack(exp.length());
		for(int i = 0; i<exp.length(); i++) {
			char ch = exp.charAt(i);
			if(ch >= '0' && ch <='9') {
				pr.push(ch);
			}
			else {
				int op2 = Character.getNumericValue(pr.peek());
				pr.pop();
				int op1 = Character.getNumericValue(pr.peek());
				pr.pop();
				
				switch(ch) {
					case '+':
						pr.push(op1+op2);
						break;

					case '-':
						pr.push(op1-op2);
						break;

					case '*':
						pr.push(op1*op2);
						break;

					case '/':
						pr.push(op1/op2);
						break;

					case '^':
						pr.push((int)Math.pow(op1, op2));
						break;
				}
				System.out.println(pr.peek());
			}
		}
	}
}