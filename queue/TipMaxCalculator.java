package a.queue;
import java.util.PriorityQueue;
import java.util.Comparator;

public class TipMaxCalculator {

    // Helper class to represent each order
    static class Order {
        int tipA;
        int tipB;
        int index;
        int difference;

        Order(int tipA, int tipB, int index) {
            this.tipA = tipA;
            this.tipB = tipB;
            this.index = index;
            this.difference = Math.abs(tipA - tipB);
        }
    }

    public static int maxTipCalculator(int[] a, int[] b, int X, int Y) {
        int n = a.length;
        int maxTips = 0;

        // Priority queue to select the order with the highest tip difference
        PriorityQueue<Order> pq = new PriorityQueue<>(Comparator.comparingInt(o -> -o.difference));

        // Populate the priority queue with all orders
        for (int i = 0; i < n; i++) {
            pq.offer(new Order(a[i], b[i], i));
        }

        int countA = 0, countB = 0;

        // Process the orders by picking the highest difference in tips first
        while (!pq.isEmpty()) {
            Order order = pq.poll();

            if ((order.tipA > order.tipB && countA < X) || countB >= Y) {
                maxTips += order.tipA;
                countA++;
            } else {
                maxTips += order.tipB;
                countB++;
            }
        }

        return maxTips;
    }

    public static void main(String[] args) {
        int[] a = {8, 7, 15, 10, 5};  // Tips for person A
        int[] b = {1, 8, 7, 6, 4};    // Tips for person B
        int X = 3;  // Maximum orders A can handle
        int Y = 3;  // Maximum orders B can handle

        int maxTips = maxTipCalculator(a, b, X, Y);
        System.out.println("Maximum tips that can be obtained: " + maxTips);
    }
}
