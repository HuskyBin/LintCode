/*
Hard Linked List Cycle II Show Result My Submissions

35% Accepted
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

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
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
        // write your code here
        if (head == null) {
            return head;
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
            if (fastNode == slowNode) {
                break;
            }
        }
        if (fastNode == null) {
            return null;
        }
        slowNode = head;
        while (slowNode != fastNode) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        return fastNode;
    }
}

