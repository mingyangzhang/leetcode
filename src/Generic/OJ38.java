package Generic;

/**
 * Created by mingyazh on 5/1/2017.
 */
public class OJ38 {
    public String countAndSay(int n) {
        if(n==1) return "1";
        return countAndSay("1", n);
    }
    private String countAndSay(String s, int n){
        if(n==1)  return s;
        StringBuffer buff = new StringBuffer();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int cnt = 1;
            while(i<s.length()-1 && s.charAt(i+1) == c) {
                cnt++;
                i++;
            }
            buff.append(cnt).append(c);
        }
        return countAndSay(buff.toString(), n-1);
    }

    public static void main(String[] args){
        OJ38 sol = new OJ38();
        System.out.print(sol.countAndSay(20));
    }
}
