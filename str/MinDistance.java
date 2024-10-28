package a.string;

//https://leetcode.com/problems/edit-distance/description/
class MinDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Base case: if one of the strings is empty
        if (m == 0) return n;
        if (n == 0) return m;

        // Initialize the previous row (base case for converting an empty word1)
        int[] previous = new int[n + 1];
        for (int j = 0; j <= n; j++) {
            previous[j] = j;
        }

        // Iterate through each character in word1
        for (int i = 1; i <= m; i++) {
            int[] current = new int[n + 1];
            current[0] = i;  // Base case: converting word1's prefix to empty word2

            // Iterate through each character in word2
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // If characters match, no operation needed
                    current[j] = previous[j - 1];
                } else {
                    // If characters don't match, consider the three operations: insert, delete, replace
                    current[j] = Math.min(previous[j - 1],  // Replace
                                Math.min(previous[j],      // Delete
                                         current[j - 1]))  // Insert
                                + 1;
                }
            }

            // Update previous row to current row for the next iteration
            previous = current;
        }

        return previous[n];  // The last value in previous[] holds the answer
    }
    
    public int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // Create a DP table of size (m+1) x (n+1)
        int[][] dp = new int[m + 1][n + 1];
        
        // Base cases: when one string is empty
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // All deletions
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // All insertions
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // No change needed
                } else {
                    dp[i][j] = Math.min(
                        dp[i - 1][j - 1], // Replace
                        Math.min(dp[i - 1][j], dp[i][j - 1]) // Delete or Insert
                    ) + 1;
                }
            }
        }
        
        return dp[m][n];
    }
}
