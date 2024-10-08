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
// class Solution {
//     public int pairSum(ListNode head) {
//         if(head == null){
//             return 0;
//         }
//         ListNode slow = head;
//         ListNode fast = head;
//         while(fast != null && fast.next != null){
//             slow = slow.next;
//             fast = fast.next.next;
//         }
//         ListNode head2 = reverseList(slow);
//         int max = 0;
//         ListNode current1 = head;
//         ListNode current2 = head2;

//         while(current2 != null){
//             int sum = current1.val + current2.val;
//             max = Math.max(max, sum);
//             current1 = current1.next;
//             current2 = current2.next;
//         }
//         return max;
//     }
//     private ListNode reverseList(ListNode head) {
//         ListNode temp = head;
//         ListNode prev = null;
//         ListNode next = null;
//         while(temp != null){
//             next = temp.next;
//             temp.next = prev;
//             prev = temp;
//             temp = next;
//         }
//         head = prev;
//         return head;
//     }
// }





class Solution {
    private static int [] a = new int[100000];
    public int pairSum(ListNode head) {
        final int[] arr = a;
        int size = 0;
        while(head != null){
            arr[size++] = head.val;
            head = head.next;
        }


        int m  =size/2;
        int maxSum = 0;
        for(int i=0;i<m;i++){
            --size;
            if(arr[i] + arr[size] > maxSum){
                maxSum = arr[i] + arr[size];
            }
        }
        return maxSum;
    }
}
