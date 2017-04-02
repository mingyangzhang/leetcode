package Divide;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mingyazh on 3/19/17.
 */
public class OJ53 {
    public int maxSubArray(int[] nums) {
        int N = nums.length;
        int left = 0;
        ArrayList<Integer> blocks = new ArrayList<>();
        while(left<N && nums[left]<=0) left++;
        if(left == N){
            int max=nums[0];
            for(int i:nums)
                if(i>max)
                    max = i;
            return max;
        }
        int right = left;
        while(right<N){
            if(nums[right]==0) right++;
            int val = 0;
            while(right<N && nums[left]*nums[right]>=0){
                val += nums[right++];
            }
            left = right;
            if(val!=0)
                blocks.add(val);
        }
        int max = 0;
        left = 0;
        while(left<blocks.size()) {
            int sum = 0;
            int i=left;
            int localMax = blocks.get(left);
            while(i < blocks.size() - 1 && blocks.get(i) + blocks.get(i + 1)+sum>=0){
                if(localMax<sum+blocks.get(i)) localMax = sum+blocks.get(i);
                sum+=blocks.get(i) + blocks.get(i + 1);
                i += 2;
            }
            if(i<blocks.size() && localMax<sum+blocks.get(i)) localMax = sum+blocks.get(i);
            if(localMax>max) max = localMax;
            left = i+2;
        }
        return max;
    }

    public static void main(String[] args){
        OJ53 sol = new OJ53();
        int[] nums = {2,0,-3,2,1,0,1,-2};
        int max = sol.maxSubArray(nums);
        System.out.println(max);
    }
}
