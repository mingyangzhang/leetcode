package Generic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by mingyazh on 2017/5/27.
 */


class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class OJ56 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        intervals.sort(Comparator.comparing((Interval i) -> i.start));
        int index = 0;
        while(index<intervals.size()){
            Interval temp = new Interval(intervals.get(index).start, intervals.get(index).end);
            if(index == intervals.size()-1) {
                ans.add(temp);
                break;
            }
            while(index<intervals.size() && intervals.get(index).start<=temp.end){
                temp.end = Math.max(intervals.get(index).end, temp.end);
                index++;
            }
            ans.add(temp);
        }
        return ans;
    }
}
