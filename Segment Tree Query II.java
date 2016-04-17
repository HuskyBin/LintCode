/*
For an array, we can build a SegmentTree for it, each node stores an extra attribute count to denote the number of elements in the the array which value is between interval start and end. (The array may not fully filled by elements)

Design a query method with three parameters root, start and end, find the number of elements in the in array's interval [start, end] by the given root of value SegmentTree.

Have you met this question in a real interview? Yes
 Notice

It is much easier to understand this problem if you finished Segment Tree Buildand Segment Tree Query first.

Example
For array [0, 2, 3], the corresponding value Segment Tree is:

                     [0, 3, count=3]
                     /             \
          [0,1,count=1]             [2,3,count=2]
          /         \               /            \
   [0,0,count=1] [1,1,count=0] [2,2,count=1], [3,3,count=1]
query(1, 1), return 0

query(1, 2), return 1

query(2, 3), return 2

query(0, 2), return 2


*/
public class Solution {
    /**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (root == null || end < start) {
            return 0;
        }
        if (start < root.start) {
            return query(root, root.start, end);
        }
        if (end > root.end) {
            return query(root, start, root.end);
        }
        if (root.start == start && root.end == end) {
            return root.count;
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
            return query(root.left, start, leftEnd) + query(root.right, rightStart, end);
        }
    }
}
