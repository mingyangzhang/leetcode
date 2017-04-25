/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class OJ23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode tail = null;

        PriorityQueue<ListNode> waiting= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });
        for(ListNode list: lists){
            if(list != null) waiting.add(list);
        }
        while(!waiting.isEmpty()){
            ListNode min = waiting.poll();
            if(head==null){
                head = min;
                tail = head;
            }
            else{
                tail.next = min;
                tail = tail.next;
            }
            waiting.remove(min);
            if(min.next!=null) waiting.add(min.next);
        }
        return head;
    }
}