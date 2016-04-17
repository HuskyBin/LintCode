/*
Given an integer array (index from 0 to n-1, where n is the size of this array), and an query list. Each query has two integers [start, end]. For each query, calculate the minimum number between index start and end in the given array, return the result list.

Have you met this question in a real interview? Yes
 Notice

We suggest you finish problem Segment Tree Build, Segment Tree Query and Segment Tree Modify first.

Example
For array [1,2,7,8,5], and queries [(1,2),(0,4),(2,4)], return [2,1,5]

Challenge
O(logN) time for each query
*/
/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    class SegmentNode {
        public SegmentNode left;
        public SegmentNode right;
        public int start;
        public int end;
        public int min;
        
        public SegmentNode(int start, int end, int min) {
            this.start = start;
            this.end = end;
            this.min = min;
        }
    } 
     
    public ArrayList<Integer> intervalMinNumber(int[] A, 
                                                ArrayList<Interval> queries) {
        // write your code here
        ArrayList<Integer> resultList = new ArrayList<>();
        if (A == null || queries == null || queries.size() == 0) {
            return resultList;
        }
        SegmentNode root = buildSegmentTree(A, 0, A.length - 1);
        for (Interval i : queries) {
            resultList.add(query(root, i.start, i.end));
        }
        return resultList;
    }
    
    private int query(SegmentNode pNode, int start, int end) {
        if (pNode.start == start && pNode.end == end) {
            return pNode.min;
        }
        int leftEnd = (pNode.start + pNode.end) / 2;
        int rightStart = leftEnd + 1;
        if (start >= rightStart) {
            return query(pNode.right, start, end);
        }
        else if (end <= leftEnd) {
            return query(pNode.left, start, end);
        }
        else {
            return Math.min(query(pNode.left, start, leftEnd), query(pNode.right, rightStart, end));
        }
    }
    
    private SegmentNode buildSegmentTree(int[] A, int start, int end) {
        if (start == end) {
            SegmentNode leafNode = new SegmentNode(start, end, A[start]);
            return leafNode;
        }
        SegmentNode pNode = new SegmentNode(start, end, 0);
        int leftEnd = (start + end) / 2;
        int rightStart = leftEnd + 1;
        SegmentNode leftNode = buildSegmentTree(A, start, leftEnd);
        SegmentNode rightNode = buildSegmentTree(A, rightStart, end);
        pNode.left = leftNode;
        pNode.right = rightNode;
        pNode.min = Math.min(leftNode.min, rightNode.min);
        return pNode;
    }
}
