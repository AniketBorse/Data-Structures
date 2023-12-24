public class CNode {
	
	CNode next;
	
	int Id, Salary;
	String Name, Gender;
	
	CNode(String Name, int Salary, String Gender){
		this.Name = Name;
		this.Salary = Salary;
		this.Gender = Gender;
	}
}
