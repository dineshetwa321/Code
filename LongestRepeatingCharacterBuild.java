package a.string.imp;

import java.util.HashMap;

//https://leetcode.com/problems/longest-repeating-character-replacement/
class LongestRepeatingCharacterBuild {
	public static int characterReplacement(String str, int replaceCount) {
		int[] count = new int[26]; // Frequency of each letter in the current window
		int maxFreqCharCount = 0; // The count of the most frequent character in the current window
		int left = 0; // Left pointer of the sliding window
		int maxLength = 0; // Maximum length of the valid window 
	 
		for (int right = 0; right < str.length(); right++) {
			// Increase the count of the current character  
			count[str.charAt(right) - 'A'] = count[str.charAt(right) - 'A'] + 1; 
			// Update maxCount to the highest frequency in the current window
			maxFreqCharCount = Math.max(maxFreqCharCount, count[str.charAt(right) - 'A']);
 
			//https://algo.monster/liteproblems/424 
			int windowCnt= right - left + 1;		 
			if (windowCnt > replaceCount+ maxFreqCharCount) { 
				// If it's invalid, we shrink the window from the left
				count[str.charAt(left) - 'A']--;
				windowCnt--;
				left++;
			} 
			// Update the maxLength with the valid window size
			maxLength = Math.max(maxLength, right - left + 1);
		}

		return maxLength;
	}

	public static void main(String[] args) {

		String str = "ABAB";
		int k = 2; // Output: 4

//		String str = "AABABBA";
//		int k = 1; // Output: 4

		System.out.println(characterReplacement(str, k));

	}

	 public int characterReplacementHashMap(String s, int k) {
	        HashMap<Character, Integer> countMap = new HashMap<>();
	        int maxLength = 0;
	        int maxCount = 0;  // Store the count of the most frequent character in the window
	        int left = 0;

	        // Sliding window: expand with 'right'
	        for (int right = 0; right < s.length(); right++) {
	            char rightChar = s.charAt(right);
	            countMap.put(rightChar, countMap.getOrDefault(rightChar, 0) + 1);
	            
	            // Track the most frequent character count in the window
	            maxCount = Math.max(maxCount, countMap.get(rightChar));
	            
	            // If the number of replacements needed (window size - maxCount) exceeds k, shrink the window
	            while ((right - left + 1) - maxCount > k) {
	                char leftChar = s.charAt(left);
	                countMap.put(leftChar, countMap.get(leftChar) - 1);
	                left++;  // Shrink the window from the left
	            }

	            // Update the maximum length of a valid window
	            maxLength = Math.max(maxLength, right - left + 1);
	        }

	        return maxLength;
	    }
	 
	 public int characterReplacementHashMapDK(String s, int k) {
	        HashMap<Character, Integer> countMap = new HashMap<>();
	        int maxLength = 0;
	        int maxCount = 0;  // Store the count of the most frequent character in the window
	        int left = 0;

	        // Sliding window: expand with 'right'
	        for (int right = 0; right < s.length(); right++) {
	            char rightChar = s.charAt(right);
	            int charCount=countMap.get(rightChar);
	            
	             
	            if(charCount==0 && countMap.size() !=1) {
	            	countMap.put(rightChar, charCount);	            	
	            }
	            if(countMap.size()>2) {
	            	
	            }
	            
	            
	            countMap.put(rightChar, countMap.getOrDefault(rightChar, 0) + 1);
	            
	            // keep adond 0 - 
	            // Track the most frequent character count in the window
	            maxCount = Math.max(maxCount, countMap.get(rightChar));
	            
	            // If the number of replacements needed (window size - maxCount) exceeds k, shrink the window
	            while ((right - left + 1) - maxCount > k) {
	                char leftChar = s.charAt(left);
	                countMap.put(leftChar, countMap.get(leftChar) - 1);
	                left++;  // Shrink the window from the left
	            }

	            // Update the maximum length of a valid window
	            maxLength = Math.max(maxLength, right - left + 1);
	        }

	        return maxLength;
	    }
}
