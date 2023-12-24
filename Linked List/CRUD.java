import java.util.Scanner;

public class CRUD {
	CNode root;
	
	void createTable() {
		root = null;//root is never created but assigned as per need
		//The 1st CNode is called as root
	}
	
	void Update(String nm, int sal, String gen) {
		CNode n = new CNode(nm, sal, gen);
		if(root == null) {
			root = n;
			root.Id = 1;
		}
		else
		{
			CNode t = root; //1
			t.Id = 1;
			while(t.next!=null) //2
			{
				t = t.next;
				t.Id = t.Id+1;
			}
			t.next = n; //3
			
		}
		System.out.println("Updated");
	}
	
	void Read(int id){
		if(root==null)
            System.out.println("Empty List");       
		else{   
			CNode t=root;
			while(t!=null && id!=t.Id)
				t=t.next;
       
			if(t==null)
				System.out.println("ID"+ id +" not found in list");
			else
				System.out.println(t.Id + " " +t.Name + " " +t.Salary + " " +t.Gender );
		}
	}
	
	void Delete(int id)
	{  if(root==null)
	            System.out.println("Empty List");       
	   else//not empty
	   {   
	       CNode t=root;
	       CNode t2=root;
	       while(t!=null && id!=t.Id)
	       {
	    	   t2=t;       
	    	   t=t.next;
	       }
	       if(t==null)//not found
	    	   System.out.println(id+" not found in list");
	       else//found
	       {
	    	   System.out.println(id+" found in list");
	           if(t==root)//case1:left most
	        	   root=root.next;
	           else if(t.next==null)//case 2:right most
	        	   t2.next=null;
	           else//case 3:in between
	        	   t2.next=t.next;
	           System.out.println(t.Id+" deleted");     
            }     
        }
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CRUD c = new CRUD();
		int ch;
		do {
			System.out.println("1. Create\n2. Update\n3. Read\n4. Delete\n0. Exit");
			ch = sc.nextInt();
			switch(ch) {
				case 1:
					c.createTable();
					System.out.println("Table Created");
					break;
				case 2:
					System.out.print("Enter Name: ");
					String nm = sc.next();
					System.out.println();

					System.out.print("Enter Salary: ");
					int sal = sc.nextInt();
					System.out.println();

					System.out.print("Enter Gender: ");
					String gen = sc.next();
					System.out.println();

					c.Update(nm, sal, gen);
					System.out.println("Updated Table");
					break;
				case 3:
					System.out.println("Enter ID:");
					int n = sc.nextInt();
					c.Read(n);
					break;
				case 4:
					System.out.println("Enter ID:");
					int no = sc.nextInt();
					c.Delete(no);
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
