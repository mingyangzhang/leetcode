package Generic;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mingyazh on 4/27/2017.
 */
public class OJ36 {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[][] marker = new Set[9][9];
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                marker[i][j] = new HashSet<>();
                if(board[i][j] != '.')
                    for(int k=1; k<=9; k++)
                        marker[i][j].add(k);
            }
        }
        for(int x=0; x<9; x++){
            for(int y=0; y<9; y++){
                if(board[x][y] == '.') continue;
                Integer n = Character.getNumericValue(board[x][y]);
                if(!marker[x][y].contains(n)) return false;
                for(int i=0; i<9; i++){
                    marker[i][y].remove(n);
                    marker[x][i].remove(n);
                }
                for(int j=y+1;j<=(y/3)*3+2;j++){
                    marker[x][j].remove(n);
                }
                for(int i=x+1;i<=(x/3)*3+2;i++){
                    for(int j=(y/3)*3;j<=(y/3)*3+2;j++){
                        marker[i][j].remove(n);
                    }
                }
            }
        }
        return true;
    }
}
