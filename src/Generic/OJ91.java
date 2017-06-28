package Generic;

/**
 * Created by mingyazh on 2017/6/26.
 */
public class OJ91 {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        return numDecodings(s, 0, s.length());
    }

    private int numDecodings(String s, int left, int right){
        if(left>right) return 0;
        if(left == right) return 1;
        if(left+1==right){
            if(s.charAt(left) == '0')
                return 0;
            else
                return 1;
        }
        int mid = (left+right)/2;
        int addon = 0;
        if(s.charAt(mid-1) == '1' || (s.charAt(mid-1) == '2' && s.charAt(mid) != '9' && s.charAt(mid) != '8' && s.charAt(mid) != '7'))
            addon = numDecodings(s, left, mid-1)*numDecodings(s, mid+1, right);
        return addon + numDecodings(s, left, mid)*numDecodings(s, mid, right);
    }
}
