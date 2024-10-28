package a.array;

import java.util.Arrays;

public class DuplicateRemoverSort {
	public static void main(String[] args) {
		int arr[] = { 6,1, 1, 2, 2, 2, 3, 3 };

		Arrays.sort(arr);
		//int k = removeDuplicates(arr);
		int k = removeDuplicatesDK(arr);
		System.out.println("The array after removing duplicate elements is ");
		for (int i = 0; i < k; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	static int removeDuplicates(int[] arr) {
		int i = 0;

		int j = 1;
		while (j < arr.length) {
			if (arr[i] != arr[j]) {
				i++; // here this 2 line is imp i++ will be 1st as per if block
				arr[i] = arr[j];// here we using same array to get new array 
			} else {
				j++;
			}

		}

		return i + 1; // length of new array
	}
	
	static int removeDuplicatesDK(int[] arr) {
		int i = 0;

		int j = 1;
		while (j < arr.length) {
			if (arr[i] == arr[j]) {
				j++;
			} else {
				i++;
				arr[i] = arr[j];
			}

		}

		return i + 1; // length of new array
	}
}
