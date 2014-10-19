/*
Easy Binary Tree Postorder Traversal Show Result My Submissions

11% Accepted
Given a binary tree, return the postorder traversal of its nodes' values.

Example
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
 

return [3,2,1].
*/
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> resultStack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode topNode = stack.pop();
            resultStack.push(topNode);
            if (topNode.left != null) {
                stack.push(topNode.left);
            }
            if (topNode.right != null) {
                stack.push(topNode.right);
            }
        }
        while (!resultStack.isEmpty()) {
            resultList.add(resultStack.pop().val);
        }
        return resultList;
    }
}
