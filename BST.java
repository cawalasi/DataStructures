package DataStructure;
 
	public class BST  {
	Node root;
	private int numCount =  0;
	
	private static class Node {
		Node  left;
		Node  right;
		int val;
		
		public Node(int val) {
			this.left = null;
			this.right = null;
			this.val = val;
			
			
		}
		
	}
	
	public boolean isEmpty() {
		return (numCount == 0);
		
	}
	
	
	
	private Node insertNode(Node root,int val) {
		
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
	//Method to check find an element in tree 
	public boolean find(int val) {
		if (isEmpty()) {
			throw new IllegalArgumentException("Tree is empty");
		}
		Node curr = root;
		 while(curr != null) {
			 if (curr.val == val) {
				 return true;
			 }else if (curr.val < val) {
				 curr = curr.right;
			 }else {
				 curr = curr.left;
			 }
		}
		 return false;
		
	}
	
	public void delete(int val) {
		root = deleteNode(val,root);
		
		
	}
	
	public Node deleteNode(int val, Node root) {
		if(root == null) {
			return null;
		}
		
		if(val < root.val) {
			root.left = deleteNode(val,root.left);
		}else if (val > root.val){
			root.right = (deleteNode(val,root.right));
		}else {
			
			if(root.left == null) {
				return root.right;
			}else if(root.right == null) {
				return root.left;
			}
			
			root.val = successor(root.right);
			root.right = deleteNode(root.val,root.right);
		}
		return root;
		
	}
	private int successor(Node root) {
		int successor = root.val;
		
		while(root.left != null) {
			successor = root.left.val;
			root = root.left;
		}
		return successor;
		
	}
	
	
	public int findRoot () {
		return root.val;
	}
	
	public int findMin(Node root) {
		Node curr = root;
		
		while (curr .left != null) {
			curr = curr.left;
		}
		return curr .val;
	}
	
	public int findMax(Node root) {
		Node curr = root;
		
		while (curr.right != null) {
			curr = curr.right;
		}
		return curr.val;
		
	}
	public void add(int val) {
		root = insertNode(root,val);
		numCount++;
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
	
	public void inOrder(Node root) {
		if(root == null) {
			return;
		}
		if (root != null) {
		inOrder(root.left);
		System.out.print(root.val + ", ");
		inOrder(root.right);
		}
	}
		
		public void preOrder(Node root) {
			
			if (root != null) {
				System.out.print(root.val + ", ");
				preOrder(root.left);
				preOrder(root.right);
			}
			
		}
		public void postOrder(Node root) {
			if(root != null) {
				postOrder(root.left);
				postOrder(root.right);
				System.out.print(root.val + ", ");
			}
		}
		
	
	
	
		public static void main(String[] args) {
		BST items = new BST();
		items.add(50);
		items.add(30);
		items.add(20);
		items.add(40);
		items.add(70);
		items.add(60);
		items.add(80);
		items.inOrder(items.root);
		items.delete(50);
		System.out.println();
		items.inOrder(items.root);
		System.out.println();
		System.out.print(items.findRoot());
		System.out.println();
		items.preOrder(items.root);
		System.out.println();
		items.postOrder(items.root);
		System.out.println();
		items.inOrder(items.root);
		System.out.println();
		System.out.print(items.findMin(items.root));
		System.out.println();
		System.out.print(items.findMax(items.root));
		System.out.println();
		System.out.print(items.find(60));
		
		
		
		
		
		
	}
}
