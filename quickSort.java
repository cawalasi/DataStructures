package DataStructure;

public class quickSort {
	public static void swap (int arr [], int m1, int m2) {
		int temp = arr[m1];
		arr[m1] = arr[m2];
		arr[m2] = temp;
		
		
	}
	
	public static int partition(int arr[], int start, int end) {
		
		int pivot = arr[end];
		int pIndex = start;
		
		for (int i = start; i < end; i++) {
			
			if (arr[i] <= pivot) {
				swap(arr,i,pIndex);
				pIndex++;
			}
		}
		swap(arr,pIndex,end);
		return pIndex;
		
		
	}
	
	public static void quickSort(int arr[], int start, int end) {
		
		if (start < end) {
			
		int index= partition(arr, start, end);
		quickSort(arr,start, index -1);
		quickSort(arr,index +1 , end);
		}
	}

	public static void print(int arr[]) {
		
		for (int i = 0; i < arr.length; i++) {
			
			System.out.print((arr[i]+ " "));
		}
	}
	public static void main (String[] args) {
		int  items [] = {10,9,19,22,4,15,19,40,2,3,5};
		quickSort(items, 0, items.length -1);
		print(items);
	
		
		
		
		
	}
}
