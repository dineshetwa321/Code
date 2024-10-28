package a.array.cond;

import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/stickler-theif-1587115621/1 
// https://leetcode.com/problems/house-robber/description/
public class ThiefRobMaxBall {

	public static int maxLootDP(int[] array) {
		int n = array.length;

		// Base cases
		if (n == 0)
			return 0;
		if (n == 1)
			return array[0];
		if (n == 2)
			return Math.max(array[0], array[1]);

		// DP array to store the maximum loot at each house
		int[] dp = new int[n];

		// 111
		// Initial conditions
		dp[0] = array[0];

		// Fill the dp array according to the recurrence relation

		dp[0] = array[0];
		dp[1] = Math.max(array[0], array[1]);

		for (int i = 2; i < n; i++) {
			System.out.println("DP A is :" + Arrays.toString(dp));
			dp[i] = Math.max(array[i] + dp[i - 2], dp[i - 1]);
			System.out.println("DP B is :" + Arrays.toString(dp));
		}
		return dp[n - 1];
//		int withCurrent = array[i] +dp[i - 2] ;
//		int prev = dp[i - 1];
//		current = Math.max(prev1, prev2 + balls[i]);
//		prev2 = prev1;
//		prev1 = current;
//		return prev1;
		// The last element of dp array will have the result

	}

	public static void main(String[] args) {
		int[] houseValues = { 6, 7, 2, 30, 8, 2, 4 };// output 41
		// int[] houseValues = {6,5,5,7,4};// Output 15
		// int[] houseValues = { 1, 5, 3 }; // Output: 5

		System.out.println("Maximum loot possible: " + maxLootAfterOptimize(houseValues));
		System.out.println("Maximum loot possible: " + maxLootDP(houseValues));

	}

	public static int maxLootAfterOptimize(int arr[]) {

		// int[] balls = {6, 7, 2, 30, 8, 2, 4 };// output 41

		int[] balls = { 1, 4, 3, 7, 8, 6, 9 };// output 41

		if (balls.length == 0)
			return 0;
		if (balls.length == 1)
			return balls[0];

		int prev2 = balls[0]; // Corresponds to dp[i-2]
		int prev1 = Math.max(balls[0], balls[1]); // Corresponds to dp[i-1]

		// { 6, 7, 2, 30, 8, 2, 4 };// output 41
		int current = 0;
		for (int i = 2; i < balls.length; i++) {

			System.out.println("prev2 prev1 current A: " + prev2 + ":" + +prev1 + ":" + balls[i]);

			current = Math.max(prev1, prev2 + balls[i]);
			prev2 = prev1;
			prev1 = current;

			System.out.println("prev2 prev1 current B: " + prev2 + ":" + +prev1 + ":" + balls[i]);
		}

		return prev1; // This holds the maximum balls that can be collected
	}

}
