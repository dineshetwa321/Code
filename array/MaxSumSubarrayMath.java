package a.array;
public class MaxSumSubarrayMath {
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
    	//4, -1, 2, 1,
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int maxSum = maxSubArray(nums);
        System.out.println("Maximum sum of sub-array: " + maxSum);
    }
}
