// https://leetcode.com/problems/odd-even-linked-list

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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lastOdd = head;
        ListNode prev = head;
        ListNode ptr = head.next;
        boolean isOdd = false;
        while (ptr != null) {
            // System.out.println("ptr: " + ptr.val);
            if (isOdd) {
                // System.out.println("^ is odd; appending to: " + lastOdd.val);
                prev.next = ptr.next;
                ptr.next = lastOdd.next;
                lastOdd.next = ptr;
                lastOdd = ptr;
                ptr = prev.next;
            } else {
                prev = prev.next;
                ptr = prev.next;
            }
            isOdd = !isOdd;
        }
        return head;
    }
}