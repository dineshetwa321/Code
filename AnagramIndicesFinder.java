package a.string.imp;

import java.util.ArrayList;
import java.util.List;

/*
 * The "Anagram Indices Finder" problem involves finding all starting indices in a string where the substring is an anagram of
 *  a given pattern. This can be efficiently solved using the sliding window technique along with frequency counting.
 */
public class AnagramIndicesFinder {
	public static List<Integer> findAnagrams(String str, String palin) {
		List<Integer> result = new ArrayList<>();
		int sLen = str.length();
		int palinLen = palin.length();

		if (sLen < palinLen) {
			return result;
		}

		// Frequency arrays to count characters
		int[] palindCount = new int[26];
		int[] strCount = new int[26];
		// Initialize the frequency arrays with the first pLen characters
		for (int i = 0; i < palinLen; i++) {			
			palindCount[palin.charAt(i) - 'a'] = palindCount[palin.charAt(i) - 'a'] + 1;
			strCount[str.charAt(i) - 'a'] = strCount[str.charAt(i) - 'a'] + 1;
		}
		// Slide the window across the string s
		for (int i = 0; i < sLen - palinLen; i++) {
			// If the frequency arrays match, add the start index to the result

			if (matches(palindCount, strCount)) {
				result.add(i);
			}
			// Slide the window: update the counts
			strCount[str.charAt(i) - 'a']--;
			strCount[str.charAt(i + palinLen) - 'a']++;
		}
		// Check the last window
		if (matches(palindCount, strCount)) {
			result.add(sLen - palinLen);
		}
		return result;
	}
	// Helper function to compare two frequency arrays
	private static boolean matches(int[] pCount, int[] sCount) {
		for (int i = 0; i < 26; i++) {
			if (pCount[i] != sCount[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> anagramIndices = findAnagrams(s, p);
		System.out.println(anagramIndices); // Output: [0, 6]
	}
}
