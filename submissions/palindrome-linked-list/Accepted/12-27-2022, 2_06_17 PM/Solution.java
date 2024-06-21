// https://leetcode.com/problems/palindrome-linked-list

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
    public boolean isPalindrome(ListNode head) {
        //get length
        int len = 1;
        ListNode node = head;
        while(node.next != null) {
            len++;
            node = node.next;
        }
        
        if(len == 1) return true;
        
        // printLinkedList(head);
        
        //reverse first half
        node = head;
        ListNode secondHead = head;
        for(int i = 1; i < (int) len / 2; i++) {
            node = node.next;
        }
        secondHead = (int) len / 2 == (double) len / 2.0 ? node.next: node.next.next;
        node.next = null;
        head = reverseList(head);
        
        // printLinkedList(head);
        // printLinkedList(secondHead);
        
        //matching?
        boolean matching = true;
        int count = 0;
        ListNode A = head;
        ListNode B = secondHead;
        while(matching && count < (int) len / 2) {
            count++;
            matching = A.val == B.val;
            A = A.next;
            B = B.next;
        }
        return matching;
    }
    public ListNode reverseList(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        ListNode node = head.next;
        ListNode prev = head;
        
        prev.next = node.next;
        node.next = head;
        head = node;
        node = prev.next;
        while(node != null) {            
            prev.next = node.next;
            node.next = head;
            head = node;
            node = prev.next;          
        }
        return head;
    }
    
    public void printLinkedList(ListNode head) {
        ListNode node = head;
        System.out.print(node.val + " ");
        while(node.next != null) {
            node = node.next;
            System.out.print(node.val + " ");
        }
        System.out.println();
    }
}