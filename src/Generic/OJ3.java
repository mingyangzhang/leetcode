package Generic;

import java.net.Inet4Address;
import java.util.HashMap;

/**
 * Created by mingyazh on 3/20/2017.
 */
public class OJ3 {
    public int lengthOfLongestSubstring(String s) {
        int N = s.length();
        if(N==0) return 0;
        int max = 1;
        int left = 0;
        int right = left+1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put(s.charAt(left), left);
        while(right<N){
            if(map.containsKey(s.charAt(right))){
                if(right-left > max) max = right - left;
                int index = map.get(s.charAt(right))+1;
                for(int i = left;i<index; i++)
                    map.remove(s.charAt(i));
                left = index;
            }
            map.put(s.charAt(right), right);
            right++;
        }
        if(right-left>max) max = right - left;
        return max;
    }

    public static void main(String[] args){
        OJ3 sol = new OJ3();
        System.out.println(sol.lengthOfLongestSubstring("aaaa"));
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));
        System.out.println(sol.lengthOfLongestSubstring("dvdf"));
    }
}
