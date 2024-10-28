package a.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array 
to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.
 */
// https://leetcode.com/problems/sliding-window-maximum/description/?envType=problem-list-v2&envId=sliding-window

public class MaximumSlidingWindow {
	static int slide_count=3;
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return new int[0];

		int n = nums.length;
		int[] result = new int[n - k + 1]; // to store the maximums of each window
		 
		Deque<Integer> dequeIndices = new ArrayDeque<>(); // stores indices of nums array
		
	
		Deque<Integer> dequeValue = new ArrayDeque<>(); // stores value of nums array
	 
		
		//TODO here in Deque we are addinf only index not value ,  for value we using array only 
		for (int i = 0; i < nums.length; i++) {
			// Remove indices that are out of the bounds of the current window
			System.out.println("deque.peekFirst() :"+dequeIndices.peekFirst());
			System.out.println("deque.size() :"+dequeIndices.size());
			 
			//ith_remove =slide_count;
		 	if (!dequeIndices.isEmpty() && dequeIndices.peekFirst() < i-k+1) {  //at indieces 3 ,remove 0 and so on
				dequeIndices.pollFirst(); //remove 
			}
		 	// { 1, 3, -1, -3, 5, 3, 6, 7 };
			 // itterate and Remove elements from the deque that are smaller than the current element
            // since they won't be the maximum in this window
			System.out.println("deque.peekLast() :"+dequeIndices.peekLast());
			while (!dequeIndices.isEmpty() && nums[dequeIndices.peekLast()] < nums[i]) {
				dequeIndices.pollLast();
			}

			// Add the current element index to the deque , and will be used to get its value
			dequeIndices.offerLast(i); // DK
		 
			 // The maximum for this window is at the front of the deque
            // Start recording the results once we've processed at least k elements
			if (i >= k - 1) {
				result[i - k + 1] = nums[dequeIndices.peekFirst()];
				slide_count=k-1;
			}
		}
		return result;
	}
	 
	public static void main(String[] args) {
		MaximumSlidingWindow solution = new MaximumSlidingWindow();
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		int[] result = solution.maxSlidingWindow(nums, k);

		System.out.print("----- 1st Way ---- ");
		for (int max : result) {
			System.out.print(max + " ");
		}

		
	//	System.out.println("----- 2nd Way ---- ");
		int[] result1 = solution.maxSlidingWindowChat(nums, k);
		// for (int max : result1) {
		for (int max = 0; max < result1.length - 2; max++) {
		//	System.out.print(result1[max] + " ");
		}	
		
		 
	}

	//TODO worsetime complex
	/*
	 * While this solution is simple and works using Math.max, it's not optimal. A more efficient solution would be to use a deque to maintain the indices of useful elements within each sliding window, reducing the time complexity to O(n).
	 */
    public static int[] maxSlidingWindowChat(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1]; // To store the maximums of each window

        for (int i = 0; i <= n - k; i++) {
            int max = nums[i]; // Initialize the max with the first element of the window
            // Find the max in the current window of size k
            for (int j = i + 1; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            result[i] = max; // Store the maximum of the current window
        }

        return result;
    }
}
