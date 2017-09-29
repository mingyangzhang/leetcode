package array;

/**
 * Created by mingyazh on 2017/8/25.
 */
public class OJ121 {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int i=0;
        int j=1;
        int profit = 0;
        while(j<prices.length){
            if(prices[j]-prices[i]>profit){
                profit = prices[j]-prices[i];
            }
            if(prices[j]<prices[i]){
                i = j;
            }
            j++;
        }
        return profit;
    }
}
