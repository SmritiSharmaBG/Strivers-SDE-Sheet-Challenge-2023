import java.util.* ;
import java.io.*; 
public class Solution {
    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};
        maze[0][0] = 2;
        dfs(ans, maze, n, x, y, 0, 0);
        return ans;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> ans, int[][] maze, int n, int[] x, int[] y, int i, int j) {
        if (i == n - 1 && j == n - 1) {
            ans.add(makeList(maze, n));
            return;
        }

        // move up, right, down and left
        for (int k = 0; k < 4; k ++) {
            int ii = i + x[k];
            int jj = j + y[k];
            if (ii >= 0 && ii < n && jj >= 0 && jj < n && maze[ii][jj] == 1) {
                maze[ii][jj] = 2;
                dfs(ans, maze, n, x, y, ii, jj);
                maze[ii][jj] = 1;
            }

        }
    }

    private static ArrayList<Integer> makeList(int[][] maze, int n) {
        ArrayList<Integer> ds = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (maze[i][j] == 2) ds.add(1);
                else ds.add(0);
            }
        }
        return ds;
    }
} 
