package a.array.cond;

import java.util.Arrays;

//https://leetcode.com/problems/climbing-stairs/description/ 
/*
You are given an array cost where cost[i] is the cost of step i. 
Once you pay the cost, you can either move to the next step or skip one step. 
You start at either step 0 or step 1. 
You need to reach the top of the staircase, 
which is just beyond the last step. The task is to determine the minimum cost to reach the top.
 */
public class ClimbingStairsCostMin {
	public int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
		int[] dp = new int[n];

		// Base cases
		dp[0] = cost[0];
		dp[1] = cost[1];

		int[] choose = new int[n];
		// Fill the dp array
		for (int i = 2; i < n; i++) {
		//	choose[i] = Math.min(dp[i - 1], dp[i - 2]);
			dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
		}
		System.out.println("Choose :"+Arrays.toString(choose));
		System.out.println("cost : "+Arrays.toString(cost));
		System.out.println("DP : "+Arrays.toString(dp));
		// The final step can be from either dp[n-1] or dp[n-2]
		return Math.min(dp[n - 1], dp[n - 2]);
	}

	public static void main(String[] args) {
		ClimbingStairsCostMin solution = new ClimbingStairsCostMin();
		int[] cost = { 10, 15, 20 };
	//	System.out.println(solution.minCostClimbingStairs(cost)); // Output: 15

		int[] cost2 = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		System.out.println(solution.minCostClimbingStairs(cost2)); // Output: 6
	}

}
