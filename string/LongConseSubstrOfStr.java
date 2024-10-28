package a.string;
public class LongConseSubstrOfStr {
    public static void main(String[] args) {
        String input = "ababcdefxyz";
        System.out.println("Longest Consecutive Substring: " + longestConsecutiveSubstring(input));
    }

    //https://leetcode.com/problems/longest-consecutive-sequence/
    public static String longestConsecutiveSubstring(String s) {
        if (s == null || s.length() == 0) return "";

        int maxLength = 1;
        int maxStart = 0;

        int currentLength = 1;
        int currentStart = 0;

        for (int i = 1; i < s.length(); i++) {
            // Check if current character is consecutive to the previous one s.charAt(i) will give int value
            if (s.charAt(i) == s.charAt(i - 1) + 1) {
                currentLength++;
            } else {
                //DK-v imp- If the current sequence is longer than the max, update max values
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxStart = currentStart;
                }
                // Reset current sequence
                currentStart = i;
                currentLength = 1;
            }
        }

        // Final check in case the longest sequence is at the end
        if (currentLength > maxLength) {
            maxLength = currentLength;
            maxStart = currentStart;
        }

        return s.substring(maxStart, maxStart + maxLength);
    }
}
