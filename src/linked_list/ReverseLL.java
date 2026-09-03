package linked_list;

import java.util.List;

import util.ListNode;

public class ReverseLL {
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
        ReverseLL reverseLL = new ReverseLL();
        ListNode res = reverseLL.reverseList(head);
        printList(res);

    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode prev = head;
        ListNode curr = head.next;
        prev.next = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

}
