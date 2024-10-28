package a.queue;
import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {
    public static void main(String[] args) {
        // Creating a Deque using ArrayDeque
        Deque<String> deque = new ArrayDeque<>();

        // Using Deque as a Queue (FIFO)
        deque.offerLast("First");
        deque.offerLast("Second");
        deque.offerLast("Third");
        
        System.out.println("Deque as Queue:");
        while (!deque.isEmpty()) {
            System.out.println(deque.pollFirst()); // Removes and prints elements from the front
        }

        // Using Deque as a Stack (LIFO)
        deque.offerFirst("One");
        deque.offerFirst("Two");
        deque.offerFirst("Three");

        System.out.println("\nDeque as Stack:");
        while (!deque.isEmpty()) {
            System.out.println(deque.pollFirst()); // Removes and prints elements from the front (LIFO)
        }
    }
}
