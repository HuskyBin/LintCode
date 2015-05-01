/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

Example
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
Tags Expand  

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
     * @paramn n: An integer
     * @return: A list of root
     */
    public List<TreeNode> generateTrees(int n) {
        // write your code here
        List<TreeNode> resultList = new ArrayList<>();
        if (n <= 0) {
            resultList.add(null);
            return resultList;
        }
         resultList = generateCoreTrees(1, n);
        return resultList;
    }

    private List<TreeNode> generateCoreTrees(int start, int end) {
        List<TreeNode> resultList = new ArrayList<>();
        if (start > end) {
            resultList.add(null);
            return resultList;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = generateCoreTrees(start, i - 1);
            List<TreeNode> rightList = generateCoreTrees(i + 1, end);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = left;
                    newNode.right = right;
                    resultList.add(newNode);
                }
            }
        }
        return resultList;
    }
}
