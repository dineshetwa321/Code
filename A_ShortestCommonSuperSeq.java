package a.string.imp;

//https://gist.github.com/SuryaPratapK/421f34d2a47af0bd483bd2b2f3ea6753 
//https://www.youtube.com/watch?v=pHXntFeu6f8

// see this ShortestComnSuperSeqGood 
class A_ShortestCommonSuperSeq {
	static String findLCS(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		String[][] dp = new String[len1 + 1][len2 + 1];
		// this will give longest common string

		for (int i = 0; i <= len1; ++i) {
			for (int j = 0; j <= len2; ++j) {

				if (i == 0 || j == 0) {
					dp[i][j] = "";
				}
				// else if(str1.charAt(i-1).equ==str2[j-1])
				else if (String.valueOf(str1.charAt(i - 1)).equals(String.valueOf(str2.charAt(j - 1)))) {
					dp[i][j] = dp[i - 1][j - 1] + String.valueOf(str1.charAt(i - 1));
				} else {
					//System.out.println(" dp[i][j - 1]  dp[i-1][j] -->" + dp[i][j - 1] + ":" + dp[i - 1][j]);
					// in super case diagoinal num + max of (dp[i][j - 1] : dp[i - 1][j])
					dp[i][j] = dp[i][j - 1].length() > dp[i - 1][j].length() ? dp[i][j - 1] : dp[i - 1][j];
				}
			}
		}

		// TODO DK working
//		Arrays.fill(dp, "");
//		//dp[0][0] = "";
//		for (int i = 1; i <= len1; ++i) {
//			for (int j = 1; j <= len2; ++j) {
//				if (String.valueOf(str1.charAt(i - 1)).equals(String.valueOf(str2.charAt(j - 1))))
//					dp[i][j] = dp[i - 1][j - 1] + String.valueOf(str1.charAt(i - 1));
//				else
//					dp[i][j] = dp[i][j - 1].length() > dp[i - 1][j].length() ? dp[i][j - 1] : dp[i - 1][j];
//			}
//		}

		System.out.println("dp[len1][len2] : " + dp[len1][len2]);
		return dp[len1][len2];
	}

	static String shortestCommonSupersequence(String str1, String str2) {
		String ans = "";
		String lcs = findLCS(str1, str2);

		int p1 = 0, p2 = 0;
		for (char ch : lcs.toCharArray()) {
			while (str1.charAt(p1) != ch) // Add all non-LCS chars from str1
			{
				ans += str1.charAt(p1);
				p1++;
			}

			while (str2.charAt(p2) != ch) // Add all non-LCS chars from str2
			{
				ans += str2.charAt(p2);
				p2++;
			}

			ans += ch; // Add LCS-char and increment both ptrs
			++p1;
			++p2;
		}
		// ans += str1.substr(p1) + str2.substr(p2);
		ans += str1.substring(p1) + str2.substring(p2);
		return ans;
	}

	// Test the function
	public static void main(String[] args) {
		String str1 = "abac";
		String str2 = "cab";
		System.out.println(shortestCommonSupersequence(str1, str2)); // Output: "cabac"
		// System.out.println(shortestCommonSupersequenceStrBuffer(str1, str2)); //
		// Output: "cabac"
	}
}