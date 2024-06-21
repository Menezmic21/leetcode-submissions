// https://leetcode.com/problems/merge-k-sorted-lists

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
    public ListNode mergeKLists(ListNode[] lists) {
        // Find head
        int k = lists.length;
        int min = Integer.MAX_VALUE;
        int argmin = -1;
        for (int i = 0; i < k; i++) {
            ListNode list = lists[i];
            if (list != null && list.val < min) {
                min = list.val;
                argmin = i;
            }
        }

        // Pop head
        if (argmin == -1) return null;
        ListNode head = popHead(lists, argmin);
        ListNode node = head;

        // Merge lists
        while(true) {
            min = Integer.MAX_VALUE;
            argmin = -1;
            for (int i = 0; i < k; i++) {
                ListNode list = lists[i];
                if (list != null && list.val < min) {
                    min = list.val;
                    argmin = i;
                }
            }
            if (argmin == -1) break;
            node.next = popHead(lists, argmin);
            node = node.next;
        }

        return head;
    }
    private ListNode popHead(ListNode[] lists, int i) {
        ListNode node = lists[i];
        lists[i] = node.next;
        return node;
    }
}