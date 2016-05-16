/*
Given a linked list and two values v1 and v2. Swap the two nodes in the linked list with values v1 and v2. It's guaranteed there is no duplicate values in the linked list. If v1 or v2 does not exist in the given linked list, do nothing.

 Notice

You should swap the two nodes with values v1 and v2. Do not directly swap the values of the two nodes.

Have you met this question in a real interview? Yes
Example
Given 1->2->3->4->null and v1 = 2, v2 = 4.

Return 1->4->3->2->null.
*/
public class Solution {
    /**
     * @param head a ListNode
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode firstPre = dummyNode;
        ListNode secondPre = dummyNode;
        ListNode curNode = dummyNode;
        boolean first = true;
        int count = 0;
        while(curNode.next != null) {
            if (curNode.next.val == v1 || curNode.next.val == v2) {
                count++;
                if (first == true) {
                    firstPre = curNode;
                    first = false;
                }
                else {
                    secondPre = curNode;
                }
            }
            curNode = curNode.next;
        }
        if (count != 2) {
            return head;
        }
        ListNode tmpNode = firstPre.next;
        firstPre.next = secondPre.next;
        secondPre.next = tmpNode;
        ListNode secondNext = firstPre.next.next;
        firstPre.next.next = tmpNode.next;
        tmpNode.next = secondNext;
        ListNode newHead = dummyNode.next;
        dummyNode.next = null;
        return newHead;
    }
}
