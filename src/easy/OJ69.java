package easy;

/**
 * Created by mingyazh on 2017/6/10.
 */
public class OJ69 {
    public int mySqrt(int x) {
        if(x==0) return 0;
        if(x<=3) return 1;
        return binarySearch(x, 2, x/2);
    }

    private int binarySearch(int x, int left, int right){
        if(left == right) return left;
        int mid = (left+right)/2;
        if(mid>46340 || mid*mid>x) return binarySearch(x, left, mid);
        if(mid*mid == x) return mid;
        if(mid*mid<x && (mid+1>46340 || (mid+1)*(mid+1)>x)) return mid;
        if((mid+1)*(mid+1) == x) return mid+1;
        else return binarySearch(x, mid+1, right);
    }

    public static void main(String[] args){
        OJ69 sol = new OJ69();
        System.out.print(sol.mySqrt(2147395599));
    }
}
