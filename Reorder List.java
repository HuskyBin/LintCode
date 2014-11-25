/**
Fair Reorder List Show Result My Submissions

27% Accepted
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.



Example
For example,
Given 1->2->3->4->null, reorder it to 1->4->2->3->null.
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
     * @return: void
     */
    public void reorderList(ListNode head) {  
        // write your code here
        if (head == null) {
            return;
        }
        ListNode middleNode = getMiddleNode(head);
        ListNode reverseHead = reverseHalfList(middleNode);
        ListNode pNodeOne = head;
        ListNode pNodeTwo = reverseHead;
        while (pNodeOne.next != pNodeTwo && pNodeOne != pNodeTwo) {
            ListNode oneNext = pNodeOne.next;
            ListNode twoNext = pNodeTwo.next;
            pNodeOne.next = pNodeTwo;
            pNodeTwo.next = oneNext;
            pNodeOne = oneNext;
            pNodeTwo = twoNext;
        }
        pNodeTwo.next = null;


    }
    
    private ListNode reverseHalfList(ListNode node) {
        ListNode previous = node;
        node = node.next;
        while (node != null) {
            ListNode next = node.next;
            node.next = previous;
            previous = node;
            node = next;
        }
        return previous;
    }
    
    private ListNode getMiddleNode(ListNode node) {
        ListNode fastNode = node;
        ListNode slowNode = node;
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
}

