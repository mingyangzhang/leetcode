package Generic;

public class OJ26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int i=0;
        int j=1;
        while(j<nums.length){
            if(nums[j]>nums[i]){
                nums[++i] = nums[j];
                j++;
            }
            else{
                while(j<nums.length && nums[j]==nums[i]){
                    j++;
                }
                if(j<nums.length){
                    nums[++i] = nums[j];
                }
            }
        }
        return i+1;
    }
}