package contest;

/**
 * Created by mingyazh on 3/4/17.
 */
public class OJ533 {
    public int findBlackPixel(char[][] picture, int N) {

        return 0;

    }

    public static void main(String[] args){
        char [][] pic = {{'W', 'B', 'W', 'B', 'B', 'W'},
                            {'W', 'B', 'W', 'B', 'B', 'W'},
                            {'W', 'B', 'W', 'B', 'B', 'W'},
                            {'W', 'W', 'B', 'W', 'B', 'W'}};
        int N =3;
        OJ533 sol = new OJ533();
        System.out.print(sol.findBlackPixel(pic, N));
    }
}
