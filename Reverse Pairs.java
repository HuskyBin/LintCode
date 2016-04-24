public class Solution {
   /*
   

For an array A, if i < j, and A [i] > A [j], called (A [i], A [j]) is a reverse pair.
return total of reverse pairs in A.
Have you met this question in a real interview?
Example

Given A = [2, 4, 1, 3, 5] , (2, 1), (4, 1), (4, 3) are reverse pairs. return 3

   */
    /**
     * @param A an array
     * @return total of reverse pairs
     */
    public long reversePairs(int[] A) {
        // Write your code here
        if (A == null) {
            return 0;
        }
        return mergeSort(A, 0, A.length - 1);
    }
    
    private long mergeSort(int[] A, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int sum = 0;
        int mid = start + (end - start) / 2;
        sum += mergeSort(A, start, mid);
        sum += mergeSort(A, mid + 1, end);
        sum += merge(A, start, mid, end);
        return sum;
    }
    
    
    private long merge(int[] A, int start, int mid, int end) {
        int[] temp = new int[A.length];
        int sum = 0;
        int leftIndex = start;
        int rightIndex = mid + 1;
        int index = start;
        while (leftIndex <= mid && rightIndex <= end) {
            if (A[leftIndex] <= A[rightIndex]) {
                temp[index++] = A[leftIndex];
                leftIndex++;
            }
            else {
                temp[index++] = A[rightIndex];
                rightIndex++;
                sum += mid - leftIndex + 1;
            }
        }
        while (leftIndex <= mid) {
            temp[index++] = A[leftIndex++];
        }
        while (rightIndex <= end) {
            temp[index++] = A[rightIndex++];
        }
        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }
        return sum;
    }   
 
}
