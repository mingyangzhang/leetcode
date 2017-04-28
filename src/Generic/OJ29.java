package Generic;

public class OJ29 {
    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean isNegative = (dividend < 0) != (divisor < 0);
        long longDividend = Math.abs(Long.valueOf(dividend));
        long longDivisor = Math.abs(Long.valueOf(divisor));
        int ans = 0;
        while(longDividend >= longDivisor){
            int i = 1;
            long temp = longDivisor;
            while(longDividend>=temp){
                longDividend -= temp;
                ans += i;
                temp <<= 1;
                i <<= 1;
            }
        }
        if(ans>Integer.MAX_VALUE) return isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
        return isNegative?-ans:ans;
    }
}