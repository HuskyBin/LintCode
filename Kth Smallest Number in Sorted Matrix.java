/*
Find the kth smallest number in at row and column sorted matrix.

Have you met this question in a real interview? Yes
Example
Given k = 4 and a matrix:

[
  [1 ,5 ,7],
  [3 ,7 ,8],
  [4 ,8 ,9],
]
return 5


*/
public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
     
    public class Node {
        public int val;
        public int x;
        public int y;
        
        public  Node(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    } 
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0) {
            throw new RuntimeException("Invalid input!");
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        PriorityQueue<Node> heap = new PriorityQueue<>(k, (a, b) -> a.val - b.val);
        int number = 0;
        int result = 0;
        heap.add(new Node(matrix[0][0], 0, 0));
        visited[0][0] = true;
        while (number < k) {
            Node top = heap.poll();
            int nextX = top.x + 1;
            int nextY = top.y + 1;
            if (nextX < matrix.length && visited[nextX][top.y] == false) {
                heap.add(new Node(matrix[nextX][top.y], nextX, top.y));
                visited[nextX][top.y] = true;
            }
            if (nextY < matrix[0].length && visited[top.x][nextY] == false) {
                heap.add(new Node(matrix[top.x][nextY], top.x, nextY));
                visited[top.x][nextY] = true;
            }
            result = top.val;
            number++;
        }
        if (number < k) {
            throw new RuntimeException("Invalid k!");
        }
        return result;
    }
}
