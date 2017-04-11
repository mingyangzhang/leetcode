package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by mingyazh on 4/10/2017.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
   TreeNode(int x) { val = x; }
}

public class OJ94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversal(root, ans);
        return ans;
    }

    public List<Integer> noRecursive(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.add(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            ans.add(node.val);
            root = node.right;
        }
        return ans;
    }

    private void inorderTraversal(TreeNode root, List<Integer>list){
        if(root==null) return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

}
