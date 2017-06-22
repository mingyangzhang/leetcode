package Generic;

/**
 * Created by mingyazh on 2017/6/21.
 */
public class OJ82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode left = head;
        ListNode right = head.next;
        ListNode header = null;
        while(right != null){
            if(right.val == left.val) {
                while (right != null && right.val == left.val)
                    right = right.next;
                if(right == null){
                    if(header != null){
                        header.next = null;
                        return head;
                    }
                    return header;
                }
                if(header == null){
                    head = right;
                }
                else{
                    header.next = right;
                }
                left = right;
                right = left.next;
            }
            else{
                header = left;
                left = left.next;
                right = right.next;
            }
        }
        return head;
    }
}
