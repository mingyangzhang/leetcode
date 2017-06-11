package Generic;

/**
 * Created by mingyazh on 2017/6/10.
 */
public class OJ75 {
    public void sortColors(int[] nums) {
        int cnt_0 = 0;
        int cnt_1 = 0;
        int cnt_2 = 0;
        for(int i: nums){
            if(i==0) cnt_0++;
            if(i==1) cnt_1++;
            if(i==2) cnt_2++;
        }
        for(int i=0; i<nums.length; i++){
            if(i<cnt_0) nums[i] = 0;
            else if(i>=cnt_0 && i<cnt_0+cnt_1) nums[i] = 1;
            else nums[i] = 2;
        }
    }

    public static void main(String[] args){
        OJ75 sol = new OJ75();
        int[] nums = new int[]{0};
        sol.sortColors(nums);
        for(int i:nums)
            System.out.print(i);
    }
}
