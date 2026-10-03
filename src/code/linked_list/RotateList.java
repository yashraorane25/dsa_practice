
package code.linked_list;

import code.util.ListNode;

public class RotateList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        RotateList rotateList = new RotateList();
        ListNode res = rotateList.rotateRight(head, 2);
        printList(res);
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        int size = 0;
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // System.out.println(size);
        if (k % size == 0)
            return dummy.next;
        k = k % size;

        int steps = size - k;
        temp = head;
        for (int i = 1; i < steps; i++) {
            temp = temp.next;
        }
        dummy.next = temp.next;
        temp.next = null;

        ListNode newTail = dummy.next;
        while (newTail.next != null) {
            newTail = newTail.next;
        }
        newTail.next = head;

        return dummy.next;

    }
}