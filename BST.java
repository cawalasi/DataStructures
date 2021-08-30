package DataStructure;
 
	public class BST  {
	Node root;
	int size = 0;
	
	class Node {
		Node  left;
		Node  right;
		int val;
		
		public Node(int val) {
			this.left = null;
			this.right = null;
			this.val = val;
			
			
		}
		
	}
	
	
	
	public Node insertNode(Node root,int val) {
		
		if(root== null) {
			root= new Node(val);
			return root;
			
	}
		
		if(root.val < val) {
			
			root.right =insertNode(root.right,val);
			}else {
				root.left = insertNode(root.left,val);
			}
		return root;
		
		
	}
	
	public void add(int val) {
		root = insertNode(root,val);
	}
	
	public void print() {
		printLeaves(root);
	}
	
	public static void printLeaves(Node root) {
		if (root == null)
			return;
		
		if(root.left == null && root.right == null) {
			System.out.print(root.val + " ");
			
		}
		if(root.left != null) {
			printLeaves(root.left);
		}
		if(root.right !=null) {
			printLeaves(root.right);
		}
	}
	public  void display(Node root) {
		if (root !=null) {
			display(root.left);
			System.out.print(root.val + " ");
			display(root.right);
		}
		
		
	}
	public void printAll() {
		 displayAll(root);
	}
	public void displayAll(Node root) {
		if(root == null) {
			return;
		}
		
			displayAll(root.left);
			System.out.print(root.val + ", ");
			displayAll(root.right);
			
		
			
		
	}
	
	public void inOrder() {
		display(root);
	}
		public static void main(String[] args) {
		BST items = new BST();
		items.add(10);
		items.add(12);
		items.add(14);
		items.add(97);
		items.add(1);
		items.printAll();
		
		
		
		
	}
}
