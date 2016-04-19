/*
Given a binary search tree (See Definition) and a node in it, find the in-order successor of that node in the BST.

Have you met this question in a real interview? Yes
 Notice

If the given node has no in-order successor in the tree, return null.

Example
Given tree = [2,1] and node = 1:

  2
 /
1
return node 2.

Given tree = [2,1,3] and node = 2:

  2
 / \
1   3
return node 3.
*/
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null || p == null) {
            return null;
        }
        if (p.right != null) {
            TreeNode resultNode = p.right;
            while (resultNode.left != null) {
                resultNode = resultNode.left;
            }
            return resultNode;
        }
        return findInorderSuccessorParent(root, p);
    }
    
    private TreeNode findInorderSuccessorParent(TreeNode root, TreeNode pNode) {
        if (root == null) {
            return null;
        }
        if (root == pNode) {
            return null;
        }
        else if (root.val > pNode.val) {
            TreeNode subResult = findInorderSuccessorParent(root.left, pNode);
            if (subResult != null) {
                return subResult;
            }
            else {
                return root;
            }
        }
        else {
            return findInorderSuccessorParent(root.right, pNode);
        }
        
    }
}

// Second solution
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null || p == null) {
            return null;
        }
        TreeNode successor = null;
        while (root != null && root != p) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            }
            else if (root.val < p.val) {
                root = root.right;
            }
        }
        if (p.right == null) {
            return successor;
        }
        successor = p.right;
        while (successor.left != null) {
            successor = successor.left;
        }
        return successor;
    }
}
