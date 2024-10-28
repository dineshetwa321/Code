package a.array.cond;

//https://www.geeksforgeeks.org/maximum-jumps-to-reach-end-of-array-with-condition-that-index-i-can-make-arri-jumps/?ref=oin_asr1
//https://leetcode.com/problems/jump-game-ii/description

public class MinJumpsArraytoGood {

	static int minJumps(int arr[]) {
		if (arr.length <= 1)
			return 0;

		// If value of first index guarantees
		// only 1 jump is needed, return 1
		if (arr[0] >= arr.length - 1)
			return 1;

		// Return -1 if not possible to jump
		if (arr[0] == 0)
			return -1;

		// initialization
		int maxReach = arr[0];
		int step = arr[0];
		int jump = 1;

		// { 2, 3, 1, 1, 4 };// Output: 2
		// Start traversing array
		for (int arrIndex = 1; arrIndex < arr.length; arrIndex++) {
			// Check if we have reached the end of the array
			if (arrIndex == arr.length - 1)
				return jump;

			// Check if value at current index guarantees jump to end
			if (arrIndex + arr[arrIndex] >= (arr.length - 1)) {
				return jump + 1;
			}

			// updating maxReach
			int newMaxReach = arrIndex + arr[arrIndex];
			// int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9,1, 3, 5, 8, 9, 2, 6, 7, 6, 8,
			// 9,1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
			maxReach = Math.max(maxReach, newMaxReach);
			System.out.println("i aa  maxReach:" + arrIndex + ":" + newMaxReach + ":" + maxReach);
			// we use a step to get to the current index
			step--;

			// If no further steps left
			if (step == 0) {
				// we must have used a jump
				jump++;
				// Check if the current index/position or lesser index // is the maximum reach
				// point from the previous indexes
				if (arrIndex >= maxReach) {
					return -1;
				}
				// re-initialize the steps to the amount of steps to reach maxReach from
				// position i.
				step = maxReach - arrIndex;

			}
		}

		return -1;
	}

	public static void main(String[] args) {
		// int[] arr = { 2, 3, 1, 1, 4 };// Output: 2
		int[] arr = { 2, 3, 8, 1, 4, 6, 8, 6, 5, 2, 1, 1, 6 };

		// int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};//Output: 3
		// int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9,1, 3, 5, 8, 9, 2, 6, 7, 6, 8,
		// 9,1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		// int[] arr = { 1, 4, 3, 2, 6, 7 }; // Output: 2
		// int[] arr = {0, 10, 20}; //Output: -1
		// System.out.println("Minimum jumps needed: " + minJumps(arr)); // Output: 2

		System.out.println("Minimum jumps needed: " + minJumpsDK(arr)); // Output: 2

	}

	// https://www.youtube.com/watch?v=9kyHYVxL4fw
	static int minJumpsDK(int nums[]) {

		int maxIndex = 0;
		int steps = nums[0];
		// { 2,3,8,1,4 ,6,8,6,5,2, 1,1,6,15};//
		for (int currIndex = 1; currIndex <= nums.length; currIndex++) {

			if (currIndex + nums[currIndex] >= (nums.length - 1)) {
				return steps + 1;
			}
			maxIndex = Math.max(maxIndex, currIndex + nums[currIndex]);

			System.out.println(
					"currIndex nums[currIndex] reachedMaxIndex :" + currIndex + ":" + nums[currIndex] + ":" + maxIndex);

			steps = steps - 1;
			if (steps == 0) {
				steps = steps + 1;
				steps = maxIndex - currIndex; // DK this is v important 
			}
		}
		return 0;
	}

}
