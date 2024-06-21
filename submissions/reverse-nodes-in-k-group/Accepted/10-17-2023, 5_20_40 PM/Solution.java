// https://leetcode.com/problems/reverse-nodes-in-k-group

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
    public ListNode newPivot;
    public ListNode oldPivot;
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = getLength(head);
        System.out.println((int) Math.floor(size / k));
        oldPivot = null;
        newPivot = head;
        ListNode newHead = null;
        for(int reverses = (int) Math.floor(size / k) - 1; reverses >= 0; reverses--) {
            ListNode res = reverse(k, null, newPivot);
            // if(oldPivot != null) System.out.println("OP: " + oldPivot.val);
            // System.out.println("NP: " + newPivot.val);
            if(reverses == (int) Math.floor(size / k) - 1) {
                newHead = res;
            }
            if(reverses == 0) {
                oldPivot.next = newPivot;
            }
        }
        
        return newHead;
    }

    public int getLength(ListNode node) {
        if(node == null) {
            return 0;
        }
        return 1 + getLength(node.next);
    }

    public ListNode reverse(int n, ListNode prev, ListNode node) {
        if(node == null || n <= 0) {
            if(this.oldPivot != null) {
                this.oldPivot.next = prev;
            }
            this.oldPivot = this.newPivot;
            this.newPivot = node;
            return prev;
        }
        ListNode temp = node.next;
        node.next = prev;
        return reverse(n-1, node, temp);
    }
}