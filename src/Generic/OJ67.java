package Generic;

/**
 * Created by mingyazh on 2017/6/12.
 */
public class OJ67 {
    public String addBinary(String a, String b) {
        if(a.length()==0) return b;
        if(b.length()==0) return a;
        if(a.length()<b.length()){
            String temp = a;
            a = b;
            b = temp;
        }
        StringBuffer ans = new StringBuffer();
        int ap = a.length()-1;
        int bp = b.length()-1;
        int addon = 0;
        while(ap>=0 || bp>=0){
            int add_1 = 0;
            if(ap>=0){
                if(a.charAt(ap)=='1')
                    add_1 = 1;
                ap--;
            }
            int add_2 = 0;
            if(bp>=0){
                if(b.charAt(bp)=='1')
                    add_2 = 1;
                bp--;
            }
            int sum = add_1+add_2+addon;
            if(sum==0){ans.append("0"); addon=0;}
            else if(sum==1) {ans.append("1"); addon=0;}
            else if(sum%2==0){ans.append("0"); addon=sum-1;}
            else{ans.append("1"); addon=sum-2;}
        }
        while(addon>0){
            if(addon%2==0){
                ans.append("0");
                addon=addon-1;
            }
            if(addon%2==1){
                ans.append("1");
                addon=addon-2;
            }
        }
        return ans.reverse().toString();
    }
}
