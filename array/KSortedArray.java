package a.array;
import java.util.PriorityQueue;

public class KSortedArray {
    
    public static void sortNearlySorted(int[] arr, int k) {
        // Create a min heap (priority queue)
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        
        // Add the first k + 1 elements to the min heap
        for (int i = 0; i <= k && i < arr.length; i++) {
            pQueue.add(arr[i]);
        }
        
        // Index for the sorted array
        int index = 0;

        // Process the remaining elements
        for (int i = k + 1; i < arr.length; i++) {
            arr[index++] = pQueue.poll();  // Pop the smallest element
            pQueue.add(arr[i]);  // Add the current element to the heap
        }

        // Extract remaining elements from the heap
        while (!pQueue.isEmpty()) {
            arr[index++] = pQueue.poll();
        }
    }
    
    // Test the solution
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;

        sortNearlySorted(arr, k);

        // Output the sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
