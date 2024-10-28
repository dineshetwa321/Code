package a.array.cond;

import java.util.Arrays;

public class MinTapWater {
	
    public static int minTapsDP(int n, int[] ranges) {
        // dp[i] represents the minimum number of taps needed to water up to position i
        int[] dp = new int[n + 1];
        
        // Initialize dp with a large number (infinity-like)
        Arrays.fill(dp, n + 2);  // n+2 is used as infinity since at most we need n+1 taps
        dp[0] = 0;  // No taps are needed to water up to 0
        
        // Iterate through each tap and update the dp array based on the range it can cover
        for (int i = 0; i <= n; i++) {
            int left = Math.max(0, i - ranges[i]);  // Left bound of the range the tap can water
            int right = Math.min(n, i + ranges[i]); // Right bound of the range the tap can water
            
            // Update the dp array for all positions that this tap can cover
            for (int j = left; j <= right; j++) {
                dp[j] = Math.min(dp[j], dp[left] + 1);
            }
            System.out.println("maxRange :" +Arrays.toString(dp ));
        }
        
        // If dp[n] is still a large number, it means the garden cannot be fully watered
        return dp[n] == n + 2 ? -1 : dp[n];
    }
    
    
    public static int minTaps(int n, int[] arrOfTapRanges) {
        // Step 1: Create an array to store the farthest point each tap can cover
        int[] maxRange = new int[n + 1];
        
        int tapsOpened = 0, currEnd = 0, farthest = 0; 
        //int[]  ranges = {4,3,5,0,0,5 };
        // Step 2: Fill in maxRange, where maxRange[i] tells the farthest point tap i can cover
        for (int i = 0; i < n+1; i++) {
            int left = Math.max(0, i - arrOfTapRanges[i]); //  Left bound of the range the tap can water
            int right = Math.min(n, i + arrOfTapRanges[i]);//  right bound of the range the tap can water 
            maxRange[left] = Math.max(maxRange[left], right);
        }
        System.out.println("maxRange A:" +Arrays.toString(maxRange ));
      //DK with 2 for loop easy 2 explain 
        int i = 0;
        // Step 4: Loop through the garden positions to cover the range
        while (i <= n && currEnd < n) {        	
            while (i <= n && i <= currEnd) {
                farthest = Math.max(farthest, maxRange[i]);
                i++;
            }
            if (currEnd == farthest) {
                return -1; // If we can't move forward, it's impossible to water the entire garden
            }            
            tapsOpened++;
            currEnd = farthest;
        }
        return tapsOpened;
        // Step 3: Initialize variables to track the current end of coverage
      //  int taps = 0, currEnd = 0, farthest = 0;
        
        // Step 4: Loop through the garden positions to cover the range
//        for (int i = 0; i <= n; i++) {
//        	
//        	 // Always extend the farthest point we can cover
//            farthest = Math.max(farthest, maxRange[i]);
//            
//            if(farthest<n) {
//            	currEnd = farthest;
//            }
//            // If we have reached the end of the current coverage, increment the tap count
//            if (i > farthest) {
//                return -1; // If we can't cover position i, it's impossible to water the whole garden
//            }
//            if (i > currEnd) {
//                // We need a new tap to extend the range
//            	tapsOpened++;
//                currEnd = farthest; // Move the current coverage end to the farthest we've seen
//            }
//            // Always extend the farthest point we can cover
//            //farthest = Math.max(farthest, maxRange[i]);
//        }
        
        
         
    }
    
    public static void main(String[] args) {
	//	int[]  ranges = {3, 4, 1, 1, 0, 0 };
		int[]  ranges = {4,3,5,0,0,5 };
		 System.out.println("Maximum Tap A : " + minTaps(ranges.length-1,ranges)); // Output: 3

		//int[]  ranges = {3, 4, 1, 1, 0, 0 };
	//	System.out.println("Maximum Tap B : " + minTapsDP(ranges.length-1,ranges)); // Output: 3
		
	}
    

   
}
