/*
Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

Example
        4

    /     \

  3         7

          /     \

        5         6

For 3 and 5, the LCA is 4.

For 5 and 6, the LCA is 7.

For 6 and 7, the LCA is 7.
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
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null || A == null || B == null) {
            return null;
        }
        if (!coverNode(root, A) && !coverNode(root, B)) {
            return null;
        }
        return findCommonAncestor(root, A, B);
    }
    
    private TreeNode findCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;
        }
        if (root == A || root == B) {
            return root;
        }
        boolean isALeft = coverNode(root.left, A);
        boolean isBLeft = coverNode(root.left, B);
        
        if (isALeft != isBLeft) {
            return root;
        }
        if (isALeft == false) {
            return findCommonAncestor(root.right, A, B);
        }
        else {
            return findCommonAncestor(root.left, A, B);
        }
    }
    
    private boolean coverNode(TreeNode root, TreeNode A) {
        if (root == null) {
            return false;
        }
        if (root == A) {
            return true;
        }
        return coverNode(root.left, A) || coverNode(root.right, A);
    }
}


// O(n)

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
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null || A == null || B == null) {
            return null;
        }
        if (!coverNode(root, A) && !coverNode(root, B)) {
            return null;
        }
        return findCommonAncestor(root, A, B);
    }
    
    private TreeNode findCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;
        }
        if (root == A && root == B) {
            return root;
        }
        TreeNode left = findCommonAncestor(root.left, A, B);
        if (left != null && left != A && left != B) {
            return left;
        }
        TreeNode right = findCommonAncestor(root.right, A, B);
        if (right != null && right != A && right != B) {
            return right;
        }
        if (left != null && right != null) {
            return root;
        }
        else if (root == A || root == B) {
            return root;
        }
        else {
            return left == null ? right : left;
        }
    }
    
    private boolean coverNode(TreeNode root, TreeNode A) {
        if (root == null) {
            return false;
        }
        if (root == A) {
            return true;
        }
        return coverNode(root.left, A) || coverNode(root.right, A);
    }
}
