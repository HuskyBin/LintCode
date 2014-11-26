/*
Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Return all the keys in ascending order.

Example
For example, if k1 = 10 and k2 = 22, then your function should print 12, 20 and 22.

          20

       /        \

    8           22

  /     \

4       12


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
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> resultList = new ArrayList<>();
        if (root == null || k1 > k2) {
            return resultList;
        }
        
        searchRangeHelper(root, k1, k2, resultList);
        Collections.sort(resultList);
        return resultList;
    }
    
    private void searchRangeHelper(TreeNode pNode, int k1, int k2, List<Integer> resultList) {
        if (pNode == null) {
            return;
        }
        if (pNode.val < k1) {
            searchRangeHelper(pNode.right, k1, k2, resultList);
        }
        else if (pNode.val > k2) {
            searchRangeHelper(pNode.left, k1, k2, resultList);
        }
        else {
            resultList.add(pNode.val);
            searchRangeHelper(pNode.left, k1, k2, resultList);
            searchRangeHelper(pNode.right, k1, k2, resultList);
        }
    }
}

