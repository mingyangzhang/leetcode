package Generic;

public class OJ27 {
    public int removeElement(int[] nums, int val) {
        if(nums==null || nums.length <1) return nums.length;
        int i = 0;
        int j = 0;
        while(j<nums.length){
            if(nums[j]==val) j++;
            else{
                nums[i++] = nums[j];
                j++;
            }
        }
        return i;
    }
}