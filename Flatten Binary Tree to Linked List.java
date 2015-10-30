/*
Flatten a binary tree to a fake "linked list" in pre-order traversal.

Here we use the right pointer in TreeNode as the next pointer in ListNode.

Have you met this question in a real interview? Yes
Example
              1
               \
     1          2
    / \          \
   2   5    =>    3
  / \   \          \
 3   4   6          4
                     \
                      5
                       \
                        6
Note
Don't forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.

Challenge
Do it in-place without any extra memory.
*/
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    private TreeNode preNode = null;
    public void flatten(TreeNode root) {
        // write your code here
        TreeNode pNode = root;
        if (pNode == null) {
            return;
        }
        TreeNode rightNode = pNode.right;
        if (preNode != null) {
            preNode.right = pNode;
            preNode.left = null;
        }
        preNode = pNode;
        flatten(pNode.left);
        flatten(rightNode);
    }
    

}
