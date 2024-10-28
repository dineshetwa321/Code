package a.string;

import java.util.HashSet;
import java.util.Set;

public class A_LongestSubstringWdoutRepeat4mStr {
	public int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();
		int maxLength = 0, i = 0, j = 0;

		while (j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j));
				j++;
				maxLength = Math.max(maxLength, j - i);
			} else {
				set.remove(s.charAt(i));
				i++;
			}
		}

		return maxLength;
	}

	@SuppressWarnings("unused")
	public int lengthOfLongestSubstring_DK(String s) {
		Set<Character> set = new HashSet<>();
		int maxLength = 0, i = 0, j = 0;
		while (j < s.length()) {
			//System.out.println(set);
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j));
				j++;
				maxLength = Math.max(maxLength, set.size());
			} else {
				set = new HashSet<>();				 
			}
		}
		return maxLength;
	}
	
	public static void main(String[] args) {
		A_LongestSubstringWdoutRepeat4mStr solution = new A_LongestSubstringWdoutRepeat4mStr();
		String s = "abcabcbb";
		
		s="bbbbb";
		System.out.println("Length of the longest substring without repeating characters DK: "
				+ solution.lengthOfLongestSubstring_DK(s));
		
		System.out.println("Length of the longest substring without repeating characters: "
				+ solution.lengthOfLongestSubstring(s));
	}
}
