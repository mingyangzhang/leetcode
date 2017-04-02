package Generic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mingyazh on 3/20/2017.
 */
public class OJ5 {
    public String longestPalindrome(String s) {
        if(s.length()==0) return "";
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> noWay = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            ArrayList<Integer> index;
            index = !map.containsKey(s.charAt(i))?new ArrayList<>():map.get(s.charAt(i));
            index.add(i);
            map.put(s.charAt(i), index);
        }
        int max = 1;
        String sub = s.substring(0, 1);
        for(Character key: map.keySet()){
            if(map.get(key).size()>1){
                ArrayList array = map.get(key);
                for(int l=0; l<array.size()-1; l++)
                    for(int r=l+1; r<array.size(); r++){
                        int ir = (int)array.get(r);
                        int il = (int)array.get(l);
                        if(ir-il>max-1 && (!noWay.containsKey(ir+il) || noWay.get(ir+il)>ir-il) && isPalindromic(s, il, ir, noWay)){
                            max = ir-il;
                            sub = s.substring(il, ir+1);
                        }
                    }
            }
        }
        return sub;
    }

    public Boolean isPalindromic(String s, int i, int j, HashMap<Integer, Integer> map){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) {
                map.put(i+j, j-i);
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args){
        OJ5 sol = new OJ5();
        System.out.println(sol.longestPalindrome("abafds"));
        System.out.println(sol.longestPalindrome("babad"));
        System.out.println(sol.longestPalindrome("cbbd"));
        System.out.println(sol.longestPalindrome("abcda"));
        System.out.println(sol.longestPalindrome("bananas"));
    }
}
