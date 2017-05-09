package Generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by mingyazh on 5/8/2017.
 */
public class OJ46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int[] list = Arrays.copyOf(nums, nums.length);
        permute(list, 0, ans, nums);
        return ans;
    }
    private void permute(int[] list, int start, List<List<Integer>> ans, int[] nums){
        if(start == nums.length) {
            List<Integer> array = IntStream.of(list).boxed().collect(Collectors.toList());
            ans.add(new ArrayList<Integer>(array));
        }
        for(int i=start; i<list.length; i++){
            int temp = list[i];
            list[i] = list[start];
            list[start] = temp;
            permute(list, start+1, ans, nums);
            list[start]  = list[i];
            list[i] = temp;
        }
    }
}
