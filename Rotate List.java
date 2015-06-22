/*
Given a list, rotate the list to the right by k places, where k is non-negative.

Have you met this question in a real interview? Yes
Example
Given 1->2->3->4->5 and k = 2, return 4->5->1->2->3.


*/
public class Solution {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if (head == null || k <= 0) {
            return head;
        }
        ListNode lastNode = null;
        int length = 0;
        ListNode pNode = head;
        while (pNode != null) {
            lastNode = pNode;
            pNode = pNode.next;
            length++;
        }
        lastNode.next = head;
        k = length - (k % length);
        ListNode preNode = lastNode;
        ListNode curNode = head;
        while (k > 0) {
            preNode = curNode;
            curNode = curNode.next;
            k--;
        }
        ListNode newHead = curNode;
        preNode.next = null;
        return newHead;
    }
}
