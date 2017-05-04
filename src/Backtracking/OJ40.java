package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OJ40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList();
        combinationSum(candidates, target, -1, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void combinationSum(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> ansSet){
        for(int i = start+1; i<candidates.length; i++){
            if(i>start+1 && candidates[i-1] == candidates[i]) continue;
            list.add(candidates[i]);
            if(target == candidates[i]) ansSet.add(new ArrayList<Integer>(list));
            if(target > candidates[i]) combinationSum(candidates, target-candidates[i], i, list, ansSet);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
    }
}
