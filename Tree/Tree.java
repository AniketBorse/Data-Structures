public class Tree {
	DNode root;
	
	void createTree() {
		root = null;
	}
	
	void insert(DNode r, DNode n) {
		if(root == null)
			root = n;
		else {
			if(n.data<r.data) {
				if(r.left == null)
					r.left = n;
				else
					insert(r.left, n);
			}
			else {
				if(r.right == null)
					r.right = n;
				else
					insert(r.right, n);
			}
		}
	}
	

	void inorder(DNode r) {
		if(r!=null) {
			inorder(r.left);
			System.out.print(r.data+" ");
			inorder(r.right);
		}
	}
	
	void preorder(DNode r) {
		if(r!=null) {
			System.out.print(r.data+" ");
			preorder(r.left);
			preorder(r.right);
		}
	}
	
	void postorder(DNode r) {
		if(r!=null) {
			postorder(r.left);
			postorder(r.right);
			System.out.print(r.data+" ");
		}
	}
	
	int getHeight(DNode r) {
		if(r == null) 
			return 0;
		else {
			int right = getHeight(r.right);
			int left = getHeight(r.left);
			return Math.max(right, left)+1;
		}
	}
	
	boolean isBalanced(DNode r) {
		if(r == null) 
			return true;
		else {
			int right = getHeight(r.right);
			int left = getHeight(r.left);
			if(Math.abs(left-right) < 1) // if( left-right == 0 || left-right == -1 || left-right == +1)
				return true;
			else
				return false;
		}
	}
	
	boolean search(DNode r, int key) {
		if(r!=null) {
			if(r.data == key)
				return true;
			else
				{
				if(r.data>key)
					return search(r.left, key);
				else
					return search(r.right, key);
				}
		}
		return false;
	}  
	
	public static void main(String[] args) {
		Tree obj = new Tree();
		obj.createTree();
		
		DNode n1=new DNode(50);
        obj.insert(obj.root, n1);
        DNode n2=new DNode(20);
        obj.insert(obj.root, n2);
        DNode n3=new DNode(60);
        obj.insert(obj.root, n3);
        DNode n4=new DNode(30);
        obj.insert(obj.root, n4);
        DNode n5=new DNode(100);
        obj.insert(obj.root, n5);
        DNode n6=new DNode(70);
        obj.insert(obj.root, n6);
        DNode n7=new DNode(40);
        obj.insert(obj.root, n7);
        DNode n8=new DNode(35);
        obj.insert(obj.root, n8);
        DNode n9=new DNode(37);
        obj.insert(obj.root, n9);
        System.out.println("Inorder");
        obj.inorder(obj.root);
        System.out.println();
        System.out.println("PreOrder");
        obj.preorder(obj.root);
        System.out.println();
        System.out.println("PostOrder");
        obj.postorder(obj.root);
        System.out.println();
        System.out.println("Height is " + (obj.getHeight(obj.root)-1));
        System.out.println(obj.isBalanced(obj.root));
        System.out.println(obj.search(obj.root, 350));
	}
}
