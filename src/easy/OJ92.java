package easy;

/**
 * Created by mingyazh on 2017/6/26.
 */
public class OJ92 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || head.next == null) return head;
        ListNode phead = new ListNode(-1);
        phead.next = head;
        ListNode p = phead;
        ListNode lf = head;
        int counter = 1;
        while(counter<m){
            p = p.next;
            lf = lf.next;
            counter++;
        }
        reverse(p, lf, n-m+1);
        return phead.next;
    }

    private void reverse(ListNode pre, ListNode head, int k){
        int n = 1;
        ListNode left = head;
        ListNode right = head.next;
        while(n<k){
            ListNode follow = right.next;
            right.next = left;
            left = right;
            right = follow;
            n++;
        }
        head.next = right;
        pre.next = left;
    }
}
