package Generic;

import java.util.ArrayList;

/**
 * Created by mingyazh on 5/1/2017.
 */
public class OJ32 {
    public int longestValidParentheses(String s) {
        int N = s.length();
        while(N>0 && s.charAt(N-1) == '(') N--;
        if(N<=1) return 0;
        int max = 0;
        ArrayList<int[]> list = new ArrayList<>();
        int start = 0;
        while(start<N && s.charAt(start) == ')') start++;
        for(int i=start; i<N-1; i++){
            if(s.charAt(i) == '(' && s.charAt(i+1) == ')'){
                int left = i;
                int right = i+1;
                while(right<N-1 && left>0 && s.charAt(left-1) == '(' && s.charAt(right+1) == ')'){
                    left--;
                    right++;
                }
                while(!list.isEmpty() && list.get(list.size()-1)[1] == left-1){
                    left = list.get(list.size()-1)[0];
                    list.remove(list.size()-1);
                    while(right<N-1 && left>0 && s.charAt(left-1) == '(' && s.charAt(right+1) == ')'){
                        left--;
                        right++;
                    }
                }
                list.add(new int[]{left, right});
                if(right-left+1>max) max = right-left+1;
                i = right;
            }
        }

        return max;
    }
}
