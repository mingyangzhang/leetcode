package Generic;

/**
 * Created by mingyazh on 2017/6/1.
 */
public class OJ58 {
    public int lengthOfLastWord(String s) {
        int N = s.length();
        int len = 0;
        for(int i=N-1; i>=0; i--){
            char c = s.charAt(i);
            if(c==' ' && len>0){
                return len;
            }
            if(c!=' '){
                len++;
            }
        }
        return len;
    }
}
