package a.array;

//https://www.youtube.com/watch?v=m4AOIKV3b9Y

//https://www.youtube.com/watch?v=Zg3HBicw4LU

//Longest Common Substring | Dynamic Programming | 
//Below one is good//
//https://www.youtube.com/watch?v=hj-HDHwifWs
 
public class LongestLengthOfRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        // Create a 2D dp array to store the length of common subarrays
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;
       
        //TODO this is same as  LongestCommonSubstring.java file
    	// Below one is good//
		// https://www.youtube.com/watch?v=hj-HDHwifWs
		 //Super sequense ShortestCommonSupersequence
		// LongestLengthOfRepeatedSubarray LongestComSubstrNSeq
        
        // Iterate through each element in nums1 and nums2
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
            	System.out.println( dp[m][n]); 
                // If the current elements of nums1 and nums2 match
                if (nums1[i - 1] == nums2[j - 1]) {
                	System.out.println( nums1[i - 1] ); 
                    // Update dp[i][j] to be one more than dp[i-1][j-1] - //TODO DL think and see the vedio 
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    // Track the maximum length of the repeated subarray
                    maxLength = Math.max(maxLength, dp[i][j]);                    
                }
            }
        }        
        return maxLength;
    }

    public static void main(String[] args) {
        LongestLengthOfRepeatedSubarray solution = new LongestLengthOfRepeatedSubarray();
        
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        
        //[[0, 0, 0, 0, 0, 0], [0, 0, 0, 1, 0, 0], [0, 0, 1, 0, 0, 0], [0, 1, 0, 0, 0, 0], [0, 0, 2, 0, 0, 0], [0, 0, 0, 3, 0, 0]]
        int result = solution.findLength(nums1, nums2);
        System.out.println("Maximum length of repeated subarray: " + result);
    }
}
