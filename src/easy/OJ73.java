package easy;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by mingyazh on 2017/6/16.
 */
public class OJ73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(m==0) return;
        int n = matrix[0].length;
        if(n==0) return;
        boolean frow = false;
        boolean fcol = false;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    if(i==0) frow = true;
                    if(j==0) fcol = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i=1; i<m; i++) {
            if (matrix[i][0] == 0) {
                for (int k = 1; k < n; k++)
                    matrix[i][k] = 0;
            }
        }
        for(int j=1; j<n; j++){
            if (matrix[0][j] == 0) {
                for (int k = 1; k < m; k++)
                    matrix[k][j] = 0;
            }
        }

        if(frow){
            for(int i=0; i<n; i++)
                matrix[0][i] = 0;
        }

        if(fcol){
            for(int i=0; i<m; i++)
                matrix[i][0] = 0;
        }
    }
}
