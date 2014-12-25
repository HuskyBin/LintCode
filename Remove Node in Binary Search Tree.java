/*
Given a root of Binary Search Tree with unique value for each node.  Remove the node with given value. If there is no such a node with given value in the binary search tree, do nothing. You should keep the tree still a binary search tree after removal.

Example
Given binary search tree:

          5

       /    \

    3          6

 /    \

2       4

Remove 3, you can either return:

          5

       /    \

    2          6

      \

         4

or :

          5

       /    \

    4          6

 /   

2
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
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if (root == null) {
            return null;
        }
        TreeNode parentNode = null;
        TreeNode newRoot = removeNodeHelper(root, value, parentNode);
        return newRoot;
    }
    
    private TreeNode removeNodeHelper(TreeNode pNode, int value, TreeNode parentNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.val == value) {
            if (pNode.right != null) {
                TreeNode nextNode = findRightNextNode(pNode.right);
                if (pNode.left != nextNode) {
                    nextNode.left = pNode.left;
                }
                if (pNode.right != nextNode) {
                    nextNode.right = pNode.right;
                }
                if (parentNode != null) {
                    if (parentNode.left == pNode) {
                        parentNode.left = nextNode;
                    }
                    else {
                        parentNode.right = nextNode;
                    }
                }
                return nextNode;
            }
            else if (pNode.left != null) {
                TreeNode nextNode = findLeftNextNode(pNode.left);
                if (pNode.left != nextNode) {
                    nextNode.left = pNode.left;
                }
                if (pNode.right != nextNode) {
                    nextNode.right = pNode.right;
                }
                if (parentNode != null) {
                    if (parentNode.left == pNode) {
                        parentNode.left = nextNode;
                    }
                    else {
                        parentNode.right = nextNode;
                    }
                }
                return nextNode;
            }
            else {
                TreeNode nextNode = null;
                if (parentNode != null) {
                    if (parentNode.left == pNode) {
                        parentNode.left = null;
                    }
                    else {
                        parentNode.right = null;
                    }
                }
                return nextNode;
            }
        }
        else if (pNode.val < value) {
            removeNodeHelper(pNode.right, value, pNode);
            return pNode;
        }
        else {
            removeNodeHelper(pNode.left, value, pNode);
            return pNode;
        }
    }
    
    private TreeNode findRightNextNode(TreeNode pNode) {
        TreeNode preNode = null;
        while (pNode.left != null) {
            preNode = pNode;
            pNode = pNode.left;
        }
        if (preNode != null) {
            preNode.left = pNode.right;
            
        }
        return pNode;
    }
    
    private TreeNode findLeftNextNode(TreeNode pNode) {
        
        TreeNode preNode = null;
        while (pNode.right != null) {
            preNode = pNode;
            pNode = pNode.right;
        }
        if (preNode != null) {
            preNode.right = pNode.left;
        }
        return pNode;
    }
    
}
