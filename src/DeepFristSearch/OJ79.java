package DeepFristSearch;

/**
 * Created by mingyazh on 2017/6/19.
 */
public class OJ79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if(m==0) return false;
        int n = board[0].length;
        if(n==0) return false;
        if(m*n < word.length()) return false;
        boolean[][] mark = new boolean[m][n];
        boolean ans = false;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(search(board, i, j, word, 0, mark)) {
                    ans = true;
                    break;
                }
            }
        }

        return ans;
    }

    private boolean search(char[][] board, int x, int y, String s, int index, boolean[][] mark){
        if(mark[x][y]) return false;
        if(index==s.length()-1 && s.charAt(index)==board[x][y]) return true;
        char c = s.charAt(index);
        if(c!=board[x][y]) {
            return false;
        }
        else {
            mark[x][y] = true;
            if (x + 1 < board.length && search(board, x+1, y, s, index + 1, mark))
                return true;
            if (y + 1 < board[0].length && search(board, x, y+1, s, index + 1, mark))
                return true;
            if (x - 1 >= 0 && search(board, x-1, y, s, index + 1, mark))
                return true;
            if (y - 1 >= 0 && search(board, x, y-1, s, index + 1, mark))
                return true;
            mark[x][y] = false;
        }
        return false;
    }
}
