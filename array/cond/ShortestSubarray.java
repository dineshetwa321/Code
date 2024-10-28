package a.array.cond;
import java.util.*;

//Shortest subarray with sum at least K
public class ShortestSubarray {

    public static int shortestSubarrayWithSumAtLeastK(int[] nums, int summMin) {
        int arrLen = nums.length;
        int minLength = arrLen + 1;

        Deque<Integer> deque = new LinkedList<>();
        int[] prefixSum = new int[arrLen + 1];

        for (int i = 0; i < arrLen; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        for (int i = 0; i <= arrLen; i++) {
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= summMin) {
                minLength = Math.min(minLength, i - deque.pollFirst());
            }

            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        return minLength <= arrLen ? minLength : -1;
    }

    public static int shortestSubarray(int[] nums, int K) {
        int minLength = Integer.MAX_VALUE;  // To track the minimum length
        int currentSum = 0;                 // To track the current sum of the window
        int start = 0;                      // Window's start position
        for (int end = 0; end < nums.length; end++) {
            currentSum += nums[end];  // Expand the window by adding nums[end]
            // Shrink the window until the sum is smaller than K
            while (currentSum >= K) {
                minLength = Math.min(minLength, end - start + 1);  // Update the minimum length
                currentSum = currentSum -nums[start];  // Shrink the window by moving the start
                start++;
            }
        }
        // If no valid subarray was found, return -1
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
    
    
          
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int summMin = 11;
        summMin = 6;
        int result = shortestSubarrayWithSumAtLeastK(nums, summMin);
        if (result != -1) {
            System.out.println("Shortest subarray length with sum at least K: " + result);
        } else {
            System.out.println("No subarray with sum at least K found.");
        }
        
        int result1 = shortestSubarray(nums, summMin);
        
        System.out.println("Shortest subarray length with sum at least K: " + result1);
        
       
    }
}
