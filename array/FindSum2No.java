package a.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindSum2No {


	public static void main(String args[]) {
		int n = 5;
		int[] arr = { 2, 6, 5, 8, 11 };
		int target = 14;
		// String ans = twoSum(n, arr, target);
		// System.out.println("This is the answer for variant 1: " + ans);

		int[] result = findTargetSumGood(arr, target);

		if (result.length == 2) {
			System.out.println("Pair found at indices: " + result[0] + " and " + result[1]);
		} else {
			System.out.println("No pair found.");
		}
		
		   String sss  = twoSum(arr.length, arr, target);
		   System.out.println("pair found."+sss );
	}

	public static int[] findTargetSumGood(int[] nums, int target) {
		// Create a HashMap to store the difference (target - current element) and its
		// index
		HashMap<Integer, Integer> map = new HashMap<>();

		// Loop through the array
		for (int i = 0; i < nums.length; i++) {
			// Calculate the complement (target - current element)
			int complement = target - nums[i];

			// If the complement exists in the map, return the pair of indices
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}

			// Otherwise, add the current element to the map with its index
			map.put(nums[i], i);
		}

		// If no pair is found, return an empty array
		return new int[] {};

	}

	public static boolean hasSum(int[] nums, int target) {
		Set set = new HashSet();

		for (int num : nums) {
			int complement = target - num;
			if (set.contains(complement)) {
				return true;
			}
			set.add(num);
		}

		return false;
	}
	
	public static String twoSum(int n, int[] arr, int target) {
		Arrays.sort(arr); //TODO they will not allow
		int left = 0, right = n - 1;
		while (left < right) {
			int sum = arr[left] + arr[right];
			if (sum == target) {
				return "YES";
			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}
		return "NO";
	}

}