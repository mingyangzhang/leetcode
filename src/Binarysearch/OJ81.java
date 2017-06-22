package Binarysearch;

/**
 * Created by mingyazh on 2017/6/20.
 */
public class OJ81 {
    public boolean search(int[] nums, int target) {
        if(nums.length==0) return false;
        int maxIndex = findMax(nums, 0, nums.length-1);
        while(maxIndex<nums.length-1 && nums[maxIndex+1] == nums[maxIndex]) maxIndex++;
        return search(nums, target, 0, nums.length-1, maxIndex);
    }

    private int findMax(int[] nums, int left, int right){
        if(left == right) return left;
        if(left+1 == right) return nums[left]>nums[right]?left:right;
        if(nums[right]>nums[left]) return right;
        int mid = (left+right)/2;
        if(nums[mid]>nums[(left+right)/2+1]) return mid;
        if(nums[mid]>nums[left]) return findMax(nums, mid+1, right);
        if(nums[mid] == nums[left]){
            int index = mid;
            while(index<nums.length-1 && nums[index+1]==nums[left]) index++;
            if(index == nums.length-1) return  findMax(nums, left, mid);
            else return index+1;
        }
        else return findMax(nums, left, mid);
    }

    private boolean search(int[] nums, int target, int left, int right, int maxIndex){
        if(left == right) return nums[(left+maxIndex+1)%nums.length] == target;
        int mid = (left+right)/2;
        if(nums[(mid+maxIndex+1)%nums.length] == target) return true;
        if(nums[(mid+maxIndex+1)%nums.length] < target) return search(nums, target, mid+1, right, maxIndex);
        else return search(nums, target, left, mid, maxIndex);
    }

    public static void main(String[] args){
        OJ81 sol = new OJ81();
        int[] nums = new int[]{1, 1, 3,1,1,1,1,1,1};
        System.out.print(sol.search(nums, 3));
    }
}
