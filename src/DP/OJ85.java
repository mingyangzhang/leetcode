package DP;

/**
 * Created by mingyazh on 4/3/2017.
 */
public class OJ85 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m==0) return 0;
        int n = matrix[0].length;
        if(n==0) return 0;

        int[][] length = new int[m][n];
        int[][] width = new int[m][n];
        if(matrix[m-1][n-1] == '1'){
            length[m-1][n-1] = 1;
            width[m-1][n-1] = 1;
        }
        else{
            length[m-1][n-1] = 0;
            width[m-1][n-1] = 0;
        }
        for(int i=m-2; i>=0; i--){
            if(matrix[i][n-1] == '0'){
                length[i][n-1] = 0;
                width[i][n-1] = 0;
            }
            else{
                length[i][n-1] = length[i+1][n-1]+1;
                width[i][n-1] = 1;
            }
        }

        for(int i=n-2; i>=0; i--){
            if(matrix[m-1][i] == '0'){
                length[m-1][i] = 0;
                width[m-1][i] = 0;
            }
            else{
                length[m-1][i] = 1;
                width[m-1][i] = width[m-1][i+1]+1;
            }
        }

        for(int i=m-2; i>=0; i--)
            for(int j=n-2; j>=0; j--){
                if(matrix[i][j] == '0'){
                    length[i][j] = 0;
                    width[i][j] = 0;
                }
                else{

                }

        }

        int area = 0;
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++){
                if(area<length[i][j]*width[i][j]) area = length[i][j]*width[i][j];
            }

        return area;
    }

    public static void main(String[] args){
        char[][] matrix = new char[4][];
        matrix[0] = new char[]{'1', '0', '1', '0', '0'};
        matrix[1] = new char[]{'1', '0', '1', '1', '1'};
        matrix[2] = new char[]{'1', '1', '1', '1', '1'};
        matrix[3] = new char[]{'1', '0', '0', '1', '0'};
        char[][] matrix2 = new char[1][1];
        matrix2[0][0] = '0';
        OJ85 sol = new OJ85();
        System.out.print(sol.maximalRectangle(matrix));
    }
}
