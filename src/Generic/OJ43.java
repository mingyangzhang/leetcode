package Generic;

/**
 * Created by mingyazh on 5/5/2017.
 */
public class OJ43 {
    public String multiply(String num1, String num2) {
        String m1 = num1.length()>num2.length()?num1:num2;
        String m2 = num1.length()<=num2.length()?num1:num2;
        String ans = "0";
        String shift = "";
        for(int i=m2.length()-1; i>=0; i--){
            int n = m2.charAt(i) - '0';
            String temp = singleMultiply(m1, n);
            ans = add(ans, temp+shift);
            shift += "0";
        }
        return ans;
    }

    private String singleMultiply(String num1, int n){
        if(n==0) return "0";
        int addon = 0;
        String ans = "";
        for(int i=num1.length()-1; i>=0; i--){
            int m = num1.charAt(i) - '0';
            int rst = n*m + addon;
            ans = String.valueOf(rst%10) + ans;
            addon = (n*m + addon)/10;
        }
        if(addon > 0) ans = String.valueOf(addon) + ans;
        return ans;
    }

    private String add(String num1, String num2){
        int addon = 0;
        String ans = "";
        String m1 = num1.length()>num2.length()?num1:num2;
        String m2 = num1.length()<=num2.length()?num1:num2;
        for(int i=0; i<m2.length(); i++){
            int a1 = m1.charAt(m1.length()-1-i) - '0';
            int a2 = m2.charAt(m2.length()-1-i) - '0';
            int rst = a1 + a2 + addon;
            ans = String.valueOf(rst%10) + ans;
            addon = rst/10;
        }
        for(int i=m1.length()-m2.length()-1; i>=0; i--){
            int a1 = m1.charAt(i) - '0';
            int rst = a1 + addon;
            ans = String.valueOf(rst%10) + ans;
            addon = rst/10;
        }
        if(addon > 0) ans = String.valueOf(addon) + ans;

        return ans;
    }

    public static void main(String[] args){
        String s1 = "9";
        String s2 = "9";
        OJ43 sol = new OJ43();
        String s = sol.multiply(s1, s2);
        System.out.print(s);
    }
}
