package DeepFristSearch;

import java.util.Stack;

/**
 * Created by mingyazh on 3/2/17.
 */
public class OJ494 {
    private int n = 0;
    private int S;
    public int findTargetSumWays(int[] nums, int S) {
        this.S = S;
        if( (nums[0] == S || nums[0] == -S) && nums.length == 1) this.n++;
        dfs(nums, nums[0], 1);
        return S==0?2*this.n:this.n;
    }

    private void dfs(int [] num, int val, int d){
        if(d >= num.length) return;
        if(d == num.length-1 && (val + num[d] == S || val + num[d] == -S)) this.n++;
        if(d == num.length-1 && (val - num[d] == S || val - num[d] == -S)) this.n++;
        dfs(num, val + num[d], d+1);
        dfs(num, val - num[d], d+1);
    }

    public static void main(String[] args){
        int[] nums = {44,20,38,6,2,47,18,50,41,38,32,24,38,38,30,5,26,15,37,35};
        int S = 44;
        OJ494 sol = new OJ494();
        System.out.print(sol.findTargetSumWays(nums, S));
    }
}
