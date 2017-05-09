package Generic;

public class OJ41 {
    public int firstMissingPositive(int[] nums) {
        int N = nums.length;
        if(N==0) return 1;
        int left = 0;
        int right = N-1;
        while(left<right){
            while(right>=0 && nums[right]<=0) right--;
            while(left<N && nums[left]>0) left++;
            if(left>=right) break;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        int k=-1;
        while(k<N-1 && nums[k+1]>0) k++;
        for(int i=0; i<=k; i++){
            if(Math.abs(nums[i])<=k+1 && nums[Math.abs(nums[i])-1]>0)
                nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
        }
        for(int i=0; i<=k; i++)
            if(nums[i]>0) return i+1;
        return k+2;
    }

}