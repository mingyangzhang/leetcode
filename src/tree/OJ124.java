package tree;

/**
 * Created by mingyazh on 2017/9/29.
 */

//每条path有一个最高点，遍历所有的节点做最高点的最大
//路径权重和，记录其中的最大值；
//    对于特点的节点node，它做最高点的最大路径权重和为：
//    左边最大路径（只能向下走）权重和 + 节点值 + 右边最大路径（只能向下走）权重和
    
public class OJ124 {
    private int maxVal;
    public int maxPathSum(TreeNode root) {
        this.maxVal = root.val;
        maxPathDown(root);
        return this.maxVal;
    }

    private int maxPathDown(TreeNode root){
        if(root==null) return 0;
        int left=0;
        int right=0;
        if(root.left!=null) left = Math.max(0, maxPathDown(root.left));
        if(root.right!=null) right = Math.max(0, maxPathDown(root.right));
        maxVal = Math.max(maxVal, left+right+root.val);
        return root.val + Math.max(left, right);
    }
}