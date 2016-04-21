/*
Given a binary tree, find the maximum path sum from root.

The path may end at any node in the tree and contain at least one node in it.

Have you met this question in a real interview? Yes
Example
Given the below binary tree:

  1
 / \
2   3
return 4. (1->3)
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
     * @param root the root of binary tree.
     * @return an integer
     */
    private int max = Integer.MIN_VALUE; 
    public int maxPathSum2(TreeNode root) {
        // Write your code here
        if (root == null) {
            return 0;
        }
        maxPathCore(root, 0);
        return max;
    }
    
    private void maxPathCore(TreeNode pNode, int sum) {
        if (pNode == null) {
            return;
        }
        sum += pNode.val;
        max = Math.max(max, sum);
        maxPathCore(pNode.left, sum);
        maxPathCore(pNode.right, sum);
    }
}
