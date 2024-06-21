// https://leetcode.com/problems/intersection-of-two-linked-lists

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        int m = 0;
        int n = 0;
        while(A != null) {
            A = A.next;
            m++;
        }
        while(B != null) {
            B = B.next;
            n++;
        }
        System.out.println(m + " " + n);
        A = headA;
        B = headB;
        for(int i = m; i < n; i++) B = B.next;
        for(int i = n; i < m; i++) A = A.next;
        for(int i = 0; i < Math.min(m, n); i++) {
            System.out.println(A.val + " " + B.val);
            if(A == B) return A;
            A = A.next;
            B = B.next;
        }
        return null;
    }
}