package a.string.imp;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//any word have same set of char in any seq

//TODO do with hashmap -https://www.youtube.com/watch?v=G6Ae4EJXNyk 
public class AnagramCheck2StrGood {

	@SuppressWarnings("unused")
	public static boolean areAnagrams(String str1, String str2) {
		// If lengths are different, they cannot be anagrams
		if (str1.length() != str2.length()) {
			return false;
		}

		// Create a frequency array to count character occurrences
		int[] charCount = new int[26]; // Assuming the input strings contain only lowercase alphabets
		// Increment the count for each character in the first string
		for (int i = 0; i < str1.length(); i++) {

			int a = 'a';// ascii value //char aa = 'a';
			int aaa = str1.charAt(i);
			char aa = str1.charAt(i);

			int arr = str1.charAt(i) - 'a';
			// DK - increasing the value to that char array index to no of times char coming
			charCount[str1.charAt(i) - 'a'] = charCount[str1.charAt(i) - 'a'] + 1;
		}

		// Decrement the count for each character in the second string
		for (int i = 0; i < str2.length(); i++) {
			charCount[str2.charAt(i) - 'a']--;
		}

		return Arrays.stream(charCount).sum() > 0 ? false : true;

	}

	public static void main(String[] args) {
		String str1 = "listen";
		String str2 = "silent";

		if (areAnagrams(str1, str2)) {
			System.out.println(str1 + " and " + str2 + " are anagrams.");
		} else {
			System.out.println(str1 + " and " + str2 + " are not anagrams.");
		}

		if (areAnagramsBySortDK(str1, str2)) {
			System.out.println(str1 + " and " + str2 + " are anagrams.");
		} else {
			System.out.println(str1 + " and " + str2 + " are not anagrams.");
		}
	}

	public static boolean areAnagramsBySortDK(String str1, String str2) {

		if (str1.length() == str2.length()) {

			char[] charStr1 = str1.toCharArray();
			char[] charStr2 = str2.toCharArray();

			Arrays.sort(charStr1);
			Arrays.sort(charStr2);

			if (Arrays.equals(charStr1, charStr2)) {

				return true;
			}

		}

		return false;

	}

	
	public static boolean areAnagramsByJava8Map(String str1, String str2) {
		// If lengths are different, they cannot be anagrams
		if (str1.length() != str2.length()) {
			return false;
		}

		// Create a frequency map for the first string
		Map<Character, Long> frequencyMap1 = str1.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		// Create a frequency map for the second string
		Map<Character, Long> frequencyMap2 = str2.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		// Compare the two frequency maps
		return frequencyMap1.equals(frequencyMap2);
	}
	
	//TODO not good 
	public static boolean areAnagramsDK(String str1, String str2) {

		char chArr[] = str1.toCharArray();

		if (str1.length() != str2.length()) {
			return false;
		}

		for (Character ch : chArr) {
			// issue is here for every char -contain will call for loop intrnally
			if (!str2.contains(ch.toString())) {
				return false;
			}

		}

		return true;
	}


}
