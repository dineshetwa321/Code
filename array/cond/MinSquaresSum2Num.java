package a.array.cond;
import java.util.Arrays;

/*
 Given a number n, you want to find the minimum number of perfect square numbers (1, 4, 9, 16, ...)
that sum up to n. For example:

If n = 12, the answer is 3 because 12 = 4 + 4 + 4.
If n = 13, the answer is 2 because 13 = 4 + 9. 
 */

//https://www.youtube.com/watch?v=aJTCcyPrPOA
//https://www.youtube.com/watch?v=1xfx6M_GqFk

public class MinSquaresSum2Num {
	public static int minSquares(int n) {
		// DP array to store the minimum number of squares for each number up to n
		int[] dp = new int[n + 1];

		// Initialize the dp array with the maximum value for comparison
		for (int i = 1; i <= n; i++) {
			dp[i] = i; // Max squares needed would be 1^2 + 1^2 + ... + 1^2 (i times)
		}
		System.out.println(" 1 dp[i] : " + Arrays.toString(dp));
		// Start filling the dp array
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) { // DK we can do j * j <= n; as per
												// https://www.youtube.com/watch?v=aJTCcyPrPOA but have to add i-sur >0
												//https://www.youtube.com/watch?v=1xfx6M_GqFk
												// else Arr out of index excep
				int square = j * j;
				dp[i] = Math.min(dp[i], dp[i - square] + 1);
			}
		}
		System.out.println(" 2 dp[i] : " + Arrays.toString(dp));
		// The answer is the minimum number of squares for the number n
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 100; // 4 4 4
		System.out.println("Minimum number of squares for " + n + " is: " + minSquares(n)); // Output: 3

		n = 13; // 4 9
		// System.out.println("Minimum number of squares for " + n + " is: " +
		// minSquares(n)); // Output: 2
	}
}
