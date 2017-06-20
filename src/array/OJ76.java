package array;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by mingyazh on 2017/6/16.
 */
public class OJ76 {
    private class Counter{
        Map<Character, Integer> mark = new TreeMap();
        public Counter(String s){
            for(int i=0; i<s.length(); i++) {
                if (!mark.containsKey(s.charAt(i)))
                    mark.put(s.charAt(i), 1);
                else {
                    int temp = mark.get(s.charAt(i));
                    mark.put(s.charAt(i), temp + 1);
                }
            }
        }

        public boolean contain(char c){
            return mark.containsKey(c);
        }

        public void increase(char c){
            int temp = mark.get(c);
            mark.put(c, temp+1);
        }

        public void decrease(char c){
            int temp = mark.get(c);
            mark.put(c, temp-1);
        }

        public int get(char c){
            return mark.get(c);
        }
    }

    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n==0 || n<m) return "";
        if(m==1){
            if(s.contains(t))
                return t;
            else
                return "";
        }
        Counter mark = new Counter(t);
        int i=0;
        int j=0;
        int min = Integer.MAX_VALUE;
        String minWin = "";
        int match = m;
        while(j<n){
            char c = s.charAt(j);
            if(!mark.contain(c)){
                j++;
            }
            else{
                if(mark.get(c)>0) match--;
                mark.decrease(c);
                if(match==0){
                    while(!mark.contain(s.charAt(i)) || mark.get(s.charAt(i))<0) {
                        if(mark.contain(s.charAt(i)))
                            mark.increase(s.charAt(i));
                        i++;
                    }
                    if(j-i+1<min){
                        minWin = s.substring(i, j+1);
                        min = j-i+1;
                    }
                    mark.increase(s.charAt(i));
                    i++;
                    match++;
                }
                j++;
            }
        }
        return minWin;
    }
}
