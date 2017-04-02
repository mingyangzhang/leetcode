package array;

import java.util.Arrays;

/**
 * Created by mingyazh on 3/27/2017.
 */
public class OJ16 {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int val = 0;
        Arrays.sort(nums);
        int N = nums.length;
        for(int i=0; i<N-2; i++){
            int left = i+1;
            int right = N-1;
            while(left<right){
                if(nums[left] + nums[right] < target-nums[i]){
                    if(target-nums[i]-nums[left]-nums[right]<min){
                        min = target-nums[i]-nums[left]-nums[right];
                        val = nums[i] + nums[left] + nums[right];
                    }
                    left++;
                }
                else if(nums[left] + nums[right] >= target-nums[i]){
                    if(-target+nums[i]+nums[left]+nums[right]<min){
                        min = -target+nums[i]+nums[left]+nums[right];
                        val = nums[i] + nums[left] + nums[right];
                    }
                    right--;
                }
            }
        }
        return val;
    }

    public static void main(String[] args){
        OJ16 sol = new OJ16();
        int[] nums = new int[]{0, 1, 2};
        System.out.println(sol.threeSumClosest(nums, 3));
    }
}
