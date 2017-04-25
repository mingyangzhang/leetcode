package Generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mingyazh on 4/24/2017.
 */
public class OJ22 {
    public class Solution {
        public List<String> generateParenthesis(int n) {
            ArrayList<String> ans = new ArrayList<>();
            if(n<1) return ans;
            bracket(ans, 0, 0, n-1, "");
            return ans;
        }

        private void bracket(List<String> list, int left, int right, int n, String s){
            if(s.length()==2*n){
                list.add("("+s+")");
                return;
            }
            if(left<n) bracket(list, left+1, right, n, s+"(");
            if(right<n && left>=right) bracket(list, left, right+1, n, s+")");
        }
    }
}
