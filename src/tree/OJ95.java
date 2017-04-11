package tree;

import sun.reflect.generics.tree.Tree;

import javax.transaction.TransactionRequiredException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mingyazh on 4/10/2017.
 */

public class OJ95 {
    public List<TreeNode> generateTrees(int n) {
        return genTree(1, n);
    }

    private List<TreeNode>genTree(int from, int to){
        List<TreeNode> list = new ArrayList<>();
        if(from>to){
            list.add(null);
            return list;
        }
        List<TreeNode> left;
        List<TreeNode> right;
        for(int i=from; i<=to; i++){
            left = genTree(from, i-1);
            right = genTree(i+1, to);
            for(TreeNode ltree: left){
                for(TreeNode rtree: right) {
                    TreeNode root = new TreeNode(i);
                    root.left = ltree;
                    root.right = rtree;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
