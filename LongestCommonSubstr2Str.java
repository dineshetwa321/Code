package a.string.imp;

//https://leetcode.com/discuss/interview-question/1273766/longest-common-substring

	
public class LongestCommonSubstr2Str {

    public int longestCommonSubstring(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Create a 2D DP array to store the length of common substrings
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;

        //TODO this is same as  LongestLengthOfRepeatedSubarray.java file 
         
        // Iterate over each character in both strings
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the characters match, update dp[i][j]
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;                    
                    maxLength = Math.max(maxLength, dp[i][j]);                   
                } else {
                    dp[i][j] = 0;  // No common substring ends at these positions
                }
            }
        }      
        return maxLength;
    }

    public static void main(String[] args) {
    	LongestCommonSubstr2Str solution = new LongestCommonSubstr2Str();
        
        String s1 = "abcde";
        String s2 = "ace";
       
        		
        int result = solution.longestCommonSubstring(s1, s2);
        System.out.println("The length of the longest common substring is: " + result);
    }
}
