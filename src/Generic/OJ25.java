package Generic;

public class OJ25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<=1 || head == null) return head;
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode left = head;
        ListNode right = head;
        ListNode pre = hair;
        while(right!=null){
            for(int i=1; i<k; i++){
                right = right.next;
                if(right==null) return hair.next;
            }
            reverse(pre, left, k);
            pre = left;
            left = left.next;
            right = left;
        }
        return hair.next;
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