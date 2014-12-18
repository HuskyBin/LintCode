/*
Given an integer array, heapify it into a min-heap array.
For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
Example
Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.

Challenge
O(n) time complexity

Clarification
What is heap?

Heap is a data structure, which usually have three methods: push, pop and top. where "push" add a new element the heap, "pop" delete the minimum/maximum element in the heap, "top" return the minimum/maximum element.

What is heapify?
Convert an unordered integer array into a heap array. If it is min-heap, for each element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >= A[i].

What if there is a lot of solutions?
Return any of them.
*/
public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        if (A == null) {
            return;
        }
        int firstNonLeafeIndex = A.length / 2 - 1;
        for (int i = firstNonLeafeIndex; i >= 0; i--) {
            heapifyNode(A, i);
        }
        return;
    }
    
    private void heapifyNode(int[] A, int index) {
        int leftNode = index * 2 + 1;
        int rightNode = index * 2 + 2;
        int minIndex = index;
        if (leftNode < A.length && A[leftNode] < A[minIndex]) {
            minIndex = leftNode;
        }
        if (rightNode < A.length && A[rightNode] < A[minIndex]) {
            minIndex = rightNode;
        }
        if (minIndex != index) {
            swap(A, minIndex, index);
            heapifyNode(A, minIndex);
        }
    }
    
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
