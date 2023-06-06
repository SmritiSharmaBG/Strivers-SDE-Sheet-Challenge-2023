import java.util.ArrayList;

public class Solution {
    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        int[][] chess = new int[n][n];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        dfs(ans, chess, 0, n);
        return ans; 
    }

    private static void dfs(ArrayList<ArrayList<Integer>> ans, int[][] chess, int col, int n) {
        if (col == n) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int[] i : chess) {
                for (int j : i) {
                    temp.add(j);
                }
            }
            ans.add(temp);
            return;
        }

        for (int row = 0; row < n; row ++) {
            if (isSafe(chess, row, col, n)) {
                chess[row][col] = 1;
                dfs(ans, chess, col + 1, n);
                chess[row][col] = 0; // backtracking
            }
        }

    }

    private static boolean isSafe(int[][] chess, int r, int c, int n) {
        // we just need to check behind, down diag, up diag in LHS
        // behind -- dec col, row same
        for (int i = c; i >= 0; i --) {
            if (chess[r][i] == 1) return false;
        }
        // down diag LHS -- inc row, col dec
        int row = r + 1;
        int col = c - 1;
        while (row < n && col >= 0) {
            if (chess[row][col] == 1) return false;
            row ++;
            col --;
        }
        // up dia LHS -- dec col, row dec
        row = r - 1;
        col = c - 1;
        while (row >= 0 && col >= 0) {
            if (chess[row][col] == 1) return false;
            row --;
            col --;
        }
        return true;
    }
}
