package Classic;

/**
 * Created by mingyazh on 2017/6/29.
 */
public class Regex {
    private String s;
    private String p;
    int[][] mark;
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        mark = new int[s.length()+1][p.length()+1];
        mark[s.length()][p.length()] = 1;
        for(int i=0; i<s.length(); i++)
            mark[i][p.length()] = -1;
        return isMatch(0, 0);
    }

    private boolean isMatch(int i, int j){
        if(mark[i][j] != 0)
            return mark[i][j] == 1;
        if(i>=s.length()){
            if(p.charAt(j)=='*' || (j<p.length()-1 && p.charAt(j+1)=='*'))
                return isMatch(i, j+1);
            else {
                mark[i][j] = -1;
                return false;
            }
        }
        if(j<p.length()-1 && p.charAt(j+1) == '*'){
            if(s.charAt(i) != p.charAt(j) && p.charAt(j) != '.'){
                return isMatch(i, j+2);
            }
            else{
                return isMatch(i+1, j+2)|| isMatch(i, j+2) || isMatch(i+1, j);
            }
        }
        if(p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))
            return isMatch(i+1, j+1);
        mark[i][j] = -1;
        return false;
    }

    public static void main(String[] args){
        Regex sol = new Regex();
        System.out.print(sol.isMatch("a", "ab*"));
    }
}
