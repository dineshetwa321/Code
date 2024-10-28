// https://leetcode.com/problems/house-robber-ii/description/
package a.array.cond;

public class ThiefRobMaxBall_Circle {

	public int rob(int[] nums) {

		int max1 = nums[0];
		int max2 = 0;
		
		int rob1 = 0;int rob2 = 0;	

		 // Case 1: Rob houses from index 0 to n-1 (excluding the last house)
		for (int i = 0; i < nums.length - 1; i++) {
			max1 = Math.max(rob1 + nums[i], rob2);
			rob1 = rob2;
			rob2 = max1;
		}

		rob1 = 0;rob2 = 0;
		// Case 2: Rob houses from index 1 to n-1 (excluding the first house)
		for (int i = 1; i < nums.length; i++) {
			max2 = Math.max(rob1 + nums[i], rob2);
			rob1 = rob2;
			rob2 = max2;
		}

		return Math.max(max1, max2);
	}

	public static void main(String[] args) {
		ThiefRobMaxBall_Circle robber = new ThiefRobMaxBall_Circle();
		int[] houses = { 2, 3, 2 };
		System.out.println(robber.rob(houses)); // Output: 3
	}
}
