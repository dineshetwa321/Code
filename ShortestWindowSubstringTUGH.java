package a.string.imp;

import java.util.HashMap;

//https://leetcode.com/problems/minimum-window-substring/description/ 
//https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
public class ShortestWindowSubstringTUGH {
	
	public String minWindow(String windowStr, String targetStr) {
        if (windowStr == null || targetStr == null || windowStr.length() < targetStr.length()) {
            return "";
        }
        
        // HashMap to store the count of characters in t
        HashMap<Character, Integer> requiredCharMap = new HashMap<>();
        for (char c : targetStr.toCharArray()) {
            requiredCharMap.put(c, requiredCharMap.getOrDefault(c, 0) + 1);
        }
        
        // Variables to track the window
        int left = 0, right = 0, formed = 0;
        int minLength = Integer.MAX_VALUE, minLeft = 0, minRight = 0;
        HashMap<Character, Integer> slideWindowMap = new HashMap<>();
        
        // Number of unique characters in t that must be in the window
        int requiredSize = requiredCharMap.size();
        
        // Sliding window
        while (right < windowStr.length()) {
            // Add one character from the right of the window
            char rightChar = windowStr.charAt(right);
            slideWindowMap.put(rightChar, slideWindowMap.getOrDefault(rightChar, 0) + 1);
            
            // If the current character's count matches its required count in t
            if (requiredCharMap.containsKey(rightChar) && slideWindowMap.get(rightChar).intValue() == requiredCharMap.get(rightChar).intValue()) {
                formed++;
            }            
            // Try to contract the window until it's no longer valid
            while (left <= right && formed == requiredSize) {
                char leftChar = windowStr.charAt(left);                
                // Update the result if this window is smaller than the previous best
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                    minRight = right;
                }                
                // Remove the character at the left pointer from the window
                slideWindowMap.put(leftChar, slideWindowMap.get(leftChar) - 1);
                if (requiredCharMap.containsKey(leftChar) && slideWindowMap.get(leftChar) < requiredCharMap.get(leftChar)) {
                    formed--;
                }
                left++;//Move the left pointer to shrink the window
            }            
            // Move the right pointer to expand the window
            right++;
        }
        
        // Return the smallest valid window or an empty string if no valid window is found
        return minLength == Integer.MAX_VALUE ? "" : windowStr.substring(minLeft, minRight + 1);
    }
	public static void main(String[] args) {
		ShortestWindowSubstringTUGH solution = new ShortestWindowSubstringTUGH();
//		String s = "ADOBECODEBANC";
//		String t = "ABC";

//		String s = "ABCBDAB";
//        String t = "BDCAB";
        
        String s = "ADOBECODEBANC"; String t = "ABC";
        		
//        String s = "ADAABECF";
//		String t = "ABC";

//		String s = "ADAABECF";
//		String t = "ABC";
		System.out.println(solution.minWindow(s, t)); // Output: "BANC"		

	//	System.out.println(solution.minWindowDK(s, t)); // Output: "BANC"
	} 
	
}
