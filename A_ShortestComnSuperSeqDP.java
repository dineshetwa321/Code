package a.string.imp;


//https://www.youtube.com/watch?v=823Grn4_dCQ
//https://www.youtube.com/watch?v=xElxAuBcvsU	
//https://leetcode.com/problems/shortest-common-supersequence/
//https://www.geeksforgeeks.org/shortest-common-supersequence/
class A_ShortestComnSuperSeqDP {

	public static String shortestCommonSupersequenceStrBuffer(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        //Good 
        //https://www.youtube.com/watch?v=xElxAuBcvsU 
        // https://www.youtube.com/watch?v=823Grn4_dCQ
        // Step 1: Calculate the LCS using dynamic programming
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Step 2: Construct the SCS using the LCS with StringBuilder
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            // If characters match, add it once and move diagonally
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            }
            // If characters do not match, move in the direction of the larger value in dp
            else if (dp[i - 1][j] > dp[i][j - 1]) {
            	
                sb.append(str1.charAt(i - 1));
                i--;
            } else {
                sb.append(str2.charAt(j - 1));
                j--;
            }
        }

        // Add remaining characters of str1 and str2
        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }

        // Since we built the string from the end, we need to reverse it
        return sb.reverse().toString();
    }
	
	public static String shortestCommonSupersequenceDynaArray(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // Step 1: Calculate the LCS using dynamic programming
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp array for LCS length computation
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Step 2: Construct the shortest common supersequence
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;

      //TODO - see the LongestComSubstrNSeq 
        // Backtrack through the dp array to build the result
        while (i > 0 && j > 0) {
            // If characters match, include it in the result and move diagonally
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            }
            //TODO not read this 
            // If characters don't match, take the larger value direction
            else if (dp[i - 1][j] > dp[i][j - 1]) {
            //    sb.append(str1.charAt(i - 1));
                i--;
            } else {
             //   sb.append(str2.charAt(j - 1));
                j--;
            }
        }

        // Add remaining characters of str1 or str2 if any
        while (i > 0) {
          //  sb.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
        //    sb.append(str2.charAt(j - 1));
            j--;
        }

        // The result is built in reverse order, so reverse the string
        return sb.reverse().toString();
    }

    // Test the function
    public static void main(String[] args) {
        String str1 = "abac";
        String str2 = "cab";
        System.out.println(shortestCommonSupersequenceDynaArray(str1, str2));  // Output: "cabac"
        System.out.println(shortestCommonSupersequenceStrBuffer(str1, str2));  // Output: "cabac"
    }
}