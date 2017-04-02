package DP;

/**
 * Created by mingyazh on 4/1/17.
 */
public class OJ72 {
    public int minDistance(String word1, String word2, int shift1, int shift2) {
        String s1 = word1.substring(shift1);
        String s2 = word2.substring(shift2);
        int m = s1.length();
        int n = s2.length();
        if(m==0 || n==0) return Math.abs(m-n);
        if(s1.charAt(0) == s2.charAt(0)) return minDistance(word1, word2, shift1+1, shift2+1);
        else return 1 + minDistance(word1, word2, shift1+1, shift2+1);
    }

    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if(m==0 || n==0) return Math.abs(m-n);
        if(m<n) return minDistance(s2, s1);
        int k = minDistance(s1, s2, 0, 0);
        for(int i=1; i<k; i++){
            int p = i+minDistance(s1, s2, i, 0);
            if(p<k) k=p;
        }
        return k;
    }

    public static void main(String[] args){
        String s1 = "abc";
        String s2 = "aabc";
        OJ72 sol = new OJ72();
        System.out.print(sol.minDistance(s1, s2));
    }
}
