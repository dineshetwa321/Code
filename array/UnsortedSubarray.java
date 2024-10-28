package a.array;

import java.util.Arrays;

public class UnsortedSubarray {

	public static void main(String[] args) {

		System.out.println("Length of first unsorted subarray: " + findFirstUnsortedSubarray().length);
	}

	// DDD Good --we have find 1st un-ordered index from left and right
	public static int[] findFirstUnsortedSubarray() {

		int[] nums = new int[] { 2, 6, 4, 8, 10, 9, 5, 15, 3 };

		// nums = new int[] {9, 5, 3,6,7};
		int n = nums.length;
		int left = -1, right = -1;
		// Identify the left boundary
		for (int i = 0; i < n - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				left = i;
				break;
			}
		}
		// If the array is already sorted
		if (left == -1) {
			return new int[0]; // return an empty array
		}
		// Identify the right boundary
		for (int i = n - 1; i > 0; i--) {
			if (nums[i] < nums[i - 1]) {
				right = i;
				break;
			}
		}
		// Extract the subarray
		int[] result = new int[right - left + 1];
		for (int i = left; i <= right; i++) {
			result[i - left] = nums[i];
		}
		System.out.println(Arrays.toString(result));
		return result;
	}

}
