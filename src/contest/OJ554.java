package contest;

import java.util.HashMap;
import java.util.List;

/**
 * Created by mingyazh on 4/8/2017.
 */
public class OJ554 {
    public int leastBricks(List<List<Integer>> wall) {
        int sum = 0;
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(List<Integer> list: wall){
            for(int n: list) {
                sum+=n;
                if (map.containsKey(sum))
                    map.put(sum, map.get(sum) + 1);
                else map.put(sum, 1);
            }
            len = sum;
            sum=0;
        }
        int min = 0;
        for(int i: map.keySet()){
            if(i!=len && map.get(i)>min)
                min = map.get(i);
        }
        return wall.size()-min;
    }
}
