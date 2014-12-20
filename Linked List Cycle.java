/*
Fair Linked List Cycle My Submissions

49% Accepted
Given a linked list, determine if it has a cycle in it.



Example
Challenge
Follow up:
Can you solve it without using extra space?
*/
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
        // write your code here
        if (head == null) {
            return false;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode != null) {
            fastNode = fastNode.next;
            if (fastNode == null) {
                break;
            }
            fastNode = fastNode.next;
            slowNode = slowNode.next;
            if (slowNode == fastNode) {
                return true;
            }
        }
        return false;
    }
}

