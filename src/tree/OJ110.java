package tree;

/**
 * Created by mingyazh on 2017/8/21.
 */
public class OJ110 {
    public boolean isBalanced(TreeNode root) {
        count_tree(root);
        return _isBalanced(root);
    }
    private int count_tree(TreeNode root){
        if(root==null) return 0;
        root.val = 1 + Math.max(count_tree(root.left), count_tree(root.right));
        return root.val;
    }
    private boolean _isBalanced(TreeNode root){
        if(root == null) return true;
        int left_size = 0;
        int right_size = 0;
        if(root.left != null) left_size = root.left.val;
        if(root.right != null) right_size = root.right.val;
        if(Math.abs(left_size-right_size)>1) return false;
        if(!_isBalanced(root.left) || !_isBalanced(root.right)) return false;
        return true;
    }
}
