package Generic;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by mingyazh on 4/23/2017.
 */
public class OJ20 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='(' ||  c=='{' || c=='[') stack.push(c);
            if(c==')' ||  c=='}' || c==']'){
                if(stack.isEmpty()) return false;
                if(map.get(stack.pop()) != c) return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args){
        OJ20 sol = new OJ20();
        boolean isValid = sol.isValid("{}");
    }

}
