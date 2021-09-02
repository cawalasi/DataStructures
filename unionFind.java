package DataStructure;

public class unionFind {
	//Size of the Array
	private int size;
	//Array that stores size of components in each tree or trees
	private int[] sz;
	// Array to hold elements in
	private int[] id;
	//Number of Components in the array
	private int numofComponents;
	
	public unionFind(int size) {
		
		if (size <= 0) {
			throw new IllegalArgumentException("Size can not be negative");
		}
		
		this.size = numofComponents = size;
		
		id = new int [size];
		sz = new int [size];
		
		for (int i = 0; i < size; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	//Method that finds root of a certain elements
	public int find (int p) {
		int root = p;
		
		while(root != id[root]) {
			root = id[root];
		}
		
		while (p != root) {
			int next = id[p];
			id[p] = root;
			p = next;
		}
		return root;
		
	}
	// Checks if elements are connect to the same root 
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}
	public int components(int p) {
		return sz[find(p)];
	}
	public int size() {
		return size;
	}
	public int components() {
		return numofComponents;
	}
	// Unify Method that merge two elements to the same root
	public void unify(int p, int q) {
		int root1 = find(p);
		int root2 = find(q);
		
		if(root1 == root2) {
			return;
		}
		
		if(root1 < root2) {
			sz[root2] += sz[root1];
			id[root1] = root2;
		}else {
			sz[root1] += sz[root2];
			id[root2] = root1;
		}
		--numofComponents;
	}
	
	public static void main (String[] args) {
		unionFind q = new unionFind(10);
		q.unify(2, 4);
		q.unify(1, 2);
		q.unify(4, 6);
		q.unify(6,7);
		System.out.print(q.find(1));
		System.out.println();
		System.out.print(q.numofComponents);
		System.out.println();
		System.out.print(q.find(6));
		System.out.println();
		System.out.print(q.isConnected(1,4));
		
	}
	

}
