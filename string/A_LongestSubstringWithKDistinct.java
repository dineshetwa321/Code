package a.string;

import java.util.HashMap;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/solutions/1355862/longest-substring-with-at-most-k-distinct-characters/
public class A_LongestSubstringWithKDistinct {

	public static int longestSubstringWithKUniqueCharsGood(String s, int k) {
		if (s == null || s.length() == 0 || k == 0) {
			return 0;
		}

		// HashMap to store the frequency of characters in the current window
		HashMap<Character, Integer> charCountMap = new HashMap<>();
		int maxLength = 0;
		int left = 0;

		// Expand the window by moving the right pointer
		for (int right = 0; right < s.length(); right++) {
			char rightChar = s.charAt(right);
			charCountMap.put(rightChar, charCountMap.getOrDefault(rightChar, 0) + 1);

			// Shrink the window if the number of unique characters exceeds K
			while (charCountMap.size() > k) {
				char leftChar = s.charAt(left);
				charCountMap.put(leftChar, charCountMap.get(leftChar) - 1);
				if (charCountMap.get(leftChar) == 0) { 
					//DK we iterating N removing which have one occurence in the  charCountMap -
					//THink - in worse scnerion ,at lease last char will have 1 occurence which causes map size to be >k 
					charCountMap.remove(leftChar);
				}
				left++; // Move the left pointer to reduce the window size
			}

			// Update maxLength if the current window size is larger
			maxLength = Math.max(maxLength, right - left + 1);
		}

		return maxLength;
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		A_LongestSubstringWithKDistinct solution = new A_LongestSubstringWithKDistinct();

		String s = "eceba";
		int k = 2;

		int result = solution.longestSubstringWithKUniqueCharsGood(s, k);
		System.out.println(
				"The length of the longest substring with at most " + k + " distinct characters is: " + result);
	}

}
