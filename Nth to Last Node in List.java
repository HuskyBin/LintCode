/*
Find the nth to last element of a singly linked list. 

The minimum number of nodes in list is n.

Have you met this question in a real interview? Yes
Example
Given a List  3->2->1->5->null and n = 2, return node  whose value is 1.
*/
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
