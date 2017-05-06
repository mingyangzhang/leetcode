package Generic;

/**
 * Created by mingyazh on 5/5/2017.
 */
public class OJ42 {
    public int trap(int[] height) {
        int trap = 0;

        int maxInd = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[maxInd])
                maxInd = i;
        }

        int leftMax = 0;
        for (int i = 0; i < maxInd; i++) {
            if (height[i] > leftMax) leftMax = height[i];
            trap += leftMax - height[i];
        }

        int rightMax = 0;
        for (int i = height.length-1; i>maxInd; i++) {
            if(height[i]>rightMax) rightMax = height[i];
            trap += rightMax - height[i];
        }

        return trap;
    }
}
