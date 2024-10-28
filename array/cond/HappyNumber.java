package a.array.cond;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/happy-number/description/

public class HappyNumber {

	public static boolean isHappy(int n) {
		Set<Integer> seen = new HashSet<>();

		while (n != 1 && !seen.contains(n)) {
			seen.add(n);
			n = getNext(n);
		}

		return n == 1;
	}

	/*
	 *Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false
	 */
	private static int getNext(int n) {
		int sum = 0;
		while (n > 0) {
			int digit = n % 10;
			sum += digit * digit;
			n /= 10;
		}

		return sum;
	}

	public static void main(String[] args) {
		int n1 = 19;
		System.out.println(n1 + " is happy: " + isHappy(n1)); // Output: true

		int n2 = 2;
		System.out.println(n2 + " is happy: " + isHappy(n2)); // Output: false
	}
}
