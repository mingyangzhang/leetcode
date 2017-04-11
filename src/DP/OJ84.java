package DP;

import java.lang.invoke.LambdaConversionException;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by mingyazh on 4/6/2017.
 */
public class OJ84 {
    public int largestRectangleArea(int[] heights) {
        int N = heights.length;
        int area = 0;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while(index<N){
            if(stack.isEmpty() || heights[stack.peek()]<=heights[index]) stack.add(index);
            else{
                while(!stack.isEmpty() && heights[stack.peek()]>heights[index]) {
                    int i = stack.pop();
                    if (!stack.isEmpty() && area < (index-stack.peek()-1) * heights[i])
                        area = (index-stack.peek()-1) * heights[i];
                    else if(stack.isEmpty() && index*heights[i]>area) area = index*heights[i];
                }
                stack.add(index);
            }
            index++;
        }
        return 0;
    }

    public static void main(String[] args){
        OJ84 sol = new OJ84();
        int[] h = new int[]{2,1,5,6,2,3};
        System.out.println(sol.largestRectangleArea(h));
    }
}
