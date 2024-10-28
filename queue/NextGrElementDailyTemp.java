package a.queue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://www.youtube.com/watch?v=mJWQjJpEMa4 
// https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
public class NextGrElementDailyTemp {

	public static int[] nextGreaterElementsGOOD(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
		Stack<Integer> stack = new Stack<>(); 
		// Traverse the array from right to left
		for (int i = n - 1; i >= 0; i--) {			 
			// Pop elements from the stack that are smaller than or equal to the current  element
			while (!stack.isEmpty() && nums[i] >= stack.peek() ) {
				stack.pop();
			}
			// If stack is not empty, the top element is the next greater element
			result[i] = stack.isEmpty() ? -1 : stack.peek(); 
			// Push the current element into the stack
			stack.push(nums[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {8, 4, 5, 2, 25 };
		int[] result = nextGreaterElementsGOOD(nums);
		System.out.println("Next Greater Elements: " + Arrays.toString(result));
	}

	//NOT GOOD
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {

		if (nums2.length == 0 || nums1.length == 0)
			return new int[0];

		Map<Integer, Integer> numberNGE = new HashMap<>();
		Stack<Integer> numStack = new Stack<>();

		numStack.push(nums2[nums2.length - 1]);
		numberNGE.put(nums2[nums2.length - 1], -1);

		for (int i = nums2.length - 2; i >= 0; i--) {

			if (nums2[i] < numStack.peek()) {
				numberNGE.put(nums2[i], numStack.peek());
				numStack.push(nums2[i]);
				continue;
			}

			while (!numStack.isEmpty() && numStack.peek() < nums2[i]) {
				numStack.pop();
			}
				
			numStack.push(nums2[i]);
			
			if (numStack.isEmpty()) {				
				numberNGE.put(nums2[i], -1);
			} else {
				numberNGE.put(nums2[i], numStack.peek());				 
			}
		}

		for (int i = 0; i < nums1.length; i++)
			nums1[i] = numberNGE.get(nums1[i]);

		return nums1;
	}
}
