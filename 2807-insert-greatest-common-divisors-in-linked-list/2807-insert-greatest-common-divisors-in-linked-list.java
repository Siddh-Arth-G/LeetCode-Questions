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
    private int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;
        while(temp != null && temp.next != null){
            int val1 = temp.val;
            int val2 = temp.next.val;
            int gcd = gcd(val1, val2);
            ListNode current = new ListNode(gcd);
            current.next = temp.next;
            temp.next = current;
            temp = current.next;
        }
        return head;
    }
}