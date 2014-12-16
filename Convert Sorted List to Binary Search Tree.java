/*
Fair Convert Sorted List to Binary Search Tree Show Result My Submissions

29% Accepted
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

// without globle variable
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        
        if (head == null) {
            return null;
        }
        int length = getLength(head);
        NodeWrapper wrapperNode = new NodeWrapper(head);
        return generateBST(wrapperNode, 0, length - 1);
    }
    
    private int getLength(ListNode listNode) {
        int length = 0;
        while (listNode != null) {
            length++;
            listNode = listNode.next;
        }
        return length;
    }
    
    private TreeNode generateBST(NodeWrapper wrapperNode, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = start + (end - start) / 2;
        TreeNode left = generateBST(wrapperNode, start, middle - 1);
        TreeNode newNode = new TreeNode(wrapperNode.pNode.val);
        wrapperNode.pNode = wrapperNode.pNode.next;
        TreeNode right = generateBST(wrapperNode, middle + 1, end);
        newNode.left = left;
        newNode.right = right;
        return newNode;
    }
    
    class NodeWrapper {
        ListNode pNode = null;
        public NodeWrapper(ListNode node) {
            pNode = node;
        }
    }
    
}

