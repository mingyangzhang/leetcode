package Generic;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by mingyazh on 3/20/2017.
 */

 //Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class OJ2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = head;
        int low = 0;
        while(l1 != null || l2 != null){
            int a = 0;
            if(l1 != null){
                a = l1.val;
                l1 = l1.next;
            }
            int b = 0;
            if(l2 != null){
                b = l2.val;
                l2 = l2.next;
            }
            int val = a+b+low;
            low = val/10;
            int digit = val%10;
            ListNode ln = new ListNode(digit);
            if(head == null) {head = ln; tail = head;}
            else{tail.next = ln; tail = tail.next;}
        }
        if(low != 0){
            tail.next = new ListNode(low);
        }
        return head;
    }
    public static void main(String[] args){
        OJ2 sol = new OJ2();
        ListNode  l1 = new  ListNode(0);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(8);
        ListNode l = sol.addTwoNumbers(l1, l2);
        System.exit(0);
    }
}
