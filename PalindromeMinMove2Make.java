package a.string.imp;

public class PalindromeMinMove2Make {

    public static int minMovesToMakePalindrome(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        int movesCount = 0;

        while (left < right) {
            // Initialize right pointer to search for a match for arr[left]
            int l_swap = left, r_swap = right;
           // String s = "mamad";
            //A- Find the matching character for arr[left] by moving r towards left
            while (arr[l_swap] != arr[r_swap]) {
                r_swap--;
            }
            // B- If r matches l exactly, it means arr[l] is a unique character 
            // and should be placed in the middle
            if (l_swap == r_swap) {
                // Swap the unmatched character towards the middle
                swap(arr, l_swap, l_swap + 1);
                movesCount++;
                continue;
            }
            // Now move arr[r] to arr[right] by logically counting the swaps needed
            // (without performing the actual swaps)
            for (int k = r_swap; k < right; k++) {
                swap(arr, k, k + 1);
                movesCount++;
            }
            // Move both pointers inward after fixing the current pair
            left++;
            right--;
        }
        return movesCount;
    }

    // Helper method to swap two characters in the array
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        String s = "mamad";
        int result = minMovesToMakePalindrome(s);
        System.out.println("Minimum number of moves to make palindrome: " + result);  // Output: 3
    }
}
