
/*
Fair Construct Binary Tree from Inorder and Postorder Traversal Show Result My Submissions

42% Accepted
Given inorder and postorder traversal of a tree, construct the binary tree.

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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    private int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if (inorder == null || inorder.length == 0 || 
            postorder == null || postorder.length == 0) {
            return null;
        }
        if (inorder.length != postorder.length) {
            return null;
        }
        postIndex = postorder.length - 1 ;
        TreeNode rootNode = buildTreeCore(inorder, postorder, 0, inorder.length - 1);
        return rootNode;
    }
    
    private TreeNode buildTreeCore(int[] inorder,
                               int[] postorder,
                               int inStart,
                               int inEnd) {
        if (inEnd < inStart) {
            return null;
        }   
        if (inEnd == inStart) {
            TreeNode leaveNode = new TreeNode(inorder[inStart]);
            postIndex--;
            return leaveNode;
        }
        int nodeIndexOfInorder = findNodeIndexAtInorder(inorder, inStart, inEnd, postorder[postIndex]);
        TreeNode newNode = new TreeNode(postorder[postIndex]);
        postIndex--;
        newNode.right = buildTreeCore(inorder, postorder, nodeIndexOfInorder + 1, inEnd);
        newNode.left = buildTreeCore(inorder, postorder, inStart, nodeIndexOfInorder - 1);
        return newNode;
    }
    
    private int findNodeIndexAtInorder(int[] inorder, int inStart, int inEnd, int target) {
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        //throws Exception
        return -1;
    }
}
