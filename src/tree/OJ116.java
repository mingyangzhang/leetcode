package tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by mingyazh on 2017/8/23.
 */
public class OJ116 {
    private class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        Queue<TreeLinkNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int nLayer = queue.size();
            TreeLinkNode preNode = queue.poll();
            if(preNode.left!=null){
                queue.offer(preNode.left);
                queue.offer(preNode.right);
            }
            for(int i=0; i<nLayer-1; i++){
                TreeLinkNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                preNode.next = node;
                preNode = node;
            }
            if(preNode.left==null) break;
        }
    }
}
