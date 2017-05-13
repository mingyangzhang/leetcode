package Generic;

import java.util.*;

/**
 * Created by mingyazh on 5/12/2017.
 */
public class OJ47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        permuteUnique(nums, ans, new ArrayList<Integer>(), new ArrayList<Integer>());
        return ans;
    }

    private void permuteUnique(int[] nums, List<List<Integer>> ans, List<Integer> temp, List<Integer> index){
        if(temp.size() == nums.length) ans.add(new ArrayList<Integer>(temp));
        Set<Integer> set = new TreeSet<>();
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
            if(index.contains(i)) continue;
            index.add(i);
            temp.add(nums[i]);
            permuteUnique(nums, ans, temp, index);
            temp.remove(temp.size()-1);
            index.remove(index.size()-1);
        }
    }
}
