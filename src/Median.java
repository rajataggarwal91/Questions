import java.util.Comparator;
import java.util.PriorityQueue;

public class Median {
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String args[]) {
        minHeap.offer(Integer.MAX_VALUE);
        maxHeap.offer(Integer.MIN_VALUE);
            insert(7);
            System.out.println(getMedian());
            insert(1);
            insert(2);
            System.out.println(getMedian());
            insert(3);
            System.out.println(getMedian());
            insert(4);
            insert(5);
            insert(6);
            insert(7);
            System.out.println(getMedian());
    }

    private static void insert(int n) {
        if (maxHeap.peek() > n)
            maxHeap.offer(n);
        else
            minHeap.offer(n);

        if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    private static double getMedian() {
    int totalSize = maxHeap.size() + minHeap.size();
        if (totalSize >= 2 && totalSize % 2 == 0) {
            return ((double)maxHeap.peek() + (double)minHeap.peek()) / 2.0;
        } else {
            return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
        }

    }



}
