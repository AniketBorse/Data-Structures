public class Sorting_Algorithms {
	void print(int arr[]) {
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	void bubble_sort(int arr[]) {
		int count = 0;
		for(int i = 0; i<arr.length-1; i++) {
			for(int j = 0; j<arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					count++;
				}
			}
			if(count>0) 
				continue;
			else
				break;
		}
		
	}
	
	void selection_sort(int arr[]) {
		for(int i = 0; i<arr.length-1; i++) {
			int min = arr[i];
			int pos = i;
			for(int j = i+1; j<arr.length; j++) {
				if(arr[j]<min) {
					min = arr[j];
					pos = j;
				}
			}
			arr[pos] = arr[i];
			arr[i] = min;
		}
	}
	
	void insertion_sort(int arr[]) {
		for(int i = 0; i<arr.length-1; i++) {
			int new_element = arr[i+1];
			int j = i+1;
			while(j>0 && arr[j-1]>new_element) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = new_element;
		}
	}
	
	void quick_sort(int arr[], int start, int end) {
		int i = start, j = end, pivot;
		if(start<=end) {
			pivot = end;
			while(i<j) {
				while(arr[i]<arr[pivot])
					i++;
				while(arr[j]>arr[pivot])
					j--;
				if(i<j) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			if(i<end)
				quick_sort(arr, i+1, end);
			if(j>start)
				quick_sort(arr, start, j-1);
		}
	}
	
	void merge_sort(int arr[], int start, int end) {
		if(start < end) {
			int mid = (start+end)/2;
			merge_sort(arr,start, mid);
			merge_sort(arr,mid+1, end);
			merge(arr, start, mid, end);
		}
	}
	
	void merge(int arr[], int start, int mid, int end) {
		int temp[] = new int[arr.length];
		int i, j, tindex;
		i = start;
		j = mid+1;
		tindex = start;
		while(i<=mid && j<=end) {
			if(arr[i]<arr[j])
				temp[tindex++] = arr[i++];
			else
				temp[tindex++] = arr[j++];
		}
		while(i<=mid)
			temp[tindex++] = arr[i++];
		while(j<=end)
			temp[tindex++] = arr[j++];
		for(i = start; i<=end; i++) {
			arr[i] = temp[i];
		}
	}
	
	public static void main(String[] args) {
		Sorting_Algorithms obj = new Sorting_Algorithms();
		int arr[] = {99, 88, 11, 44, 55, 66, 77, 22, 33};
		obj.print(arr);
//		System.out.println("Using Bubble Sort");
//		obj.bubble_sort(arr);
//		System.out.println("Using Selection Sort");
//		obj.selection_sort(arr);
//		System.out.println("Using Insertion Sort");
//		obj.insertion_sort(arr);
//		System.out.println("Using Quick Sort");
//		obj.quick_sort(arr, 0, arr.length-1);
		System.out.println("Using Merge Sort");
		obj.merge_sort(arr, 0, arr.length-1);
		obj.print(arr);
	}
}
