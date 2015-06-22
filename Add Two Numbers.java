 /*
 You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.

Have you met this question in a real interview? Yes
Example
Given 7->1->6 + 5->9->2. That is, 617 + 295.

Return 2->1->9. That is 912.

Given 3->1->5 and 5->9->2, return 8->0->8.
 */
public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null || l2 == null) {
            return (l1 == null) ? l2 : l1;
        }
        ListNode head = new ListNode(-1);
        ListNode pNode = head;
        int add = 0;
        while (l1 != null || l2 != null) {
            int digit1 = (l1 == null) ? 0 : l1.val;
            int digit2 = (l2 == null) ? 0 : l2.val;
            int sum = digit1 + digit2 + add;
            ListNode newNode = new ListNode(sum % 10);
            add = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            pNode.next = newNode;
            pNode = pNode.next;
        }
        if (add > 0) {
            ListNode newNode = new ListNode(add);
            pNode.next = newNode;
        }
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
    }
}
