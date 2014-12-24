/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/
/**
 * Definition for ListNode
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
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode pNode = dummyNode;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            if (nextNode != null) {
                if (nextNode.val != curNode.val) {
                    pNode.next = curNode;
                    pNode = pNode.next;
                    curNode = curNode.next;
                }
                else {
                    ListNode tmpNode = nextNode;
                    while (tmpNode != null && tmpNode.val == nextNode.val) {
                        tmpNode = tmpNode.next;
                    }
                    curNode = tmpNode;
                }
            }
            else {
                pNode.next = curNode;
                pNode = pNode.next;
                curNode = curNode.next;
            }
        }
        pNode.next = null;
        ListNode newHead = dummyNode.next;
        dummyNode.next = null;
        return newHead;
    }
}

