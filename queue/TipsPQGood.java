package a.queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TipsPQGood {

	public static void main(String[] args) {

		// Un comment and see the magic
		// PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		// Adding elements to the PriorityQueue
		pq.add(10);
		pq.add(20);
		pq.add(5);

		// Peek the smallest element
		System.out.println("Smallest element: " + pq.peek()); // Output: 5

		// Poll the smallest element (remove and return)
		System.out.println("Removed element: " + pq.poll()); // Output: 5

		// After polling, the smallest element now is
		System.out.println("New smallest element: " + pq.peek()); // Output: 10

		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int kLargest = 2;

		System.out.println("Kth largest element is " + maxTip(nums, kLargest)); // Output: 5
	}

	/*
	 * PriorityQueue is significantly more efficient than recursion for this
	 * problem. The time complexity of the PriorityQueue approach is 𝑂(𝑛log𝑛)
	 * O(nlogn), making it scalable and practical for large input sizes. The
	 * recursive approach has an exponential time complexity 𝑂(2^n), making
	 * it impractical for large n due to the huge number of recursive calls
	 * required. In most practical scenarios where n could be large, the
	 * PriorityQueue approach is the preferred method due to its much lower time
	 * complexity.
	 */
	public static int maxTip(int[] nums, int kLargest) {

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

//		int[] arr1 = { 8, 7, 15, 10, 5 }; // Tips for person A
//		int[] arr2 = { 1, 8, 7, 6, 4 }; // Tips for person B
//		int X = 3; // Maximum orders A can handle
//		int Y = 1; // Maximum orders B can handle

		int N = 5;		int X = 3;		int Y = 3;
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 5, 4, 3, 2, 1 };

		PriorityQueue<Integer> arr1PQ = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> arr2PQ = new PriorityQueue<>(Collections.reverseOrder());

		List<Integer> a1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
		List<Integer> a2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());

		arr1PQ.addAll(a1);
		arr2PQ.addAll(a2);

		int tipCompare = (X + Y) / N;
		System.out.println("X Y " + X + ":" + Y);
		int maxTip = 0;		int i = 0;
		for (i = 0; i < X - tipCompare; i++) {
			maxTip = maxTip + arr1PQ.poll(); // Returns max and removes it from the queue.
		}
		for (i = 0; i < Y - 1; i++) {
			maxTip = maxTip + arr2PQ.poll(); // Returns max and removes it from the queue.
		}
		// For common
		for (int j = i; i < j + tipCompare; i++) {
			System.out.println(" arr2PQ.poll() :" + arr2PQ.peek());
			int biggest = arr1PQ.peek() > arr2PQ.peek() ? arr1PQ.peek() : arr2PQ.peek();
			maxTip = maxTip + biggest; // Returns max and removes it from the queue.
		}
		return maxTip;
	}

}
