/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note
You may assume that duplicates do not exist in the tree.
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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    private int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        preIndex = 0;
        TreeNode root = buildTreeCore(preorder, inorder, 0, inorder.length - 1);
        return root;
    }
    
    
    private TreeNode buildTreeCore(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode newNode = new TreeNode(preorder[preIndex]);
        int nodeIndex = findNodeIndexInOrder(inorder, inStart, inEnd, preorder[preIndex]);
        preIndex++;
        newNode.left = buildTreeCore(preorder, inorder, inStart, nodeIndex - 1);
        newNode.right = buildTreeCore(preorder, inorder, nodeIndex + 1, inEnd);
        return newNode;
    }
    
    private int findNodeIndexInOrder(int[] inorder, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == target) {
                return i;
            } 
        }
        return -1;
    }
}
