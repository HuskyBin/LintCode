/*
You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in forward order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.

Have you met this question in a real interview? Yes
Example
Given 6->1->7 + 2->9->5. That is, 617 + 295.

Return 9->1->2. That is, 912.


*/
/**
 * Definition for singly-linked list.
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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        ListNode l1Head = reverseList(l1);
        ListNode l2Head = reverseList(l2);
        
        return reverseList(addList(l1Head, l2Head));
    } 
    
    private ListNode addList(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head = new ListNode(-1);
        ListNode pNode = head;
        int add = 0;
        while (l1 != null || l2 != null) {
            int l1Value = l1 != null ? l1.val : 0;
            int l2Value = l2 != null ? l2.val : 0;
            
            int sum = l1Value + l2Value + add;
            add = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            pNode.next = newNode;
            pNode = newNode;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 !=null) {
                l2 = l2.next;
            }
        }
        if (add > 0) {
            ListNode newNode = new ListNode(add);
            pNode.next = newNode;
        }
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
    }
    
    private ListNode reverseList(ListNode pNode) {
        ListNode preNode = null;
        while (pNode != null) {
            ListNode nextNode = pNode.next;
            pNode.next = preNode;
            preNode = pNode;
            pNode = nextNode;
        }
        return preNode;
    }
}
