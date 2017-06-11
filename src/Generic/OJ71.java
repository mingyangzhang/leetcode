package Generic;

import java.util.Stack;

/**
 * Created by mingyazh on 2017/6/10.
 */
public class OJ71 {
    public String simplifyPath(String path) {
        Stack<String> ps = new Stack();
        String ans = "";
        String[] nodes = path.split("/");
        for(String s: nodes){
            if(s.equals("") || s.equals(".")) continue;
            if(s.equals("..") && !ps.isEmpty()) ps.pop();
            else ps.push(s);
        }
        if(ps.isEmpty()) return "/";
        while(!ps.isEmpty()){
            if(!ps.peek().equals("")) {
                ans = "/" + ps.pop() + ans;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        OJ71 sol = new OJ71();
        System.out.print(sol.simplifyPath("/a/./b/../../c/"));
    }
}
