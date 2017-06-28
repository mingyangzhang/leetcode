package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mingyazh on 2017/6/26.
 */
public class OJ93 {
    private String s;
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> ans = new ArrayList<>();
        this.s = s;
        backtrace(ans, 0, new StringBuilder(s.length()), 0);
        return ans;
        
    }

    private void backtrace(List<String> ans, int d, StringBuilder sf, int index){
        if(index>s.length()) return;
        if(d==4){
            ans.add(new String(sf));
            return;
        }
        if((4-d)*3 < s.length()-index || 4-d > s.length()-index) return;

        if(d==3){
            if(s.length()-index>1 && s.charAt(index) == '0')
                return;
            if(Integer.parseInt(s.substring(index, s.length()))<256){
                sf.append(s.substring(index, s.length()));
                backtrace(ans, d+1, sf, index+1);
                sf.delete(sf.length()-(s.length()-index), sf.length());
            }
            return;
        }
        if(s.charAt(index) == '0'){
            sf.append("0.");
            backtrace(ans, d+1, sf, index+1);
            sf.delete(sf.length()-2, sf.length());
            return;
        }
        sf.append(s.substring(index, index+1)+".");
        backtrace(ans, d+1, sf, index+1);
        sf.delete(sf.length()-2, sf.length());
        if(index<s.length()-1){
            sf.append(s.substring(index, index+2)+".");
            backtrace(ans, d+1, sf, index+2);
            sf.delete(sf.length()-3, sf.length());
        }
        if(index<s.length()-2 && Integer.parseInt(s.substring(index, index+3))<256){
            String temp = s.substring(index, index+3);
            sf.append(s.substring(index, index+3)+".");
            backtrace(ans, d+1, sf, index+3);
            sf.delete(sf.length()-4, sf.length());
        }
    }

    public static void main(String[] args){
        OJ93 sol = new OJ93();
        System.out.print(sol.restoreIpAddresses("010010"));
    }
}
