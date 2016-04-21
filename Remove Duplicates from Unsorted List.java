/*
Write code to remove duplicates from an unsorted linked list.

Have you met this question in a real interview? Yes
Example
Given 1->3->2->1->4.

Return 1->3->2->4
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
     * @param head: The first node of linked list.
     * @return: head node
     */
    public ListNode removeDuplicates(ListNode head) { 
        // Write your code here
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        Set<Integer> sets = new HashSet<>();
        ListNode preNode = dummyNode;
        ListNode curNode = head;
        while (curNode != null) {
            if (sets.contains(curNode.val)) {
                preNode.next = curNode.next;
                curNode.next = null;
                curNode = preNode.next;
            }
            else {
                sets.add(curNode.val);
                preNode = curNode;
                curNode = curNode.next;
            }
        }
        ListNode newHead = dummyNode.next;
        dummyNode.next = null;
        return newHead;
    }  
}
