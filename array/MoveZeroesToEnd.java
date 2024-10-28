package a.array;

import java.util.Arrays;

public class MoveZeroesToEnd {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 3, 12 };

		// pushZerosToEnd(arr);
		dkPushZerosToEnd(arr);
		// System.out.println(Arrays.toString(arr)); // Output: [1, 3, 12, 0, 0]
	}

	// DK this one is less good
	static void pushZerosToEnd(int arr[]) {
		int j = 0;
		int count = 0;

		for (int i = 0; i < arr.length; i++) {

			count++;
			System.out.println("count :" + count);

			if (arr[j] == 0 && arr[i] != 0) {

				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			if (arr[j] != 0) {
				j++;
			}

		}

	}

	// GOOD
	static void dkPushZerosToEnd(int arr[]) {
		int j = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[j++] = arr[i];
			}
		}
		while (j < arr.length) { // this is more tim completx
			arr[j++] = 0;
		}

		System.out.println(Arrays.toString(arr)); // Output: [1, 3, 12, 0, 0]
	}

	public static void moveZeroes(int[] nums) {

		int arrLength = nums.length;
		int left = 0; // Pointer for non-zero elements

		// Traverse the array with the right pointer
		for (int i = 0; i < arrLength; i++) {

			// { 0, 1, 0, 3, 12 }; // DK -if num is nt zero then bring instart and swap this

			// If the current element is non-zero, swap it with the element at the left
			// pointer
			if (nums[i] != 0) {
				// Swap elements
				int temp = nums[left];
				nums[left] = nums[i];
				nums[i] = temp;

				// Move the left pointer to the next position
				left++;
			}
		}
	}
	
	public static int[] moveZeros(int n, int[] a) {
		int j = -1;
		// place the pointer j:
		for (int i = 0; i < n; i++) {
			if (a[i] == 0) {
				j = i;
				break;
			}
		}

		// no non-zero elements:
		if (j == -1)
			return a;

		// Move the pointers i and j
		// and swap accordingly:
		for (int i = j + 1; i < n; i++) {
			if (a[i] != 0) {
				// swap a[i] & a[j]:
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				j++;
			}
		}
		return a;
	}
}
