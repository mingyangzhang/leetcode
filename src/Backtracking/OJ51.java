package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mingyazh on 2017/5/23.
 */
public class OJ51 {
    public List<List<String>> solveNQueens(int n) {
        Character[][] matrix = new Character[n][n];
        ArrayList<List<String>> ans = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                matrix[i][j] = '.';
            }
        }
        backtrace(n, matrix, ans, 0);
        return ans;
    }

    private void backtrace(int n, Character[][] matrix, List<List<String>> ans, int col){
        if(col==n){
            ArrayList<String> sol = new ArrayList<>();
            for(int i=-0; i<n; i++) {
                StringBuffer str = new StringBuffer();
                for(int j=0; j<n; j++)
                    str.append(matrix[i][j]);
                sol.add(str.toString());
            }
            ans.add(sol);
            return;
        }
        for(int i=0; i<n; i++) {
            if(valid(i, col, matrix)) {
                matrix[col][i] = 'Q';
                backtrace(n, matrix, ans, col + 1);
                matrix[col][i] = '.';
            }
        }
    }

    private boolean valid(int col, int row, Character[][] matrix){
        int N = matrix[0].length;
        for(int i=0; i<row; i++){
            if(matrix[i][col] == 'Q')
                return false;
        }

        for(int i=Math.max(0, row+col-N+1); i<Math.min(N, row+col); i++){
            if(matrix[i][row+col-i]=='Q')
                return false;
        }

        for(int i=Math.max(0, col-row); i<Math.min(N, N-row+col); i++){
            if(matrix[row-col+i][i] == 'Q')
                return false;
        }
        return true;
    }
}
