package Generic;

/**
 * Created by mingyazh on 2017/6/4.
 */
public class OJ60 {
    public String getPermutation(int n, int k) {
        StringBuffer ans = new StringBuffer();
        int[] ref = new int[n];
        int[] stair = new int[n];
        stair[n-1] = 1;
        for(int i=0; i<n; i++) {
            ref[i] = i+1;
            if(i>0)
                stair[n-i-1] = stair[n-i]*i;
        }
        for(int i=0; i<n; i++){
            int ind = k%stair[i] == 0?k/stair[i]:k/stair[i]+1;
            k = k%stair[i] == 0?stair[i]:k%stair[i];
            ans.append(String.valueOf(ref[ind-1]));
            for(int j=ind; j<n; j++){
                ref[j-1] = ref[j];
            }
        }
        return ans.toString();
    }

    public static void main(String[] args){
        OJ60 sol = new OJ60();
        String ans = sol.getPermutation(1, 1);
        System.out.print(ans);
    }
}
