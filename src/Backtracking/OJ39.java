package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OJ39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList();
        combinationSum(candidates, target, 0, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void combinationSum(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> ansSet){
        for(int i = start; i<candidates.length; i++){
            list.add(candidates[i]);
            if(target == candidates[i]) ansSet.add(new ArrayList<Integer>(list));
            if(target > candidates[i]) combinationSum(candidates, target-candidates[i], i, list, ansSet);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
    }
}
