package a.array.cond;
public class MaxDigitFrequency {

    public static void main(String[] args) {
        int[] nums = {123, 45, 678, 9, 345, 90};
        int[] result = findMaxDigitFrequency(nums);
        System.out.println("Digit: " + result[0] + ", Frequency: " + result[1]);
    }

    public static int[] findMaxDigitFrequency(int[] nums) {
        // Array to store frequency of each digit (0-9)
        int[] digitFreq = new int[10];

        // Step 1: Extract digits from each number and update frequencies
        for (int num : nums) {
            while (num > 0) {
                int digit = num % 10;  // Get the last digit
                digitFreq[digit]++;    // Increment its frequency
                num /= 10;             // Remove the last digit
            }
        }

        // Step 2: Find the digit with the maximum frequency
        int maxFreq = 0;
        int maxDigit = 0;
        for (int i = 0; i < 10; i++) {
            if (digitFreq[i] > maxFreq) {
                maxFreq = digitFreq[i];
                maxDigit = i;
            }
        }

        // Return the digit and its frequency
        return new int[]{maxDigit, maxFreq};
    }
}
