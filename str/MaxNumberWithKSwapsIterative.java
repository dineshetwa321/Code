package a.string;
import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;

public class MaxNumberWithKSwapsIterative {
    // Function to find the maximum number possible by doing at most K swaps
    public static String findMaximumNumber(String number, int k) {
        // Priority Queue to store all possible numbers, sorted in descending order
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));
        Set<String> visited = new HashSet<>();

        // Insert the initial number into the queue
        pq.offer(number);
        visited.add(number);

        // Iterate while K swaps are remaining and the priority queue is not empty
        while (!pq.isEmpty() && k > 0) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                String current = pq.poll();

                // Generate all possible numbers by swapping two digits
                for (int j = 0; j < current.length(); j++) {
                    for (int l = j + 1; l < current.length(); l++) {
                        // Swap digits at positions j and l
                        String swapped = swap(current, j, l);

                        // If this new number hasn't been seen before, add it to the queue
                        if (visited.add(swapped)) {
                            pq.offer(swapped);
                        }
                    }
                }
            }
            // Decrease the number of remaining swaps
            k--;
        }

        // The maximum number will be at the top of the priority queue
        return pq.peek();
    }

    // Utility function to swap characters at positions i and j in a string
    public static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }

    public static void main(String[] args) {
        String number = "254";
        int k = 1;

        String maxNumber = findMaximumNumber(number, k);

        System.out.println("Maximum number possible after at most " + k + " swaps: " + maxNumber);
    }
}
