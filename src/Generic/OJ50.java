package Generic;

/**
 * Created by mingyazh on 2017/5/21.
 */
public class OJ50 {
    public double myPow(double x, int n) {
        if(n>=0) return PositivePow(x, n);
        if(x == 1.0) return 1.0;
        if(n == Integer.MIN_VALUE){
            return 1/(x*PositivePow(x, -(n+1)));
        }
        return 1/PositivePow(x, -n);
    }

    private double PositivePow(double x, int n){
        if(n==0) return 1;
        if(n%2 == 0){
            double sqrt = PositivePow(x, n/2);
            return sqrt*sqrt;
        }
        else{
            double sqrt = PositivePow(x, (n-1)/2);
            return sqrt*sqrt*x;
        }
    }
}
