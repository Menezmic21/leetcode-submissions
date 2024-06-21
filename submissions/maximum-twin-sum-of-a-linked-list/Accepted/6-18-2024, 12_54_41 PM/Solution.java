// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list

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
    public int pairSum(ListNode head) {
        // find middle slow fast
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // System.out.println("Slow: " + slow.val);
        // System.out.println("Fast: " + fast.val);

        // cut list
        prev.next = null;

        // reverse second half
        ListNode secondHead = reverse(null, slow);
        // System.out.println("FH: " + head.val);
        // System.out.println("SH: " + secondHead.val);

        // two pointer
        int maxSum = 0;
        while (head != null && secondHead != null) {
            maxSum = Math.max(maxSum, head.val + secondHead.val);
            head = head.next;
            secondHead = secondHead.next;
        }
        return maxSum;
    }
    private ListNode reverse(ListNode prev, ListNode node) {
        if (node == null) {
            return prev;
        }
        ListNode temp = node.next;
        node.next = prev;
        return reverse(node, temp);

    }

}