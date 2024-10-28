package a.string.imp;

public class PalindromeLongestNumber {
	public static void main(String[] args) {
		int lowerBound = 100; // Change the lower bound of the range
		int upperBound = 1000; // Change the upper bound of the range

		int longestPalindrome = findLongestPalindrome(lowerBound, upperBound);

		System.out.println("The longest palindrome number between " + lowerBound + " and " + upperBound + " is: "
				+ longestPalindrome);
	}

	public static int findLongestPalindrome(int lowerBound, int upperBound) {
		int longestPalindrome = 0;

		String pal = "";
		for (int i = upperBound; i >= lowerBound; i--) {
			if (isPalindrome(i)) {
				pal = pal + i + " : ";
				if (i > longestPalindrome) {
					longestPalindrome = i;

				}
			}
		}
		System.out.println("All palindrome number between " + lowerBound + " and " + upperBound + " is: " + pal);

		return longestPalindrome;
	}

	// DK - for any number 
	public static boolean isPalindrome(int number) {
		int originalNumber = number;
		int reversedNumber = 0;		 
		while (number > 0) {
			int digit = number % 10;
			reversedNumber = reversedNumber * 10 + digit;
			number /= 10;
		}

		return originalNumber == reversedNumber;
	}
}
