package Binarysearch;

/**
 * Created by mingyazh on 3/28/2017.
 */
public class OJ34 {
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[]{-1, -1};

        if(nums.length==0) return range;
        int left = binarySearchLeft(nums, 0, nums.length-1, target);
        if(left==-1) return range;
        range[0] = left;
        range[1] = binarySearchRight(nums,left, nums.length-1, target);
        return range;
    }

    private int binarySearchRight(int[] nums, int i, int j, int target){
        if(i>j) return -1;
        if(i==j){
            if(nums[i]==target) return i;
            else return -1;
        }
        int m = (i+j)/2;
        if(nums[m]>target) return binarySearchRight(nums, i, m, target);
        else if(nums[m]<target) return binarySearchRight(nums, m+1, j, target);
        else{
            if(m==nums.length-1 || nums[m+1]>target) return m;
            else return binarySearchRight(nums, m+1, j, target);
        }
    }

    private int binarySearchLeft(int[] nums, int i, int j, int target){
        if(i>j) return -1;
        if(i==j){
            if(nums[i]==target) return i;
            else return -1;
        }
        int m = (i+j)/2;
        if(nums[m]>target) return binarySearchLeft(nums, i, m, target);
        else if(nums[m]<target) return binarySearchLeft(nums, m+1, j, target);
        else{
            if(m==0 || nums[m-1]<target) return m;
            else return binarySearchLeft(nums, i, m, target);
        }
    }

    public static void main(String[] args){
        OJ34 sol = new OJ34();
        int[] A = {1};
        int[] range = sol.searchRange(A, 0);
        for(int in: range)
            System.out.println(in);
    }

}
