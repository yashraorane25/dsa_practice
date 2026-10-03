package code.trees;

import code.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class MyCalenderTwoTest {

    static class MyCalendarTwo {

        List<Pair> booking = null;
        List<Pair> doubleBooked = null;

        public MyCalendarTwo() {
            booking = new ArrayList<>();
            doubleBooked = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            int bSize = booking.size();
            int dSize = doubleBooked.size();
            for (Pair db : doubleBooked) {
                if (Math.max(start, db.getFirst()) < Math.min(end, db.getSecond())) {
                    //overlap exits so returne false
                    return false;
                }
            }

            for (Pair bookedInterval : booking) {
                int overlapStart = Math.max(start, bookedInterval.getFirst());
                int overlapEnd = Math.min(end, bookedInterval.getSecond());
                if (overlapStart < overlapEnd) {
                    doubleBooked.add(new Pair(overlapStart, overlapEnd));
                }
            }
            booking.add(new Pair(start, end));
            return true;
        }
    }


    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(10, 20));
        System.out.println(myCalendarTwo.book(50, 60));
        System.out.println(myCalendarTwo.book(10, 40));
        System.out.println(myCalendarTwo.book(5, 15));
        System.out.println(myCalendarTwo.book(5, 10));
        System.out.println(myCalendarTwo.book(25, 55));
        //[[],[10,20],[50,60],[10,40],[5,15],[5,10],[25,55]]
    }
}
