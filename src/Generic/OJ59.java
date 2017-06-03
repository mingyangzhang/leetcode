package Generic;

/**
 * Created by mingyazh on 2017/6/2.
 */
public class OJ59 {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        spiral(mat, 0, 0, n-1, n-1, 1);
        return mat;
    }

    private void spiral(int[][] matrix, int lx, int ly, int rx, int ry, int seed){
        if(lx>rx || ly>ry) return;

        for(int i=ly; i<=ry; i++)
            matrix[lx][i] = seed++;
        for(int i=lx+1; i<=rx; i++)
            matrix[i][ry] = seed++;
        for(int i=ry-1; i>=ly; i--)
            matrix[rx][i] = seed++;
        for(int i=rx-1; i>=lx+1; i--)
            matrix[i][ly] = seed++;
        spiral(matrix, lx+1, ly+1, rx-1, ry-1, seed);
    }
}
