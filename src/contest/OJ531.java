package contest;

import java.util.ArrayList;

/**
 * Created by mingyazh on 3/4/17.
 */
public class OJ531 {
    public int findLonelyPixel(char[][] picture) {
        int num =0;
        ArrayList<Integer> xcoor = new ArrayList<>();
        ArrayList<Integer> ycoor = new ArrayList<>();
        int n = picture.length;
        int m = picture[0].length;
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++){
                if(picture[i][j] == 'B'){
                    xcoor.add(i);
                    ycoor.add(j);
                }
            }

        for(int i=0; i<xcoor.size(); i++){
            if(xcoor.indexOf(xcoor.get(i)) == xcoor.lastIndexOf(xcoor.get(i)))
                if(ycoor.indexOf(ycoor.get(i)) == ycoor.lastIndexOf(ycoor.get(i)))
                    num++;
        }
        return num;
    }

    public static void main(String[] args){
        char [][] pic = {{'W', 'W', 'B'},
                         {'W', 'B', 'W'},
                         {'B', 'W', 'W'}};
        OJ531 sol = new OJ531();
        System.out.print(sol.findLonelyPixel(pic));
    }
}
