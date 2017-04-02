package Binarysearch;

/**
 * Created by mingyazh on 3/28/2017.
 */
public class OJ33 {
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        int maxIndex = searchMax(nums, 0, nums.length-1);
        return binarySearch(maxIndex, nums, target, 0, nums.length-1);
    }
    private int searchMax(int[] nums, int i, int j){
        if(i==j) return i;
        int m = (i+j)/2;
        if(nums[m]>nums[m+1]) return m;
        else if(nums[m]>=nums[i]) return searchMax(nums, m+1, j);
        else return searchMax(nums, i, m);
    }
    private int binarySearch(int maxIndex, int[] nums, int target, int i, int j){
        if(i>j) return -1;
        if(i==j){
            if(nums[(i+1+maxIndex)%nums.length]==target) return (i+1+maxIndex)%nums.length;
            else return -1;
        }
        int m = (i+j)/2;
        int val = nums[(m+1+maxIndex)%nums.length];
        if(val == target) return (m+1+maxIndex)%nums.length;
        else if(val>target) return binarySearch(maxIndex, nums, target, i, m);
        else return binarySearch(maxIndex, nums, target, m+1, j);
    }
    public static void main(String[] args){
        OJ33 sol = new OJ33();
        int[] A = {3,1};
        System.out.print(sol.search(A, 1));
    }
}
