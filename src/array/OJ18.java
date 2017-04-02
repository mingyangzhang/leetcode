package array;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mingyazh on 3/27/2017.
 */
public class OJ18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List <List<Integer>> result = new ArrayList();
        if(nums.length==0) return result;
        HashMap<Integer, Integer[]> map = new HashMap();
        for(int i=0; i<nums.length-1;i++){
            for(int j=i+1; j<nums.length; j++){
                Integer[] coor = new Integer[]{i, j};
                map.put(nums[i]+nums[j], coor);
            }
        }

        for(int i=0; i<nums.length-1;i++){
            for(int j=i+1; j<nums.length; j++){
                Integer[] coor = map.get(target-(nums[i]+nums[j]));
                if(coor != null && !(i==coor[0] || i==coor[1] || j==coor[0] || j==coor[1])){
                    boolean duplicate = false;
                    int[] c = new int[]{nums[i], nums[j], nums[coor[0]], nums[coor[1]]};
                    Arrays.sort(c);
                    for(List list: result){
                        if(c[0]==(int)list.get(0) && c[1]==(int)list.get(1) && c[2]==(int)list.get(2) && c[3]==(int)list.get(3))
                            duplicate = true;
                    }
                    if(!duplicate)
                        result.add(Arrays.asList(c[0], c[1], c[2], c[3]));
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        OJ18 sol = new OJ18();
        int[] nums = new int[]{-4,-1,1,4};
        int target = 0;
        System.out.println(sol.fourSum(nums, target));
    }
}
