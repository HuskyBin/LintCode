/*
Given a binary tree, return all root-to-leaf paths.

Have you met this question in a real interview? Yes
Example
Given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

[
  "1->2->5",
  "1->3"
]

*/
/**
 * Definition of TreeNode:
 * Definition of TreeNode:
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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        StringBuilder sb = new StringBuilder();
        printTreePaths(root, resultList, sb);
        return resultList;
    }
    
    private void printTreePaths(TreeNode pNode, List<String> resultList, StringBuilder sb) {
        if (pNode == null) {
            return;
        }
        sb.append(pNode.val);
        sb.append("->");
        if (pNode.left == null && pNode.right == null) {
            String path = sb.toString();
            resultList.add(path.substring(0, path.length() - 2));
        }
        if (pNode.left != null) {
            printTreePaths(pNode.left, resultList, sb);
        }
        if (pNode.right != null) {
            printTreePaths(pNode.right, resultList, sb);
        }
        sb.setLength(sb.length() - Integer.toString(pNode.val).length() - 2);
    }
}
