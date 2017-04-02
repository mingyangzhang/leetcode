package BreathFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mingyazh on 2/18/17.
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class OJ513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int leftLeaf=0;
        while(true) {
            if(queue.isEmpty()) break;
            int N = queue.size();
            TreeNode leftNode = queue.poll();
            leftLeaf = leftNode.val;
            if(leftNode.left != null) queue.add(leftNode.left);
            if(leftNode.right != null) queue.add(leftNode.right);
            for (int i = 0; i < N-1; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return leftLeaf;
    }
}
