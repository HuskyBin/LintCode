/*
Given a boolean 2D matrix, find the number of islands.

 Notice

0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.

Have you met this question in a real interview? Yes
Example
Given graph:

[
  [1, 1, 0, 0, 0],
  [0, 1, 0, 0, 1],
  [0, 0, 0, 1, 1],
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 1]
]
return 3.
*/
public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int number = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == true && visited[i][j] == false) {
                    searchIsland(grid, i, j, visited);
                    number++;
                }
            }
        }
        return number;
    }
    
    private void searchIsland(boolean[][] grid, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        visited[x][y] = true;
        if (x < grid.length - 1 && grid[x + 1][y] == true && visited[x + 1][y] == false) {
            searchIsland(grid, x + 1, y, visited);
        }
        if (x > 0 && grid[x - 1][y] == true && visited[x - 1][y] == false) {
            searchIsland(grid, x - 1, y, visited);
        }
        if (y < grid[0].length - 1 && grid[x][y + 1] == true && visited[x][y + 1] == false) {
            searchIsland(grid, x, y + 1, visited);
        }
        if (y > 0 && grid[x][y - 1] == true && visited[x][y - 1] == false) {
            searchIsland(grid, x, y - 1, visited);
        }
    }
}
