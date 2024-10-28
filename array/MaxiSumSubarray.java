package a.array;

import java.util.Arrays;

public class MaxiSumSubarray {

	public static void main(String[] args) {
		 int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		//int[] nums =  {1, 2, 3, -2, 5};  
		int[] maxSubArray = maxSubArray(nums);

		System.out.println("Sub-array with maximum sum:");
		for (int num : maxSubArray) {
			System.out.print(num + " ");
		}

		System.out.println();
		
		int su=   maxSubArraySum(nums);
		System.out.println("Maximum sum:"+su);
	}

	public static int[] maxSubArray(int[] nums) {
		int maxSumTrack = nums[0];
		int currentSum = nums[0];
		int start = 0;
		int end = 0;

		for (int i = 1; i < nums.length; i++) {
			// DK i+1 >
			if (currentSum + nums[i] < nums[i]) {
				currentSum = nums[i]; // we do this to check and assing end
				start = i;
			} else {
				currentSum = currentSum + nums[i];
			}

			if (currentSum > maxSumTrack) {
				maxSumTrack = currentSum;
				end = i;
			}
		}
		System.out.println("\nstart end : " + start + ":" + end);
		return Arrays.copyOfRange(nums, start, end + 1);
	}
	
	public static int maxSubArraySum(int[] nums) {
        int maxCurrent = nums[0];
        int maxGlobal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Update maxCurrent by either adding the current element or starting a new subarray
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);

            // Update maxGlobal if maxCurrent is greater
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }

        return maxGlobal;
    }

}
