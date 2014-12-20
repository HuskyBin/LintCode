/*
Given an integer array with no duplicates. A max tree building on this array is defined as follow:

The root is the maximum number in the array
The left subtree and right subtree are the max trees of the subarray divided by the root number.
Construct the max tree by the given array.
Example
Given [2, 5, 6, 0, 3, 1], the max tree is

              6

            /    \

         5       3

       /        /   \

     2        0     1





Challenge
O(n) time complexity
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
 /*
 解答 


答：
如果能够确定每个节点的父亲节点，则可以构造出整棵树。找出每个数往左数第一个比他大的数和往右数第一个比他大的数，
两者中较小的数即为该数的父亲节点。如：[3,1,2]，3没有父亲节点，1的父亲节点为2，2的父亲节为3。
并且可以根据与父亲的位置关系来确定是左儿子还是右儿子。接下来的问题是如何快速找出每个数往左、往右第一个比他大的数
。这里需要用到数据结构栈。以找每个数左边第一个比他大的数为例，从左到右遍历每个数，栈中保持递减序列，
新来的数不停的Pop出栈顶直到栈顶比新数大或没有数。以[3,1,2]为例，首先3入栈，接下来1比3小，无需pop出3，1入栈，
并且确定了1往左第一个比他大的数为3。接下来2比1大，1出栈，2比3小，2入栈。并且确定了2往左第一个比他大的数为3。
用同样的方法可以求得每个数往右第一个比他大的数。时间复杂度O(n)，空间复杂度也是O(n)为最优解法。


面试官角度：
首先容易想到的是使用递归的方法来构造MaxTree，每一层递归用O(n)的时间找到最大数，然后将数组分为左右两个部分，然后递归完成构造。
这种算法在极端情况下复杂度可能达到O(n^2)，所以并不能被面试官所接受。但是你首先至少要把这种暴力的方法答出，
并分析出最坏时间复杂度，因为这至少也体现出了你一部分的算法能力和时间复杂度分析的技巧。万一后面的正确方法答不出来，
至少不会是0分。最优算法所使用到的Stack的方法，是一个非常常用的解题技巧。
我们在今后的面试题中也会陆续为为大家讲解涉及到这种方法的题目。
 */
public class Solution {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        if (A == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            TreeNode newNode = new TreeNode(A[i]);
            for (; ((!stack.isEmpty() && (stack.peek().val <= newNode.val))); stack.pop()) {
                TreeNode topNode = stack.peek();
                topNode.right = newNode.left;
                newNode.left = topNode;
            }
            stack.push(newNode);
        }
        
        TreeNode root = null;
        while (!stack.isEmpty()) {
            TreeNode topNode = stack.peek();
            topNode.right = root;
            root = topNode;
            stack.pop();
        }
        return root;
    }
}
