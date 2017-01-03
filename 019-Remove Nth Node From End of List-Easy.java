import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张启 on 2015/11/26.
 *
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
public class Solution {

    public static void main(String... args) {
        
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p);
            p = p.next;
        }

        int size = list.size();
        if (n > size) {
            return head;
        }

        if (n == 1) {
            if (size < 2) {
                return null;
            } else {
                list.get(size - 2).next = null;
                return head;
            }
        } else if (n == size) {
            return list.get(1);
        } else {
            list.get(size - n - 1).next = list.get(size - n + 1);
            return head;
        }
    }

    public static ListNode bestBecauseOnePass(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) { // remove first node
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) {
            val = x;
        }
    }

}
