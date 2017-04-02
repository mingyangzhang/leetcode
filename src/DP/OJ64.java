package DP;

import java.util.stream.IntStream;

/**
 * Created by mingyazh on 3/31/17.
 */
public class OJ64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m==1){
            int sum = 0;
            for(int g:grid[0]) sum+=g;
            return sum;
        }
        if(n==1){
            int sum = 0;
            for(int[] g:grid) sum+=g[0];
            return sum;
        }

        int[][] w = new int[m][n];
        w[m-1][n-1]=grid[m-1][n-1];
        for(int i=m-2; i>=0; i--) w[i][n-1] = w[i+1][n-1] + grid[i][n-1];
        for(int i=n-2; i>=0; i--) w[m-1][i] = w[m-1][i+1] + grid[m-1][i];
        for(int i=m-2; i>=0; i--)
            for(int j=n-2; j>=0; j--){
                w[i][j] = grid[i][j] + Math.min(w[i][j+1], w[i+1][j]);
            }
        return w[0][0];
    }

    public static void main(String[] args){
        int[][] grid = new int[1][1];
        grid[0][0] = 1;
        OJ64 sol = new OJ64();
        System.out.print(sol.minPathSum(grid));
    }
}
