package a.array;

public class PrimeAdd {

	// Function to check if a number is prime
	public static boolean isPrime(int n) {

		if (n <= 1)
			return false; // 0 and 1 are not prime numbers
		if (n == 2 || n == 3)
			return true; // 2 and 3 are prime numbers
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0 || n % (i + 2) == 0) {
				return false;
			}
		}
		return true;

//        if (n <= 1) return false; // 0 and 1 are not prime numbers
//        if (n == 2 || n == 3) return true; // 2 and 3 are prime numbers
//        if (n % 2 == 0 || n % 3 == 0) return false; // eliminate multiples of 2 and 3
//        
//        for (int i = 5; i * i <= n; i += 6) {
//            if (n % i == 0 || n % (i + 2) == 0) {
//                return false;
//            }
//        }
//        return true;
	}

	// Function to count prime numbers in an array
	public static int countPrimes(int[] arr) {
		int count = 0;
		for (int num : arr) {
			if (isPrime(num)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 15, 3, 7, 19, 23, 29, 30, 2, 1 };

		int primeCount = countPrimes(arr);

		System.out.println("Number of prime numbers in the array: " + primeCount);
	}
}
