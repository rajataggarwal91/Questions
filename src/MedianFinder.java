import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    public static void main(String args[]){
       int[] input = {2,3,2,6,5,9,8};
       System.out.println(Arrays.toString(findMedian(input, 3)));
    }

    public static float[] findMedian(int[] input, int wsize) {
        if (wsize < 1 || input.length < 1) return null;
        float[] result = new float[input.length - wsize + 1];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());


        int i = 0;
        while (i < wsize/2) {
            maxHeap.add(input[i]);
            i++;
        }
        while (i < wsize) {
            System.out.println(minHeap.peek());
            if (input[i] < maxHeap.peek()) {
                minHeap.add(maxHeap.remove());
                maxHeap.add(input[i]);
            } else
                minHeap.add(input[i]);
            i++;
        }

        System.out.println(Arrays.toString(maxHeap.toArray()));
        System.out.println(Arrays.toString(minHeap.toArray()));


        i = wsize - 1;
        int k = 0;
        while (i < input.length) {
            if (wsize % 2 == 0)
                result[k++] = (minHeap.peek() + maxHeap.peek())/2;
            else
                result[k++] = minHeap.peek() > maxHeap.peek() ? minHeap.peek() : maxHeap.peek();
            i++;
            if (i < input.length) {
                maxHeap.add(input[(i - wsize)]);
                minHeap.remove(input[(i - wsize/2 - 1)]);
                minHeap.add(input[i]);
                maxHeap.remove(input[i - wsize]);
            }
        System.out.println(Arrays.toString(maxHeap.toArray()));
        System.out.println(Arrays.toString(minHeap.toArray()));


        }
        return result;
    }
}