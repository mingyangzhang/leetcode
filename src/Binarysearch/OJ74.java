package Binarysearch;

/**
 * Created by mingyazh on 2017/6/10.
 */
public class OJ74 {
    int[][] matrix;
    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        int m = matrix.length;
        if(m==0) return false;
        int n = matrix[0].length;
        if(n==0) return false;
        for(int i=0; i<m; i++){
            if(matrix[i][0] == target) return true;
            if(matrix[i][n-1] == target) return true;
            if(matrix[i][0]<target && matrix[i][n-1]>target)
                return binarySearch(i, 0, n-1, target);
        }
        return false;
    }

    private boolean binarySearch(int col, int l, int r, int target){
        if(l==r) return matrix[col][l] == target;
        int mid = (l+r)/2;
        if(matrix[col][mid] == target) return true;
        if(matrix[col][mid]>target) return binarySearch(col, l, mid, target);
        else return binarySearch(col, mid+1, r, target);
    }
}
