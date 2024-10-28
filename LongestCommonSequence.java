package a.string.imp;

//https://leetcode.com/problems/longest-common-subsequence/description/
//https://www.youtube.com/watch?v=e9tUPwZZSBI
public class LongestCommonSequence {

	public int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();

		// Create a 2D dp array of size (m + 1) x (n + 1)
		int[][] dp = new int[m + 1][n + 1];

		//Sale logic A_ShortestComnSuperSeqDP
		// Fill the dp array
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					// If characters match, take the diagonal value + 1
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					// If characters don't match, take the max of top or left value
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		// The answer is in the bottom-right cell
		return dp[m][n];
	}

	public static void main(String[] args) {
		LongestCommonSequence solution = new LongestCommonSequence();

		String s1 = "abcde";
		String s2 = "ace";

		int result = solution.longestCommonSubsequence(s1, s2);
		System.out.println("The length of the longest common substring is: " + result);
	}
}
