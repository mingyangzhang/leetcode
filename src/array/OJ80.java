package array;

/**
 * Created by mingyazh on 2017/6/19.
 */

//去除出现两次以上的数字：
//双指针扫描到需要去掉的数字，对后面的数组循环调用
//减少复制的次数

public class OJ80 {
    public int removeDuplicates(int[] nums) {
        return removeDuplicates(nums, 0);
    }

    private int removeDuplicates(int[] nums, int start){
        int n = nums.length;
        if(n-start<=2) return n-start;
        int i=start;
        int j=start+2;
        while(j<n){
            while(j<n && nums[i]!=nums[j]){
                i++;
                j++;
            }
            if(j==n) return n-start;
            if(nums[i] == nums[j]){
                int index = j;
                while(index<n && nums[index] == nums[index-1])
                    index++;
                if(index == n) return j-start;
                int len = removeDuplicates(nums, index);
                for(int k=index; k<index+len; k++) {
                    nums[k - (index - j)] = nums[k];
                }
                n = len+j;
            }
            i++;
            j++;
        }
        return n-start;
    }

    public static void main(String[] args){
        OJ80 sol = new  OJ80();
        int[] nums = new int[]{1,1,1,3};
        System.out.print(sol.removeDuplicates(nums));
    }
}
