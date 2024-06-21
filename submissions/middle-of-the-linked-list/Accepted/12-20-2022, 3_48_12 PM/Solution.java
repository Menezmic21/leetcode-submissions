// https://leetcode.com/problems/middle-of-the-linked-list

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
    public ListNode middleNode(ListNode head) {
        ArrayList<ListNode> lst = new ArrayList<ListNode>();
        lst.add(head);
        ListNode node = head;
        while(node.next != null){
            node = node.next;
            lst.add(node);
        }
        return lst.get((int) (lst.size()/2));
    }
}