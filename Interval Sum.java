/*
Given an integer array (index from 0 to n-1, where n is the size of this array), and an query list. Each query has two integers [start, end]. For each query, calculate the sum number between index start and end in the given array, return the result list.

Have you met this question in a real interview? Yes
 Notice

We suggest you finish problem Segment Tree Build, Segment Tree Query and Segment Tree Modify first.

Example
For array [1,2,7,8,5], and queries [(0,4),(1,2),(2,4)], return [23,9,20]


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
 
 class SegmentNode {
	public SegmentNode left;
	public SegmentNode right;

	public int start;
	public int end;
	public Long sum;

	public SegmentNode(int start, int end, Long sum) {
		this.start = start;
		this.end = end;
		this.sum = sum;
	}
	
	public SegmentNode(int start, int end, int sum) {
	    this.start = start;
	    this.end = end;
	    this.sum = Long.valueOf(sum);
	}
}
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Long> intervalSum(int[] A, 
                                       ArrayList<Interval> queries) {
        // write your code here
        ArrayList<Long> result = new ArrayList<>();
        if (A == null || queries == null) {
        	return result;
        }

        SegmentNode root = buildSegmentTree(A, 0, A.length - 1);
        for (Interval i : queries) {
        	int start = Math.max(0, i.start);
        	int end = Math.min(A.length - 1, i.end);
        	result.add(querySegmentTree(root, start, end));
        }
        return result;
    }

    private Long querySegmentTree(SegmentNode pNode, int start, int end) {
    	if (pNode == null) {
    		throw new RuntimeException("Segment Node is null!");
    	}
    	if (pNode.start == start && pNode.end == end) {
    		return pNode.sum;
    	}
    	int childLeftEnd = (pNode.start + (pNode.end - pNode.start) / 2);
    	int childRightStart = childLeftEnd + 1;
    	if (end <= childLeftEnd) {
    		return querySegmentTree(pNode.left, start, end);
    	}
    	else if (start >= childRightStart) {
    		return querySegmentTree(pNode.right, start, end);
    	}
    	else {
    		return querySegmentTree(pNode.left, start, childLeftEnd) + querySegmentTree(pNode.right, childRightStart, end);
    	}
    } 

    private SegmentNode buildSegmentTree(int[] A, int start, int end) {
    	if (end < start) {
    		return null;
    	}
    	if (end == start) {
    		SegmentNode newNode = new SegmentNode(start, end, A[start]);
    		return newNode;
    	}
    	int childLeftEnd = (start + (end - start) / 2);
    	int childRightStart = childLeftEnd + 1;
    	SegmentNode newNode = new SegmentNode(start, end, 0);
    	SegmentNode leftChild = buildSegmentTree(A, start, childLeftEnd);
    	SegmentNode rightChild = buildSegmentTree(A, childRightStart, end);
    	newNode.sum = leftChild.sum + rightChild.sum;
    	newNode.left = leftChild;
    	newNode.right = rightChild;
    	return newNode;
    }
}
