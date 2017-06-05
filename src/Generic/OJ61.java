package Generic;

import java.util.List;

/**
 * Created by mingyazh on 2017/6/4.
 */
public class OJ61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode p = head;
        int len = 0;
        while(p!=null){
            p = p.next;
            len++;
        }
        if(len==0) return null;
        k = k%len;
        if(k<1) return head;

        ListNode mid = head;
        for(int i=0; i<k; i++){
            mid = mid.next;
        }
        ListNode tail = mid;
        mid = head;
        while(tail.next != null){
            tail = tail.next;
            mid = mid.next;
        }
        mid = mid.next;
        head = reverse(head, len-k-1);
        mid = reverse(mid, k-1);
        tail = head;
        for(int i=0; i<len-k-1; i++){
            tail = tail.next;
        }
        tail.next = mid;
        return reverse(head, len-1);
    }

    private ListNode reverse(ListNode head, int k){
        ListNode p = head;
        ListNode q = head.next;
        while(k-->0){
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        head.next = null;
        return p;
    }

    public static void main(String[] args){
        OJ61 sol = new OJ61();
        ListNode head = new ListNode(1);
        ListNode p = head;
        for(int i=2; i<=5; i++){
            p.next = new ListNode(i);
            p = p.next;
        }
        ListNode ans = sol.rotateRight(head, 2);
        System.out.print(ans);
    }
}
