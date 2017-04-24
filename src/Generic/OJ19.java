package Generic;

import java.util.ArrayList;

/**
 * Created by mingyazh on 4/23/2017.
 */

//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}
public class OJ19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null || n==0)
            return head;
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode index = head;
        while(index!=null){
            list.add(index);
            index = index.next;
        }
        int N = list.size();
        if(N==n) return list.get(0).next;
        list.get(N-n-1).next = list.get(N-n).next;
        return head;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        OJ19 sol = new OJ19();
        head = sol.removeNthFromEnd(head,1);
        head = null;
    }
}
