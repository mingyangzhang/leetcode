package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mingyazh on 2017/8/22.
 */
public class OJ113 {
    private int sum;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        pathSum(root, ans, list, 0);
        return ans;
    }

    private void pathSum(TreeNode root, List<List<Integer>> ans, List<Integer> list, int base){
        if(root==null) return;
        if(root.left==null && root.right==null){
            if(root.val+base==sum){
                list.add(root.val);
                ans.add(new ArrayList<Integer>(list));
                list.remove(list.size()-1);
            }
            else return;
        }
        list.add(root.val);
        pathSum(root.left, ans, list, base+root.val);
        pathSum(root.right, ans, list, base+root.val);
        list.remove(list.size()-1);
    }
}
