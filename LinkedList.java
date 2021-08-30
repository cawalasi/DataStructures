package DataStructure;

	
public class LinkedList <T>{
	private int size;
	private Node <T> head;
	public LinkedList(){
		
		this.head = null;
	}
	
	private static class Node <T> {
		private Node <T> next;
		private T data;
		
		public Node (T data) {
			this.next = null;
			this.data = data;
		}
	 }	
	
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size() == 0);
	}
	
	public void insert(T data) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
		}else {
			
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			size++;
		}
	}
		
		public void clear () {
			if (isEmpty()) throw new RuntimeException("LinkedList is Empty");
			Node <T> temp = head;
			
			if (head != null) {
				head = null;
				
			}else {
				
				while(temp.next != null) {
					temp = temp.next;
					temp.next = null;
					
				}
				head = temp = null;
				size = 0;
				
			}
			
			
		}		
		
		public T peekFirst() {
			if(isEmpty()) throw new RuntimeException("LinkedList is Empty");
			return head.data;
		}
		
		public T peekLast() {
			
			if (isEmpty()) throw new RuntimeException("LinkedList is Empty");
			
			Node <T> temp = head;
			
			while(temp.next != null) {
				temp = temp.next;
			}
			return temp.data;
			
		}
		
		public void remove(T data) {
			if(isEmpty()) throw new RuntimeException("LinkedList is Empty");
			
			Node <T> temp = head;
			 if(data == head.data) {
				 head = head.next;
			 }else {
				 while(temp.next != null) {
					 if(data == temp.next.data) {
						 temp.next = temp.next.next;
					 }else {
						 temp = temp.next;
					 }
					  
				 }
				 size--;
			 }
			 
		}
		
		public void reverse() {
			if (isEmpty()) throw new RuntimeException("LinkedList is Empty");
			
			Node <T> temp = head;
			Node<T>  prev = null;
			Node <T> next = null;
			
			while (temp != null) {
				next = temp.next;
				temp.next = prev;
				prev = temp;
				temp = next;
				head = prev;
				
			}
			
			
		}
		
		public boolean find (Object obj) {
			if(isEmpty()) throw new RuntimeException("LinkedList is Empty");
			Node <T> temp = head;
			if (obj.equals(head.data)) {
				return true;

			}else {
				for(temp = head; temp != null; temp = temp.next) {
					if(obj.equals(temp.data)) {
					return true;
				}
			}
			}
			return false;
			
		}
		
		public int indexOf(Object obj){
			
			if (isEmpty()) throw new RuntimeException("LinkedList is Empty");
			int index = 0;
			Node <T> temp = head;
			
			if (obj.equals(head.data)) {
				return index;
			}else {
				for (temp = head; temp != null; temp = temp.next,index++) {
					if(obj.equals(temp.data)) {
						return index;
					}
				}
			}
			return -1;
			
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			Node <T> temp = head;
			
			sb.append("[ ");
			while(temp != null) {
				sb.append(temp.data + ", ");
				temp = temp.next;
			}
			sb.append("]");
			return sb.toString();
			
			
			
		}	
		
		public static void main(String[] args) {
			LinkedList items = new LinkedList();
			
			items.insert(1);
			items.insert(2);
			items.insert(3);
			items.insert(4);
			items.insert(5);
			items.insert(6);
			System.out.print(items.toString());
			System.out.println();
			items.remove(2);
			System.out.print(items.toString());
			System.out.println();
			System.out.print(items.size());
			System.out.println();
			System.out.print(items.indexOf(4));
			System.out.println();
			System.out.print(items.peekFirst());
			System.out.println();
			System.out.print(items.peekLast());
			System.out.println();
			System.out.print(items.find(3));
			
			
		}
		
		
	
	
	
	
	
	

}
