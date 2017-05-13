package Generic;

import java.util.*;

/**
 * Created by mingyazh on 5/13/2017.
 */
public class OJ49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if(strs.length == 0) return ans;
        Map<String, Integer> map = new HashMap<String, Integer>();
        int index = 0;
        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!map.containsKey(key)){
                ans.add(new ArrayList<String>());
                map.put(key, index);
                ans.get(index).add(str);
                index++;
            }
            else{
                ans.get(map.get(key)).add(str);
            }

        }
        return ans;
    }
}
