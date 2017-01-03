/**
 * Created by 张启 on 2015/11/29.
 *
 * Write a function to delete a node (except the tail) in a singly linked list, 
 * given only access to that node.
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node 
 * with value 3, the linked list should become 1 -> 2 -> 4 after calling your 
 * function.
 */
public class Solution {

    public static void main(String... args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode p = node1;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
        System.out.println();

        deleteNode(node1);

        p = node1;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) {
            val = x;
        }
    }

    public static void deleteNode(ListNode node) {
        ListNode p = node;
        while (true) {
            p.val = p.next.val;
            if (p.next.next == null) {
                p.next = null;
                return;
            }
            p = p.next;
        }
    }
}
