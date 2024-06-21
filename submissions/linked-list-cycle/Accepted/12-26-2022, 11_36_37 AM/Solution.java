// https://leetcode.com/problems/linked-list-cycle

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean running = true;
        boolean hasCycle = false;
        while(running) {
            if(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            } else {
                running = false;
                break;
            }
            if(slow == fast) {
                running = false;
                hasCycle = true;
            }
        }
        return hasCycle;
    }
}