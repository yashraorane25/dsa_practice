package linked_list;

import util.ListNode;

public class RemoveNthNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node2.next = node3;
        node3.next = node4;
        RemoveNthNode removeNthNode = new RemoveNthNode();
        int n = 2;
        ListNode res = removeNthNode.removeNthFromEnd(head, n);
        printList(res);
    }

    private static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        int k = 0;
        temp = dummy;
        while (k < (size - n)) {
            temp = temp.next;
            k++;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }
}
