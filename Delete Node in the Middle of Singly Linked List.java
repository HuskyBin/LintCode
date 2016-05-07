/*
Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.

Have you met this question in a real interview? Yes
Example
Given 1->2->3->4, and node 3. return 1->2->4
*/
public class Solution {
    /**
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // write your code here
        if (node == null) {
            return;
        }
        ListNode nextNode = node.next;
        if (nextNode == null) {
            return;
        }
        node.val = nextNode.val;
        node.next = nextNode.next;
        return;
    }
}
