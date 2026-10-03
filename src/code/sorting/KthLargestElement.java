package code.sorting;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        KthLargestElement largestElement = new KthLargestElement();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int ans = largestElement.findKthLargest(nums, k);
        System.out.println("Answer is : " + ans);
    }

    public int findKthLargest(int[] nums, int k) {
        //i can use max heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return !minHeap.isEmpty() ? minHeap.peek() : 0;
    }
}
