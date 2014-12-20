/*
Given an integer array with no duplicates. A max tree building on this array is defined as follow:

The root is the maximum number in the array
The left subtree and right subtree are the max trees of the subarray divided by the root number.
Construct the max tree by the given array.
Example
Given [2, 5, 6, 0, 3, 1], the max tree is

              6

            /    \

         5       3

       /        /   \

     2        0     1





Challenge
O(n) time complexity
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
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        if (A == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            TreeNode newNode = new TreeNode(A[i]);
            for (; ((!stack.isEmpty() && (stack.peek().val <= newNode.val))); stack.pop()) {
                TreeNode topNode = stack.peek();
                topNode.right = newNode.left;
                newNode.left = topNode;
            }
            stack.push(newNode);
        }
        
        TreeNode root = null;
        while (!stack.isEmpty()) {
            TreeNode topNode = stack.peek();
            topNode.right = root;
            root = topNode;
            stack.pop();
        }
        return root;
    }
}
