package array;

/**
 * Created by mingyazh on 3/23/2017.
 */
public class OJ495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0) return 0;
        int rt = timeSeries[0] + duration;
        int lasting = duration;
        for(int i=1; i<timeSeries.length; i++) {
            int tp = timeSeries[i];
            if(tp + duration > rt && tp < rt){
                lasting += tp + duration - rt;
                rt = tp + duration;
            }
            else if(tp >= rt){
                lasting += duration;
                rt = tp + duration;
            }
            else continue;
        }
        return lasting;
    }

    public static void main(String[] args){
        OJ495 sol = new OJ495();
        int[] timeSeries = {1, 2, 5};
        int duration = 2;
        System.out.println(sol.findPoisonedDuration(timeSeries, duration));
    }
}
