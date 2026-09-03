package sorting;

import util.ListNode;

public class MergeList {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        MergeList merge = new MergeList();
        head = merge.sortList(head);
        printList(head);
    }

    private static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode leftHead = head;
        ListNode rightHead = middle.next;
        middle.next = null;
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        return mergeList(leftHead, rightHead);
    }

    public ListNode mergeList(ListNode list1, ListNode list2) {
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

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
