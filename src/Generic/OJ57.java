package Generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mingyazh on 2017/6/1.
 */
public class OJ57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.size() == 0){
            intervals.add(newInterval);
            return intervals;
        }
        int index = binaryFind(intervals, newInterval, 0, intervals.size()-1);
        if(index==-1){
            while(intervals.size()>0){
                if(intervals.get(0).start <= newInterval.end) {
                    newInterval.end = Math.max(newInterval.end, intervals.get(0).end);
                    intervals.remove(0);
                }
                else break;
            }
            intervals.add(0, newInterval);
            return intervals;
        }

        if(index == intervals.size()-1){
            if(newInterval.start<=intervals.get(index).end)
                intervals.get(index).end = Math.max(intervals.get(index).end, newInterval.end);
            else
                intervals.add(newInterval);
            return intervals;
        }

        if(intervals.get(index).end>=newInterval.start){
            newInterval.start = intervals.get(index).start;
            newInterval.end = Math.max(newInterval.end, intervals.get(index).end);
            intervals.remove(index);
            index--;
        }
        while(intervals.size()>index+1){
            if(intervals.get(index+1).start>newInterval.end){
                intervals.add(index+1, newInterval);
                break;
            }
            else{
                newInterval.end = Math.max(newInterval.end, intervals.remove(index+1).end);
            }
        }
        if(intervals.size() == index+1){
            intervals.add(newInterval);
        }
        return intervals;

    }

    private int binaryFind(List<Interval> intervals, Interval target, int left, int right){
        if(left==right){
            if(intervals.get(left).start > target.start)
                return left-1;
            else
                return left;
        }
        int mid = (left+right)/2;
        if(intervals.get(mid).start>=target.start)
            return binaryFind(intervals, target, left, mid);
        else
            return binaryFind(intervals, target, mid+1, right);
    }
}
