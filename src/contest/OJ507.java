package contest;

/**
 * Created by mingyazh on 3/26/2017.
 */
public class OJ507 {
    public boolean checkPerfectNumber(int num) {
        int celling = (int)Math.sqrt(num);
        int sum = 1;
        int devide = 2;
        while(sum<=num && devide<=celling){
            if(num%devide == 0){
                sum += devide + num/devide;
                if(sum == num)
                    return true;
            }
            devide ++;
        }
        return false;
    }

    public static void main(String[] args){
        int num = 6;
        OJ507 sol = new OJ507();
        System.out.println(sol.checkPerfectNumber(num));
    }
}
