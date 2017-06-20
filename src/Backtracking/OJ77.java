package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mingyazh on 2017/6/19.
 */
public class OJ77 {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        boolean[] mark = new boolean[n];
        backtrace(new ArrayList<Integer>(), mark, ans, 0, k);
        return ans;
    }

    private void backtrace(List<Integer> list, boolean[] mark, List<List<Integer>> ans, int d, int k){
        if(d == k){
            ans.add(new ArrayList<Integer>(list));
        }
        int index = list.size()==0?0:list.get(list.size()-1);
        for(int i=index; i<mark.length; i++){
            if(!mark[i]){
                mark[i] = true;
                list.add(i+1);
                backtrace(list, mark, ans, d+1, k);
                list.remove(list.size()-1);
                mark[i] = false;
            }
        }
    }
}
