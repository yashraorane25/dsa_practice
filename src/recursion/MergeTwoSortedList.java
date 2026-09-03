package recursion;

import util.ListNode;

public class MergeTwoSortedList {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);

        head1.next = node1;
        node1.next = node2;


        ListNode head2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        head2.next = node3;
        node3.next = node4;
        MergeTwoSortedList merge = new MergeTwoSortedList();
        ListNode newHead = merge.mergeTwoLists(head1, head2);

        printList(newHead);

    }

    private static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                dummy.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                dummy.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        while (list1 != null) {
            dummy.next = new ListNode(list1.val);
            list1 = list1.next;
            dummy = dummy.next;
        }
        while (list2 != null) {
            dummy.next = new ListNode(list2.val);
            list2 = list2.next;
            dummy = dummy.next;
        }
        return head.next;
    }
}
