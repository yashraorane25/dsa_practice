package queue;

import util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        SlidingWindowMaximum sw = new SlidingWindowMaximum();
        int[] result = sw.maxSlidingWindow(nums, k);
        for (int val : result) {
            System.out.println(val);
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.getSecond() - a.getSecond());
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(i, nums[i]));
        }
        res.add(pq.peek().getSecond());
//        System.out.println("Top element: " + pq.poll().getSecond());
//        return new int[n - k + 1];
        for (int i = k; i < n; i++) {
            pq.add(new Pair(i, nums[i]));
            while (!pq.isEmpty() && pq.peek().getFirst() <= i - k) {
                pq.poll();
            }
            res.add(pq.peek().getSecond());
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
