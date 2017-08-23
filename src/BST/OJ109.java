package BST;

/**
 * Created by mingyazh on 2017/8/21.
 */
public class OJ109 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode tail = head;
        int len = 0;
        while(tail != null){
            len++;
            tail = tail.next;
        }
        return build(head, len);
    }
    private TreeNode build(ListNode head, int len){
        if(len == 1) return new TreeNode(head.val);
        if(len == 2){
            TreeNode root = new TreeNode(head.val);
            root.right = new TreeNode(head.next.val);
            return root;
        }
        int mid = len/2;
        ListNode MidNode = head;
        while(mid-->0){
            MidNode = MidNode.next;
        }
        TreeNode root = new TreeNode(MidNode.val);
        root.left = build(head, len/2);
        root.right = build(MidNode.next, len-len/2-1);
        return root;
    }
}
