package DP;

/**
 * Created by mingyazh on 2017/6/27.
 */
public class OJ94 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s2.length();
        int n = s1.length();
        if(s3.length()!=m+n)
            return false;
        boolean[][] mark = new boolean[m+1][n+1];
        mark[0][0] = true;
        for(int i=1; i<=n; i++){
            if(s1.charAt(i-1) == s3.charAt(i-1) && mark[0][i-1])
                mark[0][i] = true;
        }
        for(int i=1; i<=m; i++){
            if(s2.charAt(i-1) == s3.charAt(i-1) && mark[i-1][0])
                mark[i][0] = true;
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if((mark[i-1][j] && s2.charAt(i-1) == s3.charAt(i+j-1)) || (mark[i][j-1] && s1.charAt(j-1) == s3.charAt(i+j-1))){
                    mark[i][j] = true;
                }
            }
        }
        return mark[m][n];
    }
}
