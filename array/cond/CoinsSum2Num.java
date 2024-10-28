package a.array.cond;

import java.util.Arrays;

//https://www.youtube.com/watch?v=A3FHNCAkhxE
/*
 Given an array coins of distinct denominations and an integer amount, 
 find the minimum number of coins needed to make up that amount. 
 If it is not possible to make the amount, return -1.
 */
public class CoinsSum2Num {

	public static void main(String[] args) {
		CoinsSum2Num solution = new CoinsSum2Num();

		int[] coins = { 1, 2, 5 };
		int amount = 11;

		// System.out.println(solution.coinChange(coins, amount)); // Output: 3 (11 = 5

		System.out.println(solution.coinChangeGood(coins, amount)); // Output: 3 (11
		// = 5

		int[] coins2 = { 2 };
		int amount2 = 3;
		// System.out.println(solution.coinChangeGood(coins2, amount2)); // Output: -1
		// (cannot make amount 3)

		int[] coins3 = { 1, 5, 7 };
		int amount3 = 11;
		System.out.println(solution.coinChangeGood(coins3, amount3)); // Output: -1
	}

	public int coinChangeGood(int[] coins, int amount) {

		int[] dp = new int[amount + 1];

		// Initialize dp array with a large number (infinity)
		Arrays.fill(dp, 12);
		dp[0] = 0;
		for (int coin : coins) {
			// For each coin, update the dp array for all amounts that can be reached and
			// made by this coin
			for (int i = coin; i <= amount; i++) {
				dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				System.out.println("i DP[i] and DP   is :" + i + " :" + dp[i] + " :" + Arrays.toString(dp));

			}
		}
		// printCoinCombination(dp, coins);
		return dp[amount] > amount ? -1 : dp[amount];

	}

	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];

		// Initialize dp array with a large number (infinity)
		Arrays.fill(dp, amount + 1); //

		// Base case
		dp[0] = 0;

		// Fill the dp array
		for (int i = 1; i <= amount; i++) {

			for (int coin : coins) {
				if (coin <= i) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);

				}
			}
		}
		// Check if the amount is reachable
		return dp[amount] > amount ? -1 : dp[amount];
	}

	private void printCoinCombination(int dp[], int coins[]) {
		if (dp[dp.length - 1] == -1) {
			System.out.print("No solution is possible");
			return;
		}
		int start = dp.length - 1;
		System.out.print("Coins used to form total ");
		while (start != 0) {
			int j = dp[start];
			System.out.print(coins[j - 1] + " ");
			start = start - coins[j - 1];
		}
		System.out.print("\n");
	}
}
