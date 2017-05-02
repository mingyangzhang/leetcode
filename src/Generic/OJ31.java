package Generic;

/**
 * Created by mingyazh on 4/30/2017.
 */
public class OJ31 {

    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        int i=nums.length-1;
        int j=nums.length-2;
        while(j>=0){
            if(nums[j]>=nums[i]){
                i--;
                j--;
            }
            else{
                while(i<nums.length-1 && nums[i]>nums[j]) i++;
                if(nums[i]<=nums[j]) i--;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                if(i<nums.length-1) {
                    int index = i + 1;
                    while (index < nums.length - 1 && nums[index] > nums[i]) index++;
                    if (nums[index] < nums[i]) index--;
                    temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    left++;
                    right--;
                }

                j = Integer.MIN_VALUE;
                break;
            }
        }
        if(j==Integer.MIN_VALUE) return;

        i = 0;
        j = nums.length-1;

        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{1, 2, 1};
        OJ31 sol = new OJ31();
        sol.nextPermutation(nums);
        for(int n: nums)
            System.out.print(n);
    }
}
