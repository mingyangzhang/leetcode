package Generic;

import java.util.Arrays;

/**
 * Created by mingyazh on 2017/6/25.
 */
public class OJ87 {
    public boolean isScramble(String s1, String s2) {
        if(s1.length()<=2 && s2.length()<=2)
            return charEqual(s1, s2);
        if(s1.length() != s2.length())
            return false;
        for(int i=1; i<s1.length(); i++){
            String ls1 = s1.substring(0, i);
            String rs1 = s1.substring(i);
            String ls2 = s2.substring(0, i);
            String rs2 = s2.substring(i);
            if(charEqual(ls1, ls2) && charEqual(rs1, rs2))
                if(isScramble(ls1, ls2) && isScramble(rs1, rs2))
                    return true;
            ls2 = s2.substring(s2.length()-i);
            rs2 = s2.substring(0, s2.length()-i);
            if(charEqual(ls1, ls2) && charEqual(rs1, rs2))
                if(isScramble(ls1, ls2) && isScramble(rs1, rs2))
                    return true;
        }
        return false;
    }

    private boolean charEqual(String s1, String s2){
        char[] charArray = s1.toCharArray();
        Arrays.sort(charArray);
        s1 = new String (charArray);
        charArray = s2.toCharArray();
        Arrays.sort(charArray);
        s2 = new String(charArray);
        return s1.equals(s2);
    }

    public static void main(String[] args){
        String s1 = "abb";
        String s2 = "bba";
        OJ87 sol = new OJ87();
        System.out.print(sol.isScramble(s1, s2));
    }
}
