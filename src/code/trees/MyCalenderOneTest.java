package code.trees;

import java.util.Map;
import java.util.TreeMap;

public class MyCalenderOneTest {

    class Node {
        Node left;
        Node right;
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
        }

//        public boolean insert(int start, int end) {
//
//        }
    }

    /*
    static class MyCalendar {
        List<Pair> events = null;

        public MyCalendar() {
            events = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (Pair event : events) {
                if (event.getFirst() < end && start < event.getSecond()) {
                    return false;
            }
            events.add(new Pair(start, end));
            return true;
        }
    }*/
    static class MyCalendar {
        TreeMap<Integer, Integer> bookings;

        public MyCalendar() {
            bookings = new TreeMap<>();

        }

        //TC: O(logn)
        // SC: O(n)
        public boolean book(int start, int end) {
            //find the event starting at or just before start
            //floorEntry finds the closest event starting at or before the new start
            Map.Entry<Integer, Integer> entry = bookings.floorEntry(start);
            if (entry != null && entry.getValue() > start) {
                return false;
            }

            // Find the event starting at or just after 'start'
            //ceilingEntry finds the closest event starting at or after the new start.
            Map.Entry<Integer, Integer> ceiling = bookings.ceilingEntry(start);
            if (ceiling != null && end > ceiling.getKey()) {
                return false;
            }
            bookings.put(start, end);
            return true;

        }
    }

    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();

        System.out.println(calendar.book(10, 20)); // true  - no overlap
        System.out.println(calendar.book(15, 25)); // false - overlaps with [10,20)
        System.out.println(calendar.book(20, 30)); // true  - [20,30) starts where [10,20) ends, no overlap
    }
}
