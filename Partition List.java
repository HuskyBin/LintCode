/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2->null and x = 3,
return 1->2->2->4->3->5->null.
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
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null) {
            return head;
        }
        ListNode lessDummyNode = new ListNode(-1);
        ListNode largerDummyNode = new ListNode(-1);
        
        ListNode lessNode = lessDummyNode;
        ListNode largerNode = largerDummyNode;
        ListNode pNode = head;
        while (pNode != null) {
            ListNode nextNode = pNode.next;
            if (pNode.val < x) {
                lessNode.next = pNode;
                lessNode = pNode;
            }
            else {
                largerNode.next = pNode;
                largerNode = pNode;
            }
            pNode = nextNode;
        }
        lessNode.next = largerDummyNode.next;
        largerDummyNode.next = null;
        head = lessDummyNode.next;
        lessDummyNode.next = null;
        largerNode.next = null;
        return head;
    }
}

