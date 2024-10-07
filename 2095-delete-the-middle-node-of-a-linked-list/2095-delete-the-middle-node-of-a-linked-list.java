// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode deleteMiddle(ListNode head) {
//         if (head == null || head.next == null) {
//             return null;
//         }
        
//         ListNode slow = head;
//         ListNode fast = head;
//         ListNode prev = null; 

//         while (fast != null && fast.next != null) {
//             fast = fast.next.next;
//             prev = slow;
//             slow = slow.next;
//         }

//         prev.next = slow.next;

//         return head;
//     }
// }





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
    public ListNode deleteMiddle(ListNode head) {
        ListNode middleNode = getMiddleNode(head);

        if(head == null || head.next == null){
             return null;
        }

        if(middleNode.next == null){
             head.next = null;
             return head;
        }

        middleNode.val = middleNode.next.val;
        middleNode.next = middleNode.next.next;

        return head;
    }

    public ListNode getMiddleNode(ListNode head){

        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}