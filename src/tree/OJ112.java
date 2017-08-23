package tree;

/**
 * Created by mingyazh on 2017/8/22.
 */
public class OJ112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, sum, 0);
    }
    private boolean hasPathSum(TreeNode root, int sum, int base){
        if(root == null) return false;
        if(root.left==null && root.right==null) return base+root.val == sum;
        return hasPathSum(root.left, sum, base+root.val) || hasPathSum(root.right, sum, base+root.val);
    }
}
