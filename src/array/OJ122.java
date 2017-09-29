package array;

/**
 * Created by mingyazh on 2017/8/25.
 */
public class OJ122 {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int i=0;
        int j=0;
        int profit = 0;
        while(j<prices.length){
            if(prices[i]<prices[j]){
                if(j==prices.length-1){
                    profit += prices[j] - prices[i];
                }
                if(j<prices.length-1 && prices[j+1]<prices[j]){
                    profit += prices[j] - prices[i];
                    i=j+1;
                }
            }
            else{
                i=j;
            }
            j++;
        }
        return profit;
    }
}
