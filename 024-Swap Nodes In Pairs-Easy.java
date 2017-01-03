import java.util.*;

/**
 * Created by 张启 on 2016/3/25.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. 
 * You may not modify the values in the list, only nodes itself can be changed.
 */
public class Solution {

    public static void main(String... args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
        n1.show();

        System.out.println();

        swapPairs(n1).show();
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

        void show() {
            ListNode p = this;
            while (p != null) {
                System.out.print(p.val + "->");
                p = p.next;
            }
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head, ret = head.next;
        while (p != null) {
            ListNode next = p.next;
            if (next == null) {
                return ret;
            }
            ListNode then = next.next;
            if (then == null) {
                p.next = null;
            } else if (then.next == null) {
                p.next = then;
            } else {
                p.next = then.next;
            }
            next.next = p;
            p = then;
        }
        return ret;
    }

    public static ListNode better(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode h = new ListNode(0);
        h.next = head;
        ListNode p = h;

        while (p.next != null && p.next.next != null){
            //use t1 to track first node
            ListNode t1 = p;
            p = p.next;
            t1.next = p.next;

            //use t2 to track next node of the pair
            ListNode t2 = p.next.next;
            p.next.next = p;
            p.next = t2;
        }

        return h.next;
    }

}
