package a.string;
public class SubStrKMPAlgo {

    // KMP search algorithm to find the pattern in the text
    public static int KMPSearch(String pattern, String text) {
        int subStrLen = pattern.length();
        int strLen = text.length();

        // Create LPS array that will hold the longest prefix suffix values for the pattern
        int[] lps = computeLPSArray(pattern);

        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < strLen) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == subStrLen) {
                // Pattern found at index i - j
                return i - j;
            } else if (i < strLen && pattern.charAt(j) != text.charAt(i)) {
                // Mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1; // Pattern not found
    }

    // Method to compute the LPS array
    private static int[] computeLPSArray(String pattern) {
        int subStrLen = pattern.length();
        int[] lps = new int[subStrLen];
        int length = 0; // Length of the previous longest prefix suffix
        int i = 1;

        lps[0] = 0; // LPS[0] is always 0

        while (i < subStrLen) {
        	System.out.println("pattern.charAt(i) :"+pattern.charAt(i));
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

//    indexOf()/lastIndexOf(): These methods check the position of the substring. If found, the position will be non-negative.
//    contains/ matches(): Uses regular expressions to check if the substring exists.
//    regionMatches(): Compares specific parts of the string to the substring manually.
    
    public static void main(String[] args) {
        String text = "abxabcabcaby";
        String pattern = "abcaby";

        int index = KMPSearch(pattern, text);

        if (index != -1) {
            System.out.println("Pattern found at index: " + index);
        } else {
            System.out.println("Pattern not found in the text.");
        }
    }
}
