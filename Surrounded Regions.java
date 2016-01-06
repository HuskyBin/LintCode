/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O''s into 'X''s in that surrounded region.

Have you met this question in a real interview? Yes
Example
X X X X
X O O X
X X O X
X O X X
After capture all regions surrounded by 'X', the board should be:

X X X X
X X X X
X X X X
X O X X

*/
public class Solution {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        // Write your code here
        if (board == null || board.length == 0) {
            return;
        }
        
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                processRegion(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                processRegion(board, i, board[0].length - 1);
            }
        }
        
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                processRegion(board, 0, i);
            }
            if (board[board.length - 1][i] == 'O') {
                processRegion(board, board.length - 1, i);
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'D') {
                    board[i][j] = 'O';
                }
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void processRegion(char[][] board, int row, int column) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(row);
        queue.add(column);
        while (queue.size() > 0) {
            int x = queue.poll();
            int y = queue.poll();
            
            enqueue(board, x + 1, y, queue);
            enqueue(board, x - 1, y, queue);
            enqueue(board, x, y + 1, queue);
            enqueue(board, x, y - 1, queue);
            board[x][y] = 'D';
        }
    }
    
    private void enqueue(char[][] board, int x, int y, Queue<Integer> queue) {
        if (x >= 0 && x < board.length && y > 0 && y < board[0].length && board[x][y] == 'O') {
            queue.add(x);
            queue.add(y);
        }
    }
    
    

}
