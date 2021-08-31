// Author: Christopher A.
package DataStructure;

public class minHeap {
	//Construct Heap and Build the characteristics of it
	private int[] Heap;
	private int size;
	private int maxSize;
	//Constructor
	public minHeap(int size) {
		this.maxSize = size;
		this.size = 0;
		Heap = new int [this.maxSize +1];
		
		
		
	}
	// Method that return the size
	public int size () {
		
		return this.size;
	}
	// Checks whether the heap is Empty or not
	public boolean isEmpty(){
		if (size == 0) {
			
			return true;
		}
		return false;
	}
	// Swap method to interchange elements in the heap
	private void swap(int m1, int m2) {
		
		int temp = Heap[m1];
		Heap[m1] = Heap [m2];
		Heap[m2] = temp;
	}
	// Method that returns the parents of current node in heap
	public int parent(int pos) {
		return(pos/2);
		
	}
	//Method that returns the Left Child of the Heap
	public int leftChild(int pos) {
		return (2 * pos);
		
	}
	// Method that return the Right Child of the Heap
	public int rightChild(int pos) {
		return (2 * pos) + 1;
	}
	
	// Method the adds elements to the heap
	public void insert (int element) {
		
		Heap[++size] = element;
		int current = size;
		
		while(Heap[current] < Heap[parent(current)]) { //After adding elements you must Heapify Up to justify  minHeap property
			
			swap(current,parent(current)); // Swap
			current = parent(current); // Move up one level
		} 
		
		
	}
	//Method that heapify downs 
	public void siftDown(int pos) {
		if(pos >= size/2 && pos <= size) { //checks to see element is a leaf node
			return;
		}
		if(Heap[pos] > Heap[leftChild(pos)] || Heap[pos]> Heap[rightChild(pos)]) { //check whether elements is greater than left child or right child
			
			if(Heap[leftChild(pos)] < Heap[rightChild(pos)]) { //Compare leftchild and rightchild to see which is lesser
				
				swap(pos,leftChild(pos)); //swap
				siftDown(leftChild(pos)); //Recursion method siftDown
			}else {
				
				swap(pos,rightChild(pos));
				siftDown(rightChild(pos));
			}
			
		}
		
		
	}
	
	//Method that extracts the minimum element in Heap
	public int extractMin() {
		int min = Heap[1];
		Heap[1] = Heap[size--];
		siftDown(1);
		return min;
		
	}
	// Method that prints all elements
	public void print() {
		
		for (int i = 1;  i <= size; i++) {
			System.out.print(Heap[i] + " "  );
		
			
		}
	}
	
	// Driver
	public static void main(String[] args) {
		
		minHeap items = new minHeap(12);
		items.insert(20);
		items.insert(18);
		items.insert(10);
		items.insert(12);
		items.insert(9);
		items.insert(5);
		items.insert(9);
		items.insert(3);
		items.print();
		System.out.println();
		System.out.print(items.extractMin());
		System.out.println();
		items.print();
		System.out.println();
		System.out.print(items.size);
		
		
		
	}
	
	
}
