import java.util.Scanner;

public class QueueUsingStack
{
	int tos1,maxsize,stack1[],stack2[],tos2;
	void createQueue(int size)
	{
		stack1=new int[size];
		stack2=new int[size];
		maxsize=size;
		tos1=-1;
		tos2=-1;
	}
	
	void enQueue(int k)
	{
		stack1[++tos1]=k;
	}
	
	boolean is_full()
	{
		if(tos1==maxsize-1)
		    return true;
		else
			return false;
	}
	
	int deQueue()
	{
		while(tos1>-1)
		{
			stack2[++tos2]=stack1[tos1--];
		}
		int pop= stack2[tos2--];
		while(tos2>-1)
		{
			stack1[++tos1]=stack2[tos2--];
		}
		
		return pop;
	}
	
	boolean is_empty()
	{
		if(tos1==-1)
		    return true;
		else
			return false;	
	}
	
	void print()
	{
		if(tos1==-1)
			System.out.println("Que is empty");
		else
		{
			while(tos1>-1)
			{
				stack2[++tos2]=stack1[tos1--];	
				
			}
			while(tos2>-1)
			{
				System.out.println(stack2[tos2--]);
			}
		}	
	}
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		System.out.println("enter size of Queue");
		int size=in.nextInt();	
		
		QueueUsingStack s1=new QueueUsingStack();
		s1.createQueue(size);
		
		int ch;
		do
		{
			System.out.println("\n1:enQueue\n2:deQueue\n3:PRINT\nENTER 0 to exit");
			ch=in.nextInt();
			
			switch(ch)
			{
				case 1: if(!s1.is_full())
				{
					System.out.println("Enter a number");
					int no=in.nextInt();
					s1.enQueue(no);
					System.out.println("enQueued "+no);
				}
				else 
					System.out.println("Queue is full");
				break;
					
				case 2:
					if(!s1.is_empty())
					{
						int no=s1.deQueue();
					System.out.println("DeQueued "+no);
					}
					else
						System.out.println("Queue is empty");
					break;
				case 3:
					if(!s1.is_empty())
					{
						s1.print();
					}
					else
						System.out.println("Queue is empty");
					break;
				case 0:
					System.out.println("Process Exited");
					break;
				default:
					System.out.println("Wrong Choice");		
			}
		}
		while(ch!=0);
	}
}