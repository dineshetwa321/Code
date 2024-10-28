package a.array;

public class Merge2Sorted_Extra_Spc {

	
	// Merge Two Sorted Arrays  With  extra space 
	public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
		int[] result = new int[m + n];
		int i = 0, j = 0, k = 0;

		//int[] nums1 = { 1, 3, 5, 7 }; 
		//int[] nums2 = { 2, 4, 6 };
		 
		while (i < m && j < n) {
			if (nums1[i] <= nums2[j]) {
				result[k++] = nums1[i++];
			} else {
				result[k++] = nums2[j++];
			}
		}

		// 2 5 9 9
		// 3 4 8
		//both while to add more element if they have after compare 
		while (i < m) {
			result[k++] = nums1[i++];
		}

		while (j < n) {
			result[k++] = nums2[j++];
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 3, 5, 7 };
		int m = 4;
		int[] nums2 = { 2, 4, 6 };
		int n = 3;

		int[] mergedArray = merge(nums1, m, nums2, n);

		System.out.println("Merged Array:");
		for (int num : mergedArray) {
			System.out.print(num + " ");
		}
	}
}
