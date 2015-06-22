/*
Merge two sorted (ascending) linked lists and return it as a new sorted list. The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.

Have you met this question in a real interview? Yes
Example
Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.


*/
public class Solution {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null || l2 == null) {
            return (l1 == null) ? l2 : l1;
        }
        
        ListNode dummyNode = new ListNode(-1);
        ListNode pNode = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val  <= l2.val) {
                pNode.next = l1;
                l1 = l1.next;
            }
            else {
                pNode.next = l2;
                l2 = l2.next;
            }
            pNode = pNode.next;
        }
        if (l1 != null) {
            pNode.next = l1;
        }
        else if (l2 != null) {
            pNode.next = l2;
        }
        ListNode newHead = dummyNode.next;
        dummyNode.next = null;
        return newHead;
    }
}
