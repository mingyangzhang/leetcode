package String;

/**
 * Created by mingyazh on 2017/6/29.
 */
public class OJ5 {
    public String longestPalindrome(String s) {
        if(s.length()<=1) return s;
        String ps = "";
        int max = 0;
        int k = 0;
        while(k<s.length()-max){
            int i=1;
            while(k-i>=0 && k+i<s.length() && s.charAt(k-i) == s.charAt(k+i))
                i++;
            if(i*2-1>max){
                max = i*2-1;
                ps = s.substring(k-i, k+i);
            }
            if(k+1<s.length() && s.charAt(k+1)==s.charAt(k)){
                i=1;
                while(k-i>=0 && k+1+i<s.length() && s.charAt(k-i) == s.charAt(k+1+i))
                    i++;
                if(2*i>max){
                    max = i*2;
                    ps = s.substring(k-i, k+1+i);
                }
            }

        }
        return ps;
    }
}
