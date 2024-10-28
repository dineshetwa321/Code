package a.array;

public class SecondMaximum {
	public static int findSecondMaximum(int[] nums) {
		if (nums == null || nums.length < 2) {
			throw new IllegalArgumentException("Input array should contain at least two elements.");
		}

		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;

		for (int num : nums) {
			if (num > max) {				
				max = num;
				secondMax = num;
			} else if (num > secondMax && num != max) {
				secondMax = num;
			}
		}

		// If there's no distinct second maximum value, return the maximum value
		if (secondMax == Integer.MIN_VALUE) {
			throw new IllegalArgumentException("No distinct second maximum value found.");
		}

		return secondMax;
	}

	public static void main(String[] args) {
		int[] arrs = { 2, 10, 1, 5, 7, 3, 9 }; // Example array

		int max = 0;
		int secondMax = 0;

		// int secondMax = findSecondMaximum(arr);
		//DK 
		for (int arr : arrs) {
			if (arr > max) {
				secondMax = max;
				max = arr;
			} else if (arr < max && arr > secondMax) {
				secondMax = arr;
			}

			System.out.println("secondMax is :" + secondMax);
		}

		
		System.out.println("The second maximum value is: " + secondMax);
	}
}
