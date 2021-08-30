package DataStructure;

public class mergeS {

	private static void merge(int[] arr, int start, int mid , int end) {
		
			// Create temp  array to store values
			int[] temp = new int [arr.length];
			int i = start, j = mid + 1, k = 0; // Create indices to start and end from
		
			while(i <= mid && j <= end)  { // Loop that checks of there are elements in the array
				if(arr[i] <=arr[j]) { // Check to see which element if smaller
					temp[k] = arr[i]; // Puts that element in temp array;
					i++; 
				}else {
					temp[k] = arr[j];
					j++;
				}
				k++;
				
			}
			while (i <= mid) {  //Add remaining value into the temp array
				temp[k] = arr[i];
				i++;
				k++;
			}
			while(j <= end) {
				temp[k] = arr[j];
				j++;
				k++;
			}
			
			for(i = start; i <= end; i++) {  //Copy elements into the original array
				arr[i] = temp[i- start];
			}
		
		
	}
	
	private static void mergeSort(int[] arr, int start, int end) {
		int n = arr.length;
		 if (start < end) {
			int mid = (start + end) /2;
			mergeSort(arr, start,mid);
			mergeSort(arr,mid + 1, end);
			merge(arr, start,mid,end);
		 }
		
	}
	private static void print(int[] arr) {
		
		for(int i = 0; i <= arr.length-1; i++) {
			
			System.out.print(arr[i] + " ");
		}
		
		
	}
	public static void main(String[] args) {
		
		int[] items = {10,9,8,7,6,5,4,3,2,1};
		mergeSort(items,0, items.length-1);
		print(items);
	}
	
}
