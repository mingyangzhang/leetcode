package tree;

/**
 * Created by mingyazh on 2017/8/22.
 */
public class OJ115 {
    private int[][] N;
    public int numDistinct(String s, String t) {
        N = new int[t.length()+1][s.length()+1];
        for(int i=0; i<s.length()+1; i++) N[0][i] = 1;
        for(int i=1; i<t.length()+1; i++){
            for(int j=i; j<s.length()+1; j++){
                if(t.charAt(i-1)==s.charAt(j-1)){
                    N[i][j] = N[i-1][j-1] + N[i][j-1];
                }
                else N[i][j] = N[i][j-1];
            }
        }
        return N[t.length()][s.length()];
    }

    public static void main(String[] args){
        OJ115 sol = new OJ115();
        int n = sol.numDistinct("rabbbit", "rabbit");
        System.out.print(n);
    }
}
