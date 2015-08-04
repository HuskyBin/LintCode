/*
Medium Segment Tree Build Show result 

35% Accepted
The structure of Segment Tree is a binary tree which each node has two attributes start and end denote an segment / interval.

start and end are both integers, they should be assigned in following rules:

The root's start and end is given by build method.
The left child of node A has start=A.left, end=(A.left + A.right) / 2.
The right child of node A has start=(A.left + A.right) / 2 + 1, end=A.right.
if start equals to end, there will be no children for this node.
Implement a build method with two parameters start and end, so that we can create a corresponding segment tree with every node has the correct start and end value, return the root of this segment tree.


*/
public class Solution {
    /**
     *@param start, end: Denote an segment / interval
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int start, int end) {
        // write your code here
        if (start > end) {
            return null;
        }
        SegmentTreeNode pNode = new SegmentTreeNode(start, end);
        if (start == end) {
            return pNode;
        }
        pNode.left = build(start, (start + end) / 2);
        pNode.right = build((start + end) / 2 + 1, end);
        return pNode; 
    }
}
