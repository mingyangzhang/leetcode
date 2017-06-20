package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mingyazh on 2017/6/19.
 */
public class OJ78 {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        boolean[] mark = new boolean[n];
        backtrace(new ArrayList<Integer>(), mark, ans, 0, nums, 0);
        return ans;
    }

    private void backtrace(List<Integer> list, boolean[] mark, List<List<Integer>> ans, int d, int[] nums, int index){
        if(d>mark.length) return;
        ans.add(new ArrayList<>(list));
        for(int i=index; i<mark.length; i++){
            if(!mark[i]){
                mark[i] = true;
                list.add(nums[i]);
                backtrace(list, mark, ans, d+1, nums, i);
                list.remove(list.size()-1);
                mark[i] = false;
            }
        }
    }
}
