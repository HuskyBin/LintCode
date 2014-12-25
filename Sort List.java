/*
Sort a linked list in O(n log n) time using constant space complexity.

Example
Given 1-3->2->null, sort it to 1->2->3->null.
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
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = findMiddleNode(head);
        ListNode right = sortList(middle.next);
        middle.next = null;
        ListNode left = sortList(head);
        ListNode newHead = merge(left, right);
        return newHead;
    }
    
    private ListNode findMiddleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        
        while (fastNode != null) {
            fastNode = fastNode.next;
            if (fastNode == null) {
                break;
            }
            fastNode = fastNode.next;
            if (fastNode == null) {
                break;
            }
            slowNode = slowNode.next;
        }
        return slowNode;
    }
    
    private ListNode merge(ListNode pNodeOne, ListNode pNodeTwo) {
        ListNode dummyNode = new ListNode(-1);
        ListNode pNode = dummyNode;
        while (pNodeOne != null && pNodeTwo != null) {
            if (pNodeOne.val <= pNodeTwo.val) {
                pNode.next = pNodeOne;
                pNodeOne = pNodeOne.next;
            }
            else {
                pNode.next = pNodeTwo;
                pNodeTwo = pNodeTwo.next;
            }
            pNode = pNode.next;
        }
        if (pNodeOne != null) {
            pNode.next = pNodeOne;
        }
        if (pNodeTwo != null) {
            pNode.next = pNodeTwo;
        }
        ListNode head = dummyNode.next;
        dummyNode.next = null;
        return head;
    }
    
}

