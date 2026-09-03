package linked_list;

import util.ListNode;

import java.util.HashMap;
import java.util.HashSet;

public class FindIntersection {
    public static void main(String[] args) {
        // Shared tail (the intersection)
        ListNode intersection = new ListNode(8);
        intersection.next = new ListNode(4);
        intersection.next.next = new ListNode(5);

        // List A: 4 -> 1 -> [intersection]
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersection;

        // List B: 5 -> 6 -> [intersection]
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = intersection;
        FindIntersection findIntersection = new FindIntersection();
        ListNode res = findIntersection.getIntersectionNode(headA, headB);
        System.out.println(res.val);

    }
//using hashset
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//
//        HashSet<ListNode> hs = new HashSet<>();
//        ListNode temp = headA;
//        while (temp != null) {
//            hs.add(temp);
//            temp = temp.next;
//        }
//        temp = headB;
//        while (temp != null) {
//            if (hs.contains(temp)) {
//                return temp;
//            }
//            temp=temp.next;
//        }
//        return null;
//    }

    //using two pointers
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            pa = (pa != null) ? pa.next : headB;
            pb = (pb != null) ? pb.next : headA;
        }
        return pa;
    }
}
