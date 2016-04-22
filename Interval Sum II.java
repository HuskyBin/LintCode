/*
Given an integer array in the construct method, implement two methods query(start, end) and modify(index, value):

For query(start, end), return the sum from index start to index end in the given array.
For modify(index, value), modify the number in the given index to value
Have you met this question in a real interview? Yes
 Notice

We suggest you finish problem Segment Tree Build, Segment Tree Query and Segment Tree Modify first.

Example
Given array A = [1,2,7,8,5].

query(0, 2), return 10.
modify(0, 4), change A[0] from 1 to 4.
query(0, 1), return 6.
modify(2, 1), change A[2] from 7 to 1.
query(2, 4), return 14.
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
    /**
     * @param A: An integer array
     */
     
    SegmentNode root; 
    public Solution(int[] A) {
        // write your code here
        root = buildSegmentTree(A, 0, A.length - 1);
    }
    
    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        // write your code here
        return querySegmentTree(root, start, end);
        
    }
    
    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
	    modifyCore(root, index, value);
    }

    private void modifyCore(SegmentNode pNode, int index, int value) {
	    if (pNode.start == pNode.end && index == pNode.start) {
		    pNode.sum = Long.valueOf(value);
		    return;
	    }

	    int childLeftEnd = (pNode.start + (pNode.end - pNode.start) / 2);
	    int childRightStart = childLeftEnd + 1;
	    if (index <= childLeftEnd) {
		    modifyCore(pNode.left, index, value);
	    }
	    else {
		    modifyCore(pNode.right, index, value);
	    }
	    pNode.sum = pNode.left.sum + pNode.right.sum;
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

