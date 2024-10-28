package a.array.cond;
import java.util.Arrays;

//https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/ 
public class MaxFrequencyAddNtimeArray {
    public int maxFrequency(int[] nums, int k) {
        // Sort the array to use the sliding window technique
        Arrays.sort(nums);
        int n = nums.length;

        long total = 0;  // Track the sum of the current window
        int left = 0;    // Left pointer of the window
        int maxFreq = 1; // At least one element can always have frequency 1

        // Expand the sliding window by moving the 'right' pointer
        for (int right = 0; right < n; right++) {
            total += nums[right];  // Add the current element to the total sum

            // Check if the current window is valid
            while (nums[right] * (right - left + 1) > total + k) {
                // Shrink the window from the left if it becomes invalid
                total -= nums[left];
                left++;
            }

            // Update the maximum frequency found
            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }

    public static void main(String[] args) {
    	MaxFrequencyAddNtimeArray solution = new MaxFrequencyAddNtimeArray();
        
        // Example 1
        int[] nums1 = {1, 2, 4};
        int k1 = 5;
        System.out.println(solution.maxFrequency(nums1, k1));  // Output: 3

        // Additional Example
        int[] nums2 = {1, 4, 8, 13};
        int k2 = 5;
        System.out.println(solution.maxFrequency(nums2, k2));  // Output: 2
    }
}
