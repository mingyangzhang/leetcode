package array;

import java.util.*;

/**
 * Created by mingyazh on 3/26/2017.
 */
public class OJ15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rslt = new ArrayList<>();
        if(nums.length == 0) return rslt;
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=nums.length-1; i>=0; i--) {
            map.put(nums[i], i);
            while(i>0 && nums[i] == nums[i-1]) i--;
        }
        for(int i=0; i<nums.length-2; i++) {
            while(i<nums.length-2 && nums[i]==nums[i+1]) i++;
            for (int j = i + 1; j < nums.length - 1; j++) {
                while (j<nums.length-1 && nums[j] == nums[j+1]) j++;
                int val = -(nums[i] + nums[j]);
                Integer ind = map.get(val);
                if (ind != null && ind > j) {
                    rslt.add(Arrays.asList(nums[i], nums[j], nums[ind]));
                }
            }
        }
        return rslt;
    }


    public static void main(String[] args){
        OJ15 sol = new OJ15();
        System.out.print(sol.threeSum(new int[]{0, 0, 0}));
    }
}
