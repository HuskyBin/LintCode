/*
Design an iterator over a binary search tree with the following properties:
Elements are visited in ascending order (i.e. an inorder traversal)
next() and hasNext() queries run in O(1) time in average.
Example
For the following binary search tree, inorder traversal by using iterator is [1, 6, 10, 11, 12]

      10

    /     \

 1          11

    \           \

       6           12



Challenge
Extra memory usage O(h), h is the height of the tree.
Super Star: Extra memory usage O(1)

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
 * Example of iterate a tree:
 * Solution iterator = new Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class Solution {
    //@param root: The root of binary tree.
    private Stack<TreeNode> stack;
    public Solution(TreeNode root) {
        // write your code here
        stack = new Stack<>();
        TreeNode pNode = root;
        while (pNode != null) {
            stack.push(pNode);
            pNode = pNode.left;
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        if (stack.isEmpty()) {
            return false;
        }
        else {
            return true;
        }
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
        if (stack.isEmpty()) {
            return null;
        }
        TreeNode topNode = stack.pop();
        if (topNode.right != null) {
            TreeNode pNode = topNode.right;
            while (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            }
        }
        return topNode;
    }
}
