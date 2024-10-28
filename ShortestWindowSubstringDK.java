package a.string.imp;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-window-substring/description/ 
//https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
public class ShortestWindowSubstringDK {

	public static void main(String[] args) {
		ShortestWindowSubstringDK solution = new ShortestWindowSubstringDK();
//		String s = "ADOBECODEBANC";
//		String t = "ABC";

//		String s = "ABCBDAB";
//        String t = "BDCAB";
        
        String s = "ADOBECODEBANC"; String t = "ABC";
        		
//        String s = "ADAABECF";
//		String t = "ABC";

//		String s = "ADAABECF";
//		String t = "ABC";
		System.out.println(solution.minWindowDK(s, t)); // Output: "BANC"

		System.out.println(solution.minWindowDK(s, t)); // Output: "BANC"
	}

	public String minWindowDK(String s, String t) {

		if (s == null || t == null || s.length() < t.length()) {
			return "";
		}

		Map<Character, Integer> actualMapSize = new HashMap<>();
		Map<Character, Integer> window = new HashMap<>();

		for (char c : t.toCharArray()) {
			actualMapSize.put(c, actualMapSize.getOrDefault(c, 0) + 1);
		}

		int actualMapCount = actualMapSize.size();
		int left = 0, right = 0;
		int neededCharCount = 0;
		int start = 0, minLen = Integer.MAX_VALUE;

		String shortWindow = "";
		String shortWindowStored = "";

		// https://www.youtube.com/watch?v=Oi09pnLLy78
		while (right < s.length()) {
			char c = s.charAt(right);

			if (!shortWindow.equals("")) {
				shortWindow = shortWindow + c;
			}
			// A- add char in map one by one V imp step
			if (actualMapSize.containsKey(c)) {

				if (shortWindow.equals("")) {
					shortWindow = "" + c;
				}

				window.put(c, window.getOrDefault(c, 0) + 1);
				if (window.get(c).intValue() == actualMapSize.get(c).intValue()) {
					neededCharCount++;
					// shortWindow=shortWindow+c;
				}
			}

			// String s = "ADOBECODEBANC";
			// String t = "ABC";
			// B- Keep checking that we got 1st sub str
			while (neededCharCount == actualMapCount) { // reducing the window from left

				System.out.println("window :" + window.toString());
				// System.out.println("s.substring(start, start + minLen) :"+s.substring(start,
				// start + minLen));
				// C- keep checking here if window can be shortened
				char lastLeftChar = shortWindow.charAt(0);
				// left++;

				// removing this one char from window to check if this can be shorten
				if (!actualMapSize.containsKey(lastLeftChar)) {
					shortWindow = shortWindow.substring(1, shortWindow.length());
					continue;
				}
				window.put(lastLeftChar, window.get(lastLeftChar) - 1);
				// TODO this 2 line sequence is v imp OR see the comneted one
				if (window.get(lastLeftChar).intValue() > actualMapSize.get(lastLeftChar).intValue()) {
					// neededCharCount--;
					shortWindow = shortWindow.substring(1, shortWindow.length());
				} else if (window.get(lastLeftChar).intValue() == actualMapSize.get(lastLeftChar).intValue()) {
					shortWindow = shortWindow.substring(1, shortWindow.length());

					if (!shortWindowStored.equals("") && shortWindow.length() < shortWindowStored.length()) {
						shortWindowStored = shortWindow;
					} else {
						shortWindowStored = shortWindow;
					}
					neededCharCount = 0;
					shortWindow = "";
					window = new HashMap<>();
					break;
				} else {
					// window have expact match - cn no shorted
					if (!shortWindowStored.equals("") && shortWindow.length() < shortWindowStored.length()) {
						shortWindowStored = shortWindow;
					} else {
						shortWindowStored = shortWindow;
					}
					neededCharCount = 0;
					shortWindow = "";
					window = new HashMap<>();
					// window.put(lastLeftChar, window.get(lastLeftChar)+1);
					break;
				}
				// D lastLeftChar have more in sub string and so can reduce
				// window.put(lastLeftChar, window.get(lastLeftChar)-1);

				left++;
			}

			// right++;
			right++;
		}
		return shortWindowStored;
		// String sr =s.substring(start, start + minLen);
		// return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);

	}
}
