package DP;

/**
 * Created by mingyazh on 3/30/2017.
 */
public class OJ63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(m==1) {
            for (int i = 0; i < n; i++){
                if(obstacleGrid[0][i]==1)
                    return 0;
            }
            return 1;
        }
        if(n==1) {
            for (int i = 0; i < m; i++){
                if(obstacleGrid[i][0]==1)
                    return 0;
            }
            return 1;
        }
        int[][] tb = new int[m][n];
        int val = 1;
        for(int i=0; i<m;i++){
            if(obstacleGrid[i][0] == 1) val=0;
            tb[i][0] = val;
        }
        val = 1;
        for(int i=0; i<n;i++){
            if(obstacleGrid[0][i] == 1) val=0;
            tb[0][i] = val;
        }

        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1) tb[i][j] = 0;
                else tb[i][j] = tb[i-1][j] + tb[i][j-1];
            }
        return tb[m-1][n-1];
    }

    public static void main(String[] args){
        OJ63 sol = new OJ63();
        int[][] o = new int[1][1];
        o[0][0] = 0;
        System.out.println(sol.uniquePathsWithObstacles(o));
    }
}
