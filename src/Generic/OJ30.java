package Generic;

import java.util.*;

/**
 * Created by mingyazh on 4/28/2017.
 */
public class OJ30 {
    public List<Integer> findSubstring(String s, String[] words) {
        int strLen = s.length();
        int wordSize = words.length;
        int wordLen = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<wordSize; i++) {
            if(map.containsKey(words[i]))
                map.put(words[i], map.get(words[i])+1);
            else
                map.put(words[i], 1);
        }

        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> temp = new HashMap<>();
        for(int i=0; i<strLen-wordLen*wordSize+1; i++){
            temp.clear();
            if(i>wordLen && !ans.contains(i-wordLen)){
                if(s.substring(i-wordLen, i).equals(s.substring(i+wordLen*(wordSize-1), i+wordLen*wordSize)))
                    continue;
            }
            if(!map.containsKey(s.substring(i, i+wordLen))) continue;
            int j = 1;
            temp.put(s.substring(i, i+wordLen), 1);
            while(j<wordSize){
                String str = s.substring(i+j*wordLen, i+(j++ +1)*wordLen);
                if(!map.containsKey(str)) {j = wordSize+1; break;}
                else {
                    if(temp.containsKey(str)) {
                        if(temp.get(str) > map.get(str)) {j = wordSize+1; break;}
                        temp.put(str, temp.get(str) + 1);
                    }
                    else
                        temp.put(str, 1);
                }
            }
            if(j == wordSize+1) continue;
            boolean isEqual = true;
            for(String key: map.keySet()){
                if(!temp.containsKey(key) || !temp.get(key).equals(map.get(key))) {
                    isEqual = false;
                    break;
                }
            }
            if(isEqual) ans.add(i);
        }

        return ans;
    }

    public static void main(String[] args){
        OJ30 sol = new OJ30();
        String s = "ababaabababaab";
        String[] words = new String[] {"ab","ba","ba"};
        List<Integer> ans = sol.findSubstring(s,  words);
        sol = null;
    }
}
