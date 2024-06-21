// https://leetcode.com/problems/swap-nodes-in-pairs

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
    public ListNode swapPairs(ListNode head) {
        ListNode A = head;
        if (A == null) return null;
        ListNode B = A.next;
        if (B == null) {
            return A;
        }
        ListNode C = A;
        A.next = B.next;
        B.next = A;
        head = B;

        while (((A = A.next) != null) && ((B = A.next) != null)) {
            A.next = B.next;
            B.next = A;
            C.next = B;
            C = A;
        }
        return head;
    }
}