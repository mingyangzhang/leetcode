package Classic;


/**
 * Created by mingyazh on 2017/7/2.
 */
public class ContructBTS {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int pl, int pr, int[] inorder, int il, int ir){
        if(pl == pr){
            return new TreeNode(preorder[pl]);
        }
        TreeNode root = new TreeNode(preorder[pl]);
        int i = il;
        for(i=il; i<=ir; i++){
            if(inorder[i] == preorder[pl]){
                break;
            }
        }
        if(i>il){
            root.left = buildTree(preorder, pl+1, pl+i-il, inorder, il, i-1);
        }
        if(i<ir){
            root.right = buildTree(preorder, pl+i-il+1, pr, inorder, i+1, ir);
        }
        return root;
    }

    public static void  main(String[] args){
        ContructBTS sol = new ContructBTS();
        int[] p = new int[]{1,2};
        int[] i = new int[]{2,1};
        TreeNode root = sol.buildTree(p, i);
        System.out.print(root.val);
    }
}
