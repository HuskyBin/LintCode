/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example
An example:

   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".


*/
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    private long value;
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        value = Long.MIN_VALUE;
        return isValidBSTHelper(root);
    }
    
    private boolean isValidBSTHelper(TreeNode pNode) {
        if (pNode == null) {
            return true;
        }
        boolean left = isValidBSTHelper(pNode.left);
        if (left == false) {
            return false;
        }
        if (value >= pNode.val) {
            return false;
        }
        value = pNode.val;

        return isValidBSTHelper(pNode.right);
    }
}
