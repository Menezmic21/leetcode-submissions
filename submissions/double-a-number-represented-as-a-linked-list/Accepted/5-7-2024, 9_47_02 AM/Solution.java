// https://leetcode.com/problems/double-a-number-represented-as-a-linked-list

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode doubleIt(ListNode head) {
        head = reverseIt(head);

        ListNode node = head;
        boolean carry = false;
        while (node != null) {
            if (node.val > 4) { // results in double digit
                node.val = 2 * node.val - 10;
                if (carry) {
                    node.val++;
                }
                if (node.next == null) {
                    node.next = new ListNode(0);
                }
                carry = true;
            } else {
                node.val *= 2;
                if (carry) {
                    node.val++;
                }
                carry = false;
            }
            node = node.next;
        }

        return reverseIt(head);
    }

    private ListNode reverseIt(ListNode oldHead) {
        ListNode newHead = oldHead;
        ListNode node;
        while (oldHead.next != null) {
            node = oldHead.next;
            oldHead.next = node.next;
            node.next = newHead;
            newHead = node;
        }
        return newHead;
    }
}