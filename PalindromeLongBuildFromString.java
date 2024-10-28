package a.string.imp;
import java.util.HashMap;
import java.util.Map;

public class PalindromeLongBuildFromString {
    public static void main(String[] args) {
        String input = "abccccdd1111111";
        System.out.println("Longest Possible Palindrome: " + createLongestPalindrome(input));
    }

    public static String createLongestPalindrome(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        StringBuilder halfPalindrome = new StringBuilder();
        Character middleChar = null;

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();

            // Add half of the characters with even counts to the halfPalindrome
            for (int i = 0; i < count / 2; i++) {
                halfPalindrome.append(c);
            }
            // Track the character with the highest odd count for the middle of the palindrome
            if (count % 2 != 0) {
                if (middleChar == null || count > charCount.get(middleChar)) {
                    middleChar = c;
                }
            }
        }
        // Create the full palindrome by combining the halfPalindrome, middleChar, and the reverse of the halfPalindrome
        String palindrome = halfPalindrome.toString() + (middleChar != null ? middleChar : "") + 
        		halfPalindrome.reverse().toString();

        return palindrome;
    }
}
