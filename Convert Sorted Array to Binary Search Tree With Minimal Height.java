/*
Given a sorted (increasing order) array, Convert it to create a binary tree with minimal height.

 Notice

There may exist multiple valid solutions, return any of them.

Have you met this question in a real interview? Yes
Example
Given [1,2,3,4,5,6,7], return

     4
   /   \
  2     6
 / \    / \
1   3  5   7
*/
public class Solution {
    /**
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {  
        // write your code here
        if (A == null || A.length == 0) {
            return null;
        }
        return buildTree(A, 0, A.length - 1);
    }  
    
    private TreeNode buildTree(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = start + (end - start) / 2;
        TreeNode newNode = new TreeNode(A[middle]);
        TreeNode leftChild = buildTree(A, start, middle - 1);
        TreeNode rightChild = buildTree(A, middle + 1, end);
        newNode.left = leftChild;
        newNode.right = rightChild;
        return newNode;
    }
}
