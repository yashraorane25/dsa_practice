package linked_list;

import java.util.List;

import util.ListNode;

public class ReverseNodesInKGroups {

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
        ReverseNodesInKGroups reverse = new ReverseNodesInKGroups();
        ListNode res = reverse.reverseKGroup(head, 2);
        printList(res);
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
       
        ListNode temp = head;
        ListNode prev = null;
        ListNode nextNode = null;
        while (temp != null) {
            ListNode kthNode = findKthNode(temp, k);
            if (kthNode == null) {
                if (prev != null) {
                    prev.next = temp;
                }
                break;
            }
            nextNode = kthNode.next;
            kthNode.next = null;
            reverseList(temp);
            // check if it is firt frpup
            if (temp == head) {
                head = kthNode;
            } else {
                prev.next = kthNode;
            }
            prev = temp;
            temp = nextNode;

        }
        return head;
    }

    public ListNode findKthNode(ListNode head, int k) {
        ListNode temp = head;
        for (int i = 1; i < k; i++) {
            if (temp == null) return null;
            temp = temp.next;
        }
        return temp;
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
