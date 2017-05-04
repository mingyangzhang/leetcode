package Backtracking;

import java.util.ArrayList;

/**
 * Created by mingyazh on 5/3/2017.
 */
public class OJ37 {
    boolean done = false;

    public void solveSudoku(char[][] board) {
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    list.add(new int[]{i, j});
                }
            }
        }
        solve(board, list, 0);
    }

    private void solve(char[][] board, ArrayList<int[]> list, int cnt){
        if(cnt == list.size()){
            this.done = true;
            return;
        }
        int[] pos = list.get(cnt);
        int x = pos[0];
        int y = pos[1];
        for(char c='1'; c<='9'; c++){
            if(!done){
                board[x][y] = c;
                boolean valid = isValidSudoku(board, x, y);
                if(valid){
                    solve(board, list, cnt+1);
                }
                if(!done) board[x][y] = '.';
            }
        }
    }

    private boolean isValidSudoku(char[][] board, int x, int y) {
        char val = board[x][y];
        for(int i=0; i<9; i++){
            if(board[i][y] == val && i!=x) return false;
            if(board[x][i] == val && i!=y) return false;
        }

        for(int i=(x/3)*3;i<=(x/3)*3+2;i++){
            for(int j=(y/3)*3;j<=(y/3)*3+2;j++){
                if(board[i][j] == val)
                    if(i!=x || j!=y)
                        return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String[] s = new String[]{"..9748...","7........",
                                  ".2.1.9...","..7...24.",
                                  ".64.1.59.",".98...3..",
                                  "...8.3.2.", "........6",
                                  "...2759.."};
        char[][] board = new char[9][9];
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                board[i][j] = s[i].charAt(j);
            }
        }
        OJ37 sol = new OJ37();
        sol.solveSudoku(board);
        sol = null;
    }
}
