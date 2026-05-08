/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val - b.val);
        for(ListNode list : lists){
            pq.add(list);
        }

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            temp.next = curr;
            temp = curr;

            if(temp.next != null) pq.add(temp.next);
        }

        return dummy.next;
    }
}
