package Generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mingyazh on 2017/5/26.
 */
public class OJ54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        if(m==0) return ans;
        int n = matrix[0].length;
        spiral(matrix, ans, 0, 0, m-1, n-1);
        return ans;
    }

    private void spiral(int[][] matrix, List<Integer> ans, int lx, int ly, int rx, int ry){
        if(lx>rx || ly>ry) return;
        if(lx == rx){
            for(int i=ly; i<=ry; i++)
                ans.add(matrix[lx][i]);
            return;
        }
        if(ly == ry){
            for(int i=lx; i<=rx; i++)
                ans.add(matrix[i][ly]);
            return;
        }

        for(int i=ly; i<=ry; i++)
            ans.add(matrix[lx][i]);
        for(int i=lx+1; i<=rx; i++)
            ans.add(matrix[i][ry]);
        for(int i=ry-1; i>=ly; i--)
            ans.add(matrix[rx][i]);
        for(int i=rx-1; i>=lx+1; i--)
            ans.add(matrix[i][ly]);
        spiral(matrix, ans, lx+1, ly+1, rx-1, ry-1);
    }
}
