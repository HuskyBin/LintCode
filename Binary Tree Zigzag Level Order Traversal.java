/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]
*/   
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean rightToLeft = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> oneLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode topNode = queue.poll();
                oneLevel.add(topNode.val);
                if (topNode.left != null) {
                    queue.offer(topNode.left);
                }
                if (topNode.right != null) {
                    queue.offer(topNode.right);
                }
            }
            if (rightToLeft == true) {
                rightToLeft = false;
                ArrayList<Integer> singleList = new ArrayList<>();
                for (int i = oneLevel.size() - 1; i >= 0; i--) {
                    singleList.add(oneLevel.get(i));
                }
                resultList.add(singleList);
            }
            else {
                resultList.add(oneLevel);
                rightToLeft = true;
            }
        }
        return resultList;
    }
}
