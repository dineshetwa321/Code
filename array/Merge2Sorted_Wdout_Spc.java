package a.array;

import java.util.Arrays;

public class Merge2Sorted_Wdout_Spc {

	//// Merge Two Sorted Arrays With out extra space
	public static void merge(int[] nums1, int num1Len, int[] nums2, int num2Len) {
		int index1 = num1Len - 1; // Index of last element in nums1
		int index2 = num2Len - 1; // Index of last element in nums2
		int mergeIndex = num1Len + num2Len - 1; // Index of last element in merged array 
		
		while (index1 >= 0 && index2 >= 0) { //DK here no if else later as it start from last 
			
			if (nums1[index1] > nums2[index2]) {
				nums1[mergeIndex--] = nums1[index1--];
			} else {
				nums1[mergeIndex--] = nums2[index2--];
			}
		}

		// If nums2 has remaining elements, they are already in the correct position in
		// nums1
		// If nums1 has remaining elements, they are already in the correct position in
		// nums1
		// No need to explicitly copy remaining elements of nums2
	}

	public static void main(String[] args) {
		//int[] nums1 = { 1, 3, 5, 7, 0, 0, 0 }; // Initialized with extra space
		
		int[] nums1 = { 1, 3, 5, 7}; // Initialized with extra space
		int m = 4;
		int[] nums2 = { 2, 4, 6 };
		int n = 3;
 
		nums1 =Arrays.copyOf(nums1, nums1.length+nums2.length);
		
		//System.out.println("nums1 Merged Array:"+nums1.toString());
		for (int num : nums1) {
			System.out.print(num + " ");
		}
		
		merge(nums1, m, nums2, nums2.length);

		System.out.println("Merged Array:");
		for (int num : nums1) {
			System.out.print(num + " ");
		}
	}
}
