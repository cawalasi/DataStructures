//Author; Christopher A.
package DataStructure;

public class maxHeap {
	private int[] Heap;
	private int size;
	private int  maxSize;
	
	public maxHeap(int size) {
		this.maxSize = size;
		this.size = 0;
		Heap = new int [this.maxSize + 1];
		Heap[0] = Integer.MAX_VALUE;
		
		
		
		
	}
	private void swap (int m1, int m2) {
		
		int temp = Heap[m1];
		Heap[m1] = Heap[m2];
		Heap[m2] = temp;
		
	}
	
	public int size() {
		return this.size;
		
		
	}
	public  boolean isEmpty() {
		if (size == 0) {
			
			return true;
		}
		return false;
			
			
		
		
	}
	
	public int parent(int current) {
		
		return current/2;
	}
	public int leftChild(int current) {
		return  2 * current;
		
	}
	public int rightChild (int current) {
		
		return (2 * current) + 1;
	}
	
	public void insert(int element) {
		
		Heap[++size] = element;
		int current = size;
		
		while ( Heap[current] > Heap[parent(current)]) {
			swap(current,parent(current));
			current = parent(current);
			
		}
	}
	
	public void siftDown(int current) {
		if (current >= size/2 && current <= size ) {
			return;
		}
		
		if(Heap[leftChild(current)] >  Heap[current] || Heap[rightChild(current)] > Heap[current]) {
			
			if(Heap[leftChild(current)] > Heap[rightChild(current)]) {
				
				swap(current,leftChild(current));
				siftDown(leftChild(current));
			}else {
				
				swap(current,rightChild(current));
				siftDown(rightChild(current));
			}
		}
		
		
		
	}
	public int getMax() {
		int current = Heap[1];
		Heap[1] = Heap[size--];
		siftDown(1);
		return current;
		
		
		
	}
	
	public void print() {
		
		for (int i = 1; i<=size; i++){
			System.out.print(Heap[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		
		maxHeap items = new maxHeap(12);
		items.insert(3);
		items.insert(5);
		items.insert(9);
		items.insert(6);
		items.insert(8);
		items.insert(20);
		items.insert(10);
		items.insert(12);
		items.insert(18);
		items.insert(9);
		items.insert(1);
		items.insert(100);
		items.print();
		System.out.println();
		System.out.print(items.getMax());
		System.out.println();
		items.print();
	}
	

}
