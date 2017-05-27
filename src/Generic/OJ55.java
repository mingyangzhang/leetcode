package Generic;

/**
 * Created by mingyazh on 2017/5/26.
 */
public class OJ55 {
    public boolean canJump(int[] nums) {
        int N = nums.length;
        if(N<=1) return true;
        if(nums[0] == 0) return false;
        int index = N-2;
        while(index>=0){
            if(nums[index] != 0) index--;
            else{
                int zeroPos = index;
                index--;
                while(index>=0 && nums[index]<zeroPos-index+1) index--;
                if(index==0 && nums[0]<zeroPos+1) return false;
            }
        }
        return true;
    }
}
