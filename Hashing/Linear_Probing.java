import java.util.Scanner;
public class Linear_Probing
{
    int hashtable[], maxSize, count;
    
    void init(int size) {
    	maxSize = size;
    	hashtable = new int[maxSize];
    	count = 0;
    	for(int i = 0; i<hashtable.length; i++) {
    		hashtable[i] = -1;
    	}
    }
    
    void printHash() {
    	for(int i = 0; i<hashtable.length; i++)
    		System.out.println(hashtable[i]);
    }
    
    boolean isFull() {
    	if(count == maxSize)
    		return true;
    	else
    		return false;
    }
    
    boolean isEmpty() {
    	if(count == 0)
    		return true;
    	else
    		return false;
    }
    
    void insert(int data) {
    	int index = data%maxSize;
    	
    	if(hashtable[index] == -1) {
    		hashtable[index] = data;
    		System.out.println("Inserted at index "+index);
    		count++;
    	}
    	else {
    		int tindex = index;
    		while(true) {
    			if(hashtable[tindex] == -1) {
    				hashtable[tindex] = data;
    				System.out.println("Inserted at index "+ tindex);
    				break;
    			}
    			tindex = (tindex+1)%maxSize;
    		}
    		count++;
    	}
    }

    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int ch;
        Linear_Probing obj=new Linear_Probing();
        obj.init(10);
        do
        {
            System.out.println("1.Insert in:\n2.Print Hash Table\n0.Exit");
            ch=in.nextInt();
            switch(ch)
            {
                case 1:
                    if(obj.isFull())
                        System.out.println("Hash Table is Full");
                    else
                    {
                        System.out.println("Enter data to hash:");
                         int data=in.nextInt();
                         obj.insert(data);
                    }
                    break;
                    case 2:
                    if(obj.isEmpty())
                        System.out.println("Hash Table is Empty");
                    else
                    {
                        System.out.println("Data in hash:");
                        obj.printHash();
                    }
                    break;
                    case 0:
                        System.out.println("Exiting....tata");
                        break;
                    default:
                        System.out.println("Wrong input");
                        break;
            }
            
        }  while(ch!=0);
    }
}