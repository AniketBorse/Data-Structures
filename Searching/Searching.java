import java.util.Scanner;

class Sequential_Search{
	int sequential_search(int arr[], int k) {
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] == k) {
				return i;
			}
		}
		return -1;
	}
}

class Binary_Search{
	int binary_search(int arr[], int k, int low, int high) {
		if(low<=high) {
			int mid = (low+high)/2;
			if(k<arr[0] || k>arr[high])
				return -1;
			else {
				if(k == arr[mid])
					return mid;
				else {
					if(k<arr[mid])
						return binary_search(arr, k, low, mid-1);
					else
						return binary_search(arr, k, mid+1, high);
				}
			}
		}
		else
			return -1;
	}
}

public class Searching {
	public static void main(String[] args) {
		Sequential_Search s = new Sequential_Search();
		Binary_Search b = new Binary_Search();
		int arr[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
		int k;
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		//int result = s.sequential_search(arr, k);
		int result = b.binary_search(arr, k, 0, arr.length);
		if(result == -1)
			System.out.println("Not Found");
		else
			System.out.println("Found at index "+result);
		sc.close();
	}
}