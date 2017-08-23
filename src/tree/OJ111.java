package tree;

/**
 * Created by mingyazh on 2017/8/22.
 */
public class OJ111 {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right!=null) return 1+minDepth(root.right);
        if(root.left!=null && root.right==null) return 1+minDepth(root.left);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
