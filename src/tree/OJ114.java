package tree;

/**
 * Created by mingyazh on 2017/8/22.
 */
public class OJ114 {
    public void flatten(TreeNode root) {
        if(root==null) return;
        if(root.left==null&root.right==null) return;
        TreeNode right = root.right;
        flatten(right);
        TreeNode left = root.left;
        if(left==null) return;
        root.left = null;
        flatten(left);
        TreeNode leftTail = left;
        while(leftTail.right!=null) leftTail=leftTail.right;
        root.right = left;
        leftTail.right = right;
    }
}
