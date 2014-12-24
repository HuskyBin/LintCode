/*
Remove Duplicates from Sorted List Show Result My Submissions

41% Accepted
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.


*/
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        if (head == null) {
            return head;
        }
        ListNode pNode = head;
        while (pNode != null) {
            if (pNode.next == null) {
                break;
            }
            ListNode nextNode = pNode.next;
            while (nextNode != null && nextNode.val == pNode.val) {
                nextNode = nextNode.next;
            }
            if (nextNode == null) {
                break;
            }
            pNode.next = nextNode;
            pNode = pNode.next;
        }
        pNode.next = null;
        return head;
    }  
}
