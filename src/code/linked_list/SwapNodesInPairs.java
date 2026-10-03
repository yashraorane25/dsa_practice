package code.linked_list;

import code.util.ListNode;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        SwapNodesInPairs swap = new SwapNodesInPairs();
        ListNode res = swap.swapPairs(head);
        printList(res);
    }

    private static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //ListNode curr = head;
        //ListNode nextNode = curr.next;
        ListNode prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Rewire the three pointers
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Advance prev to the end of the swapped pair
            prev = first;
        }
        return dummy.next;
    }
}
