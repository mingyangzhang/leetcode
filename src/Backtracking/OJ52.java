package Backtracking;

/**
 * Created by mingyazh on 2017/5/25.
 */
public class OJ52 {
    private int count  = 0;
    public int totalNQueens(int n) {
        Character[][] matrix = new Character[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                matrix[i][j] = '.';
            }
        }
        backtrace(n, matrix, 0);
        return count;
    }

    private void backtrace(int n, Character[][] matrix, int col){
        if(col==n){
            count++;
            return;
        }
        for(int i=0; i<n; i++) {
            if(valid(i, col, matrix)) {
                matrix[col][i] = 'Q';
                backtrace(n, matrix, col + 1);
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
