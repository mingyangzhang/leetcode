package array;

import java.util.Stack;

/**
 * Created by mingyazh on 2017/6/23.
 */
// 基于OJ84, 以i行为底边的Largest Rectangle in Histogram.
public class OJ85 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m==0) return 0;
        int n = matrix[0].length;
        if(n==0) return 0;
        int[] h = new int[n];
        int maxRec = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == '1')
                    h[j]++;
                else
                    h[j] = 0;
            }
            maxRec = Math.max(maxRec, maxArea(h));
        }
        return maxRec;
    }

    private int maxArea(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0; i<=heights.length; i++){
            int val = i==heights.length?0:heights[i];
            if(stack.isEmpty() || val>heights[stack.peek()]) stack.push(i);
            else if(val == heights[stack.peek()]){
                stack.pop();
                stack.push(i);
            }
            else{
                int h = heights[stack.pop()];
                int w = stack.isEmpty()?-1:stack.peek();
                maxArea = Math.max((i-w-1)*h, maxArea);
                i--;
            }
        }
        return maxArea;
    }
}
