package a.array;

//https://leetcode.com/problems/unique-paths/description/ 

public class UniquePathsN2N {

	public static int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		/*
		 * 1 2 3 4 5 6 6 7 8
		 */
		// Initialize the first row and first column to 1
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			dp[0][j] = 1;
		}

		// Fill the dp array
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		// The bottom-right cell contains the number of unique paths
		return dp[m - 1][n - 1];
	}

	public static void main(String[] args) {
		int m = 3;
		int n = 3;
		System.out.println("Number of unique paths: " + uniquePaths(m, n)); // Output: 6
	}
}
