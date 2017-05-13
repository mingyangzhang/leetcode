package Generic;

/**
 * Created by mingyazh on 5/13/2017.
 */
public class OJ48 {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        for(int i=0; i<N/2; i++) {
            for (int j=0; j<N/2; j++){
                int temp1 = matrix[j][N-1-i];
                matrix[j][N-1-i] = matrix[i][j];
                int temp2 = matrix[N-1-i][N-1-j];
                matrix[N-1-i][N-1-j] = temp1;
                temp1 = matrix[N-1-j][i];
                matrix[N-1-j][i] = temp2;
                matrix[i][j] = temp1;
            }
        }
        if(N%2 == 1){
            int j = N/2;
            for(int i=0; i<N/2; i++){
                int temp1 = matrix[j][N-1-i];
                matrix[j][N-1-i] = matrix[i][j];
                int temp2 = matrix[N-1-i][N-1-j];
                matrix[N-1-i][N-1-j] = temp1;
                temp1 = matrix[N-1-j][i];
                matrix[N-1-j][i] = temp2;
                matrix[i][j] = temp1;
            }
        }
    }
}