package Generic;
import java.util.*;

public class OJ17 {
    public List<String> letterCombinations(String digits) {
        Deque<String> queue = new ArrayDeque<>();
        ArrayList<String> ans = new ArrayList<>();
        if(digits==null || digits.length()==0) return ans;
        Map<Character, String> map = new TreeMap();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        map.put('0', "");
        map.put('1', "");
        String val = "";
        for(int i=0; i<digits.length(); i++){
            val = map.get(digits.charAt(i));
            int size = queue.size();
            while(size-->0){
                String prefix = queue.poll();
                for(int j=0; j<val.length(); j++)
                    queue.offer(prefix+val.substring(j, j+1));
            }
            if(queue.isEmpty()){
                for(int j=0; j<val.length(); j++)
                    queue.offer(val.substring(j, j+1));
            }
        }
        while(!queue.isEmpty())
            ans.add(queue.poll());
        return ans;
    }

    public static void main(String[] args){
        String s = "23";
        OJ17 sol = new OJ17();
        List<String> ans = sol.letterCombinations(s);
    }
}