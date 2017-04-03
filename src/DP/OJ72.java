package DP;

/**
 * Created by mingyazh on 4/1/17.
 */
public class OJ72 {
    String s1;
    String s2;
    int[][] distance;
    public int minDistance(String word1, String word2) {
        this.s1 =  word1;
        this.s2 = word2;
        int m = word1.length();
        int n = word2.length();
        if(m==0 || n==0) return Math.abs(m-n);
        distance = new int[m+1][n+1];
        for(int i=0; i<=m; i++)
            distance[i][0] = i;
        for(int i=1; i<=n; i++)
            distance[0][i] = i;
        for(int i=1; i<=m; i++)
            for(int j=1; j<=n; j++){
            if(s1.charAt(i-1) == s2.charAt(j-1)) distance[i][j] = distance[i-1][j-1];
            else{
                distance[i][j] = 1 + Math.min(Math.min(distance[i-1][j], distance[i][j-1]), distance[i-1][j-1]);
            }
        }
        return distance[m][n];
    }

    public static void main(String[] args){
        String s1 = "zoologicoarchaeologist";
        String s2 = "zoogeologist";
        OJ72 sol = new OJ72();
        System.out.print(sol.minDistance(s1, s2));
    }
}
