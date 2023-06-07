public class Solution {

	public static boolean isItSudoku(int matrix[][]) {

		return dfs(matrix);

	}

	private static boolean dfs(int[][] matrix) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                // already filled
                if (matrix[i][j] != 0) continue;

                for (int k = 1; k <= 9; k++) {
                    if (isValid(matrix, i, j, k)) {
                        matrix[i][j] = k;
                        if (dfs(matrix)) return true;
                        else matrix[i][j] = 0;
                        // else continue trying another k
                    }
                }
                return false;   // here because 1 - 9 nothing was valid. need to return and backtrack ...
            } // i
        } // j
        return true; // here because whole board is filled without returning false
    }

	private static boolean isValid(int[][] matrix, int r, int c, int k) {
		// check full row - change all col and keep row same
		for (int i = 0; i < 9; i ++) {
			if (i == c) continue;
			if (matrix[r][i] == k) return false;
		}

		// check full col - change all row and keep col same
		for (int i = 0; i < 9; i ++) {
			if (i == r) continue;
			if (matrix[i][c] == k) return false;
		}

		int startR = 0, endR = 0, startC = 0, endC = 0;
		if (r >= 0 && r <= 2) {
			startR = 0;
			endR = 2;
		}
		if (r >= 3 && r <= 5) {
			startR = 3;
			endR = 5;
		}
		if (r >= 6 && r <= 8) {
			startR = 6;
			endR = 8;
		}

		if (c >= 0 && c <= 2) {
			startC = 0;
			endC = 2;
		}
		if (c >= 3 && c <= 5) {
			startC = 3;
			endC = 5;
		}
		if (c >= 6 && c <= 8) {
			startC = 6;
			endC = 8;
		}
		for (int i = startR; i <= endR; i ++) {
			for (int j = startC; j <= endC; j ++) {
				if (matrix[i][j] == k) return false;
			}
		}
		return true;
	}
}
