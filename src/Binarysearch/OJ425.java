package Binarysearch;

import java.util.HashMap;

/**
 * Created by mingyazh on 3/18/2017.
 */
public class OJ425 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int cnt = 0;
        int N = A.length;
        HashMap<Integer, Integer> val_map = new HashMap<>();
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++){
                Integer val = val_map.get(A[i]+B[j]);
                val_map.put(A[i]+B[j], val!=null?val+1:1);
            }
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++){
                int val = C[i]+D[j] != 0?-(C[i]+D[j]):0;
                Integer num = val_map.get(val);
                if(num != null)
                    cnt += num;
            }

        return cnt;
    }

    public static void main(String[] args){
        OJ425 sol = new OJ425();
        int[] A = {-1, -1};
        int[] B = {-1, 1};
        int[] C = {-1, 1};
        int[] D = {1, -1};
        System.out.print(sol.fourSumCount(A, B, C, D));
    }
}
