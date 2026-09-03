package linked_list;

import util.ListNode;

public class AddNumbers {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(9);
        ListNode ndoe1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        head1.next = ndoe1;
        ndoe1.next = node2;
        node2.next = node3;
        // [8,9,9,9,0,0,0,1]
        ListNode head2 = new ListNode(8);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(0);
        ListNode node8 = new ListNode(0);
        ListNode node9 = new ListNode(0);
        ListNode node10 = new ListNode(1);
        head2.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        AddNumbers addNumbers = new AddNumbers();
        ListNode res = addNumbers.addTwoNumbers(head1, head2);
        printList(res);

    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1 + val2 + carry;
            carry = carry / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummy.next;

    }

}
