package Generic;

/**
 * Created by mingyazh on 4/24/2017.
 */
public class OJ21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head=null;
        ListNode tail=null;
        while(l1!=null && l2!=null){
            ListNode node;
            if(l1.val>l2.val){
                node=l2;
                l2=l2.next;
            }
            else{
                node=l1;
                l1=l1.next;
            }
            if(head==null){
                head=node;
                tail=head;
            }
            else{
                tail.next=node;
                tail=tail.next;
            }
        }
        if(l1!=null) tail.next=l1;
        if(l2!=null) tail.next=l2;
        return head;
    }
}
