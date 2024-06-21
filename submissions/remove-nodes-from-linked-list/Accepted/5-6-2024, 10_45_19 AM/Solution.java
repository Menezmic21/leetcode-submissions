// https://leetcode.com/problems/remove-nodes-from-linked-list

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
    public ListNode removeNodes(ListNode head) {
        head = reverseList(head);

        ListNode node = head;
        ListNode prev = null;
        int max = 0;
        while (node != null) {
            int val = node.val;
            // System.out.println("val: " + val);
            // System.out.println("max: " + max);
            boolean wasdeleted = false;
            if (val < max) { // delete node.
                if (prev != null) {
                    // System.out.println("deleting...");
                    prev.next = node.next;
                    wasdeleted = true;
                }
            } else {
                max = val;
            }
            if (!wasdeleted) {
                prev = node;
            }
            node = node.next;
        }

        return reverseList(head);
    }

    private ListNode reverseList(ListNode oldHead) {
        ListNode newHead = oldHead;
        ListNode node = oldHead.next;
        if (node == null) {
            return oldHead;
        }
        while (node != null) {
            oldHead.next = node.next;
            node.next = newHead;
            newHead = node;
            node = oldHead.next;
        }
        return newHead;
    }
}
