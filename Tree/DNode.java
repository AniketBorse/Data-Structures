public class DNode {
	int data;
	DNode left; // Self Reference
	DNode right;
	
	DNode(int data){
		this.data = data;
		this.left = this.right =  null; // address of other node
	}
}
