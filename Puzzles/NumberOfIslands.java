/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
*/

class Solution {

    public void explore(char[][] grid, int i, int j, int m, int n) {

        if (i < 0 || j < 0) {
            return;
        }

        if (i >= m || j >= n) {
            return;
        }

        if (grid[i][j] == 'X' || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = 'X';

        explore(grid, i + 1, j, m, n);
        explore(grid, i - 1, j, m, n);
        explore(grid, i, j + 1, m, n);
        explore(grid, i, j - 1, m, n);
    }

    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; ++j) {

                if (grid[i][j] == '1') {
                    result++;
                    explore(grid, i, j, m, n);
                }
            }
        }
        return result;
        
    }
}
