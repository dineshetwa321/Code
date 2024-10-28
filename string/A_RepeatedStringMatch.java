package a.string;

//https://leetcode.com/problems/repeated-string-match
class A_RepeatedStringMatch {
	public static int repeatedStringMatch(String a, String b) {
		// Start with 1 repetition of 'a'
		StringBuilder repeatedA = new StringBuilder(a);
		int count = 0;

		// Repeat 'a' until its length is at least as long as 'b'
		while (repeatedA.length() < b.length()) {
			repeatedA.append(a);
			count++;
		}

		//TODO this will not ask
		// Check if 'b' is now a substring
		if (repeatedA.toString().contains(b)) {
			return count;
		}

		// Append 'a' one more time and check again
		repeatedA.append(a);
		count++;

		if (repeatedA.toString().contains(b)) {
			return count;
		}

		// If 'b' is still not found as a substring, return -1
		return -1;
	}

	public static void main(String[] args) {
//		String str1 = "abac";
//		String str2 = "cab";

		String str1 = "abcd";
		String str2 = "cdabcdab";

		System.out.println(repeatedStringMatch(str1, str2)); // Output: "cabac"
		// System.out.println(shortestCommonSupersequenceStrBuffer(str1, str2)); //
		// Output: "cabac"
	}

	public static int repeatedStringMatchDK(String a, String b) {
		// Start with 1 repetition of 'a'
		StringBuilder repeatedA = new StringBuilder(a);
		int count = 0;

		// Repeat 'a' until its length is at least as long as 'b'
		while (repeatedA.length() < b.length()) {
			repeatedA.append(a);
			count++;
		}

		while(! repeatedA.toString().contains(b)) {
			
		}
		// Check if 'b' is now a substring
		if (repeatedA.toString().contains(b)) {
			return count;
		}

		// Append 'a' one more time and check again
		repeatedA.append(a);
		count++;

		if (repeatedA.toString().contains(b)) {
			return count;
		}

		// If 'b' is still not found as a substring, return -1
		return -1;
	}
}
