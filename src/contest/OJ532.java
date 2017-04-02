package contest;

import java.util.ArrayList;

/**
 * Created by mingyazh on 3/4/17.
 */
public class OJ532 {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        int N = nums.length;
        ArrayList<Integer> sum = new ArrayList<>();

        for (int i = 0; i < N - 1; i++)
            for (int j = 0; j < N - 1 - i; j++) {
                int diff = nums[i + j + 1] - nums[j];
                if (diff == k || diff == -k){
                    if(!sum.contains(nums[i + j + 1] + nums[j]))
                        sum.add(nums[i + j + 1] + nums[j]);
                }
            }
        return sum.size();
    }

    public static void main(String[] args){
        int[] nums = {6,3,5,7,2,3,3,8,2,4};
        int k =2;
        OJ532 sol = new OJ532();
        int result = sol.findPairs(nums, k);
        System.out.print(result);
    }
}
