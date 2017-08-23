package BST;

/**
 * Created by mingyazh on 2017/6/28.
 */
public class OJ99 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
    private TreeNode firstNode;
    private TreeNode secondNode;
    public void recoverTree(TreeNode root) {
        travel(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    private void travel(TreeNode root){
        if(root == null)
            return;
        travel(root.left);

        if(firstNode == null && root.val < preNode.val){
            firstNode = root;
        }

        if(firstNode != null && root.val < preNode.val){
            secondNode = root;
            return;
        }
        preNode = root;
        travel(root.right);
    }
}
