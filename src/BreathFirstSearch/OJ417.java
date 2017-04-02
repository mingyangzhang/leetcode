package BreathFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mingyazh on 2/18/17.
 */
public class OJ417 {
    int [][] Pmark;
    int [][] Amark;

    public List<int[]> pacificAtlantic(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Pmark = new int[n][m];
        Amark = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(Pmark[i][j] == 0)
                    flow(matrix, i, j, Pmark, n, m, 0, 0);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(Amark[i][j] == 0)
                    flow(matrix, i, j, Amark, n, m, n, m);
            }
        }

        List<int[]> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(Amark[i][j] == 1 && Pmark[i][j] == 1)
                    ans.add(new int[] {i ,j});
            }
        }

        return ans;
    }

    private boolean flow(int[][] matrix, int x, int y, int[][] mark, int n, int m, int xb, int yb){
        if(mark[x][y] == 1) return true;
        if(mark[x][y] == -1) return false;
        if(x == xb || y == yb) { mark[x][y] = 1; return false;}

        if(x-1 >= 0 && matrix[x-1][y] < matrix[x][y]){
            if(flow(matrix, x-1, y, mark, n, m, xb, yb)){
                mark[x][y] = 1;
                return true;
            }
        }

        if(x+1 < n && matrix[x+1][y] < matrix[x][y]){
            if(flow(matrix, x+1, y, mark, n, m, xb, yb)){
                mark[x][y] = 1;
                return true;
            }
        }

        if(y-1 >= 0 && matrix[x][y-1] < matrix[x][y]){
            if(flow(matrix, x, y-1, mark, n, m, xb, yb)){
                mark[x][y] = 1;
                return true;
            }
        }

        if(y+1 < m && matrix[x][y+1] < matrix[x][y]){
            if(flow(matrix, x, y+1, mark, n, m, xb, yb)){
                mark[x][y] = 1;
                return true;
            }
        }

        mark[x][y] = -1;
        return false;
    }

    public static void main(String[] args){
        int matrix[][]={{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        OJ417 sol = new OJ417();
        List list = sol.pacificAtlantic(matrix);
    }
}
