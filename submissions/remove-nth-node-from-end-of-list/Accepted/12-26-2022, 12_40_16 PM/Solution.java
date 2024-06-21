// https://leetcode.com/problems/remove-nth-node-from-end-of-list

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        ListNode ahead = head;
        for(int i = 0; i < n; i++) {
            ahead = ahead.next;
        }
        while(ahead != null) {
            ahead = ahead.next;
            prev = curr;
            curr = next;
            next = next.next;
        }
        if(prev != null) prev.next = next;
        if(curr == head) return next;
        return head;
    }
}