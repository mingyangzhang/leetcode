package array;

import java.util.Stack;

/**
 * Created by mingyazh on 2017/6/22.
 */
public class OJ84 {
    private int[] heights;
    public int largestRectangleArea(int[] heights) {
        this.heights = heights;
        return largestRect(0, heights.length-1);
    }

    private int largestRect(int left, int right){
        if(left>right) return 0;
        if(left == right) return left;
        if(left+1 == right) return 2*Math.min(left, right);
        int minIndex = 0;
        int minValue = Integer.MAX_VALUE;
        for(int i=left; i<=right ;i++){
            if(this.heights[i]<minValue){
                minValue = this.heights[i];
                minIndex = i;
            }
        }
        int maxArea = Math.max(largestRect(left, minIndex), largestRect(minIndex+1, right));
        return Math.max(minValue*(right-left+1), maxArea);
    }
    // O(n) stack solution, ref: http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
    public int stackSolution(int[] heights){
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
