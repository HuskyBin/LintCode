/*
Easy Invert Binary Tree Show result 

40% Accepted
Invert a binary tree.

Have you met this question in a real interview? Yes
Example
  1         1
 / \       / \
2   3  => 3   2
   /       \
  4         4
Challenge
Do it in recursion is acceptable, can you do it without recursion?
*/
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if(root == null) {
            return ;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }
}


//bfs
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if(root == null) {
            return ;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            TreeNode topNode = queue.poll();
            TreeNode leftNode = topNode.left;
            TreeNode rightNode = topNode.right;
            topNode.left = rightNode;
            topNode.right = leftNode;
            if (leftNode != null) {
                queue.add(leftNode);
            }
            if (rightNode != null) {
                queue.add(rightNode);
            }
        }
    }
}
