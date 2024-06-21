// https://leetcode.com/problems/add-two-numbers

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode nextNode = null;
        ListNode head = l1;
        boolean carry = false;
        while(node1 != null || node2 != null || carry) {
            int sum = (node1 != null ? node1.val : 0) + 
                      (node2 != null ? node2.val : 0);
            if(carry) sum++;
            if(sum >= 10) {
                sum -= 10;
                carry = true;
            }
            else carry = false;
            // System.out.print("" + sum + " ");
            if(nextNode == null) {
                if(node1.next != null || node2.next != null || carry){
                    nextNode = new ListNode(-1);
                    head = new ListNode(sum, nextNode);
                } else head = new ListNode(sum);
            } else {
                nextNode.val = sum;
                if((node1 != null && node1.next != null) || (node2 != null && node2.next != null) || carry){
                    nextNode.next = new ListNode(-1);
                    nextNode = nextNode.next;
                }
            }
            if(node1 != null) node1 = node1.next;
            if(node2 != null) node2 = node2.next;
        }
        // System.out.println();

        return head;
    }
}