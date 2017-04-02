package Binarysearch;

/**
 * Created by mingyazh on 3/28/2017.
 */
public class OJ35 {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        return binarySearch(nums, 0, nums.length-1, target);
    }

    private int binarySearch(int[] nums, int i, int j, int target){
        if(i==j){
            if(nums[i]<target) return i+1;
            else return i;
        }
        int m = (i+j)/2;
        if(nums[m]>target) return binarySearch(nums, 0, m, target);
        else if(nums[m]<target) return binarySearch(nums, m+1, j, target);
        else return m;
    }
    public static void main(String[] args){
        OJ35 sol = new OJ35();
        int[] A = {1};
        System.out.println(sol.searchInsert(A, 1));
    }
}
