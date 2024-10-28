package a.string;

public class MaxNumberWithKSwaps {
    // Variable to store the maximum number as a string
    static String maxNumber;

    // Function to find the maximum number possible by doing at most K swaps
    @SuppressWarnings("unused")
	public static void findMaximumNumber(char[] num, int k) {
        // Base case: if no swaps left, return
        if (k == 0) {
            return;
        }

        int n = num.length;
        int l=0;
        // Traverse the number array
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n && k>0; j++) {
                // Swap if the current digit is smaller than the next digit
                if (num[i] < num[j]) {
                    // Swap num[i] and num[j]
                    swap(num, i, j);

                    // Check if the new number is greater than the maxNumber
                    String currentNumber = new String(num);
                    if (currentNumber.compareTo(maxNumber) > 0) {
                        maxNumber = currentNumber;
                        k=k-1;
                    }

                    // Recur for the remaining swaps
             //       findMaximumNumber(num, k - 1);

                    // Backtrack: Swap back to restore the original array
                   // swap(num, i, j);
                    int nm =0; //DK
                }
            }
        }
    }

    // Utility function to swap two characters in a char array
    public static void swap(char[] num, int i, int j) {
        char temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args) {
        String number = "254";
        number="259";
        int k = 2;

        maxNumber = number;

        // Convert the string number to a character array
        char[] numArray = number.toCharArray();

        // Find the maximum number possible with at most K swaps
        findMaximumNumber(numArray, k);

        System.out.println("Maximum number possible after at most " + k + " swaps: " + maxNumber);
    }
}
