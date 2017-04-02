package array;

import javax.crypto.Mac;

/**
 * Created by mingyazh on 3/23/2017.
 */
public class OJ11 {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length-1;
        while(left<right){
            int area = (right - left)*Math.min(height[left], height[right]);
            if(area>max) max = area;
            if(height[left]>height[right]) right--;
            else left++;
        }
        return max;
    }

    public static void main(String[] args){
        OJ11 sol = new OJ11();
        int[] height = {1,3,2,5,25,24,5};
        System.out.println(sol.maxArea(height));
    }
}
