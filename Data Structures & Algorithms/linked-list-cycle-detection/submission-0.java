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
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode , Boolean> amap = new HashMap<>();
        ListNode temp = head;
        while(temp != null){
            if(!amap.containsKey(temp)){
                amap.put(temp , true);
            }
            else return true;
            temp = temp.next;
        }
        return false;
    }
}
