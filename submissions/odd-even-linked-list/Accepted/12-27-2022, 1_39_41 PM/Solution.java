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
        ListNode endOfOdds = head;
        ListNode node = head;
        ListNode endOfEvens = head;
        int parity = 1;
        while(node != null && node.next != null) {
            // System.out.print(node.val + " ");
            if(parity == 1) {
                node = node.next;
                endOfEvens = node;
            } else {
                node = node.next;
                ListNode startOfEvens = endOfOdds.next;
                endOfOdds.next = node;
                endOfEvens.next = node.next;
                node.next = startOfEvens;
                endOfOdds = node;
                node = endOfEvens;
            }
            parity *= -1;
        }
        return head;
    }
}