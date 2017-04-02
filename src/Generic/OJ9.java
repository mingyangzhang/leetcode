package Generic;

/**
 * Created by mingyazh on 3/22/2017.
 */
public class OJ9 {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int y = x;
        int s = 1;
        while(y>=10) {y=y/10; s*=10;}
        while(s >= 10){
            int h = (x/s)%10;
            if(x%10 != h) return false;
            x = x/10;
            s /= 100;
        }
        return true;
    }

    public static void main(String[] args){
        OJ9 sol = new OJ9();
        System.out.print(sol.isPalindrome(10000021));
    }
}
