/*
Given two integer arrays sorted in ascending order and an integer k. Define sum = a + b, where a is an element from the first array and b is an element from the second one. Find the kth smallest sum out of all possible sums.

Have you met this question in a real interview? Yes
Example
Given [1, 7, 11] and [2, 4, 6].

For k = 3, return 7.

For k = 4, return 9.

For k = 8, return 15.
*/
public class Solution {
    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
    public class Node {
        public int val;
        public int x;
        public int y;
        
        public Node(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
     
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
        if (A == null || B == null || k <= 0) {
            throw new RuntimeException("Invalid input!");
        }
        if (k > A.length * B.length) {
            throw new RuntimeException("Invalid input!");
        }
        PriorityQueue<Node> heap = new PriorityQueue<>(k, new Comparator<Node>(){
           public int compare(Node a, Node b) {
               return a.val - b.val;
           } 
        });
        boolean[][] visited = new boolean[A.length][B.length];
        int number = 0;
        int result = 0;
        heap.add(new Node(A[0] + B[0], 0, 0));
        visited[0][0] = true;
        while (number < k) {
            Node top = heap.poll();
            int nextX = top.x + 1;
            int nextY = top.y + 1;
            if (nextX < A.length && visited[nextX][top.y] == false) {
                heap.add(new Node(A[nextX] + B[top.y], nextX, top.y));
                visited[nextX][top.y] = true;
            }
            if (nextY < B.length && visited[top.x][nextY] == false) {
                heap.add(new Node(A[top.x] + B[nextY], top.x, nextY));
                visited[top.x][nextY] = true;
            }
            result = top.val;
            number++;
        }
        return result;
    }
}
