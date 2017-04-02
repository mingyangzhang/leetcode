package DP;

/**
 * Created by mingyazh on 3/30/2017.
 */
public class OJ62 {
    public int uniquePaths(int m, int n) {
        if(n<=1 || m<=1) return 1;
        int[][] tb = new int[m][n];
        for(int i=0;i<m;i++) tb[i][0] = 1;
        for(int i=0;i<n;i++) tb[0][i] = 1;
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++){
                tb[i][j] = tb[i-1][j] + tb[i][j-1];
        }

        return tb[m-1][n-1];
    }

    public static void main(String[] args){
        OJ62 sol = new OJ62();
        System.out.println(sol.uniquePaths(3, 5));
    }
}
