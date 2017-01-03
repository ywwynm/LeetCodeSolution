/**
 * Created by 张启 on 2015/11/3.
 * 
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain
 * a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class Solution {

    public static void main(String... args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode node = addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode n1 = l1, n2 = l2, head = new ListNode(0), node = head;
        while (n1 != null || n2 != null || carry == 1) {
            node.next = new ListNode(0);
            node = node.next;

            int val1 = n1 == null ? 0 : n1.val;
            int val2 = n2 == null ? 0 : n2.val;

            int sum = val1 + val2 + carry;
            if (sum > 9) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            node.val = sum;

            n1 = n1 == null ? null : n1.next;
            n2 = n2 == null ? null : n2.next;
        }
        return head.next;
    }
}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
}
