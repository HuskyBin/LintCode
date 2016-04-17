/*
For an integer array (index from 0 to n-1, where n is the size of this array), in the corresponding SegmentTree, each node stores an extra attribute max to denote the maximum number in the interval of the array (index from start to end).

Design a query method with three parameters root, start and end, find the maximum number in the interval [start, end] by the given root of segment tree.

Have you met this question in a real interview? Yes
 Notice

It is much easier to understand this problem if you finished Segment Tree Build first.

Example
For array [1, 4, 2, 3], the corresponding Segment Tree is:

                  [0, 3, max=4]
                 /             \
          [0,1,max=4]        [2,3,max=3]
          /         \        /         \
   [0,0,max=1] [1,1,max=4] [2,2,max=2], [3,3,max=3]
query(root, 1, 1), return 4

query(root, 1, 2), return 4

query(root, 2, 3), return 3

query(root, 0, 2), return 4
*/
public class Solution {
    /**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (root == null || end < start || start < root.start || end > root.end) {
            throw new RuntimeException("Invalid input");
        }
        if (root.start == start && root.end == end) {
            return root.max;
        }
        int leftEnd = root.left.end;
        int rightStart = root.right.start;
        if (end <= leftEnd) {
            return query(root.left, start, end);
        }
        else if (start >= rightStart) {
            return query(root.right, start, end);
        }
        else {
            return Math.max(query(root.left, start, leftEnd), query(root.right, rightStart, end));
        }
    }
}
