package a.string.imp;

//https://www.digitalocean.com/community/tutorials/longest-palindrome-substring-string-java
//https://chat.openai.com/c/b9eb40b3-15f4-4577-a488-e1e055eda3cd
public class PalindromFindLongestStr {

	/*
	 * This program defines a method findLongestPalindrome that takes a string as
	 * input and returns the longest palindromic substring. It utilizes the
	 * expandAroundCenter method to expand around each character and check if it
	 * forms a palindrome. The main method tests this function with a sample string
	 * and prints the result. You can change the value of str in the main method to
	 * test other strings.
	 */
	public static void main(String[] args) {
		//System.out.println("\nLongest Palindrome :" + longestPalindromeString("1221"));
//		System.out.println(longestPalindromeString("12321"));
//		System.out.println(longestPalindromeString("9912321456"));
//		System.out.println(longestPalindromeString("9912333321456"));
//		System.out.println(longestPalindromeString("12145445499"));
 		System.out.println(longestPalindromeString("abccccdd1111111"));

	//	System.out.println(longestPalindromeString("aba"));

		// System.out.println(longestPalindromeString("aba"));
	}

	// https://chat.openai.com/c/b9eb40b3-15f4-4577-a488-e1e055eda3cd

	// O(n^2)
	public static String longestPalindromeString(String s) {
		if (s == null)
			return null;

		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length() - 1; i++) {

			// Expand around a single character (odd-length palindrome)

			// odd cases like 121 , here i point to 2
			String palindrome = expandAroundCenter(s, i, i);

			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
			System.out.println("Odd palindrome :" + longest);

			// Expand around a pair of characters (even-length palindrome)
			// if char in string is even like here 4 char we have in 1221 OR abba
			palindrome = expandAroundCenter(s, i, i + 1); // this is for i and i+1 is 22 in 1231 here left is 2 and
															// right is 32 so

			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
			System.out.println("Even palindrome :" + longest);
		}
		return longest;
	}

	// 1221
	static public String expandAroundCenter(String s, int left, int right) {
		System.out.println("left right Orig String " + left + ":" + right + ":" + s);
		while (left >= 0 && right < s.length()) {
			if (s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			} else {
				break;
			}
		}
		String substring = s.substring(left + 1, right);
		System.out.println("substring :" + substring);
		return substring;
	}

}