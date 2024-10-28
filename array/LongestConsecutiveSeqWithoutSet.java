package a.array;

import java.util.Arrays;
import java.util.HashSet;

//https://www.youtube.com/watch?v=LvbtUMdcgbw 
//https://leetcode.com/problems/longest-consecutive-sequence/description/
public class LongestConsecutiveSeqWithoutSet {

	public static int longestConsecutiveSeq(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		// Sort the array
		Arrays.sort(nums);

		int longestStreak = 1;
		int currentStreak = 1;

		// Iterate through the sorted array
		for (int i = 1; i < nums.length; i++) {
			// If the current element is the same as the previous, skip it
			if (nums[i] == nums[i - 1]) {
				continue;
			}

			// If the current element is consecutive, increment the current streak
			if (nums[i] == nums[i - 1] + 1) {
				currentStreak++;
			} else {
				// Otherwise, reset the current streak and update the longest streak
				longestStreak = Math.max(longestStreak, currentStreak);
				currentStreak = 1;
			}
		}

		// Final comparison to ensure the longest streak is updated
		return Math.max(longestStreak, currentStreak);
	}

	public static void main(String[] args) {
		int[] nums = { 100, 22, 200, 8, 3, 2 };
		System.out.println("Longest consecutive sequence length: " + longestConsecutiveSeq(nums)); // Output: 4
	 
		System.out.println("Longest consecutive sequence length: " + longestConsecutiveMap(nums)); // Output: 4
	}
	
	public static int longestConsecutiveMap(int[] nums) {
        // Edge case: if the array is empty, return 0
        if (nums.length == 0) {
            return 0;
        }
        
        // Add all numbers to a HashSet for O(1) lookups
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        // Iterate through the array
        for (int num : nums) {
            // Check if num is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // Count the length of the consecutive sequence
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                // Update maxLength if the current sequence is longer
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
 

}
