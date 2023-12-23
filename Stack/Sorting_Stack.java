import java.util.Scanner;

public class Sorting_Stack {

    int stack[], tos, MaxSize;

    void createStack(int size) {
        stack = new int[size];
        MaxSize = size;
        tos = -1;
    }

    void push(int e) {
        tos++;
        stack[tos] = e;
    }

    boolean is_full() {
        return tos == MaxSize - 1;
    }

    boolean is_empty() {
        return tos == -1;
    }

    int pop() {
        int a = stack[tos];
        tos--;
        return a;
    }

    int peek() {
        return stack[tos];
    }

    void sortStack() {
        if (tos == -1)
            return;

        int[] tempStack = new int[MaxSize];
        int tempTop = -1;

        while (!is_empty()) {
            int temp = pop();

            while (tempTop != -1 && tempStack[tempTop] > temp) {
                push(tempStack[tempTop--]);
            }

            tempStack[++tempTop] = temp;
        }

        while (tempTop != -1) {
            push(tempStack[tempTop--]);
        }
    }
    void print_stack() {
        for (int i = tos; i > -1; i--) {
            System.out.println(stack[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of stack");
        int size = sc.nextInt();
        Sorting_Stack obj = new Sorting_Stack();
        obj.createStack(size);
        int ch;
        do {
            System.out.println("\n1. Push\n2. Pop\n3. Peek\n4. Print\n5. Sort\n0. Exit");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    if (!obj.is_full()) {
                        System.out.println("Enter the number");
                        int no = sc.nextInt();
                        obj.push(no);
                        System.out.println("pushed: " + no);
                    } else {
                        System.out.println("Stack is full");
                    }
                    break;

                case 2:
                    if (!obj.is_empty()) {
                        System.out.println("Popped: " + obj.pop());
                    } else
                        System.err.println("Stack is empty");
                    break;

                case 3:
                    System.out.println("This is peek element: " + obj.peek());
                    break;

                case 4:
                    obj.print_stack();
                    break;

                case 5:
                    obj.sortStack();
                    System.out.println("Stack sorted in ascending order");
                    break;

                case 0:
                    System.out.println("Exiting");
                    break;

                default:
                    System.out.println("Wrong Choice");
                    break;
            }

        } while (ch != 0);
    }

    
}