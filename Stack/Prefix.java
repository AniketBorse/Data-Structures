import java.util.Scanner;

public class Prefix {
	char stack[];
	int tos;
	int MaxSize;
	
	void createStack(int size) {
		stack = new char[size];
		MaxSize = size;
		tos = -1;
	}
	
	void push(char e) {
		++tos;
		stack[tos] = e;
	}
	
	char pop() {
		char temp = stack[tos];
		tos--;
		return temp;
	}
	
	char peek() {
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
	
	int precedence(char c) {
		if(c == '^') 
			return 3;
		else if(c == '*' || c == '/')
			return 2;
		else if(c == '+' || c == '-')
			return 1;
		else
			return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Infix Expression");
		String exp = sc.nextLine();
		Prefix pr = new Prefix();
		String pre = "";
		pr.createStack(exp.length());
		for(int i = exp.length()-1; i>=0; i--) {
			char ch = exp.charAt(i);
			if(ch >= 'a' && ch<= 'z' || ch >= 'A' && ch<= 'Z') {
				pre += ch;
			}
			
			else if(ch == ')') {
				pr.push(ch);
			}
			
			else if(ch == '(') {
				while(!pr.is_empty() && pr.peek() != ')') {
					pre+=pr.peek();
					pr.pop();
				}
				if(!pr.is_empty()) {
					pr.pop();
				}
			}
			else {
				while(!pr.is_empty() && pr.precedence(pr.peek())>= pr.precedence(ch)) {
					char temp = pr.pop();
					pre += temp;
				}
				pr.push(ch);
			}
		}
		while(!pr.is_empty()) {
			pre += pr.pop();
		}
		for(int i = pre.length()-1; i>=0; i--) {
			char c = pre.charAt(i);
			System.out.print(c);
		}
	}
}