package a.queue;
import java.util.Arrays;

public class HighestOccurringDigitInPrimes {

    // Method to generate prime numbers in the given range
    public static boolean[] sieveOfEratosthenes(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime numbers

        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    // Method to count digit occurrences in a prime number
    public static void countDigitOccurrences(int number, int[] digitCount) {
        while (number > 0) {
            int digit = number % 10;
            digitCount[digit]++;
            number /= 10;
        }
    }

    // Method to find the highest occurring digit in prime numbers within a given range
    public static int findHighestOccurringDigitInPrimes(int start, int end) {
        
    	boolean[] isPrime = sieveOfEratosthenes(end);
        
        int[] digitCount = new int[10]; // Array to hold digit counts (0-9)

        // Iterate over the range and count digits in prime numbers
        //2, 3, 5, 7, 11, 13, 17, 19
        for (int i = start; i <= end; i++) {
            if (isPrime[i]) {
                countDigitOccurrences(i, digitCount);
            }
        }

        // Find the digit with the maximum occurrence
        int maxDigit = 0;
        int maxCount = digitCount[0];
        for (int i = 1; i < 10; i++) {
            if (digitCount[i] > maxCount) {
                maxDigit = i;
                maxCount = digitCount[i];
            }
        }

        return maxDigit;
    }

    public static void main(String[] args) {
        int start = 2;
        int end = 20;
        int highestOccurringDigit = findHighestOccurringDigitInPrimes(start, end);
        System.out.println("The highest occurring digit in prime numbers between " + start + " and " + end + " is: " + highestOccurringDigit);
    }
}
