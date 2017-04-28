package Generic;

public class OJ24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode ahead = hair;
        ListNode left = head;
        ListNode right = left.next;
        while(true){
            swap(ahead, left, right);
            ahead = left;
            left = left.next;
            if(left == null || left.next == null)
                break;
            right = left.next;
        }
        return hair.next;
    }

    private void swap(ListNode ahead, ListNode left, ListNode right){
        ListNode follow = right.next;
        right.next = left;
        left.next = follow;
        ahead.next = right;
    }
}