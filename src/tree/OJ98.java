package tree;

public class OJ98 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q==null){
            if(p==null && q==null) return true;
            else return false;
        }
        if(p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else return false;
    }
}