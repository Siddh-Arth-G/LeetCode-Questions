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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] output = new int[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                output[i][j] = -1;
            }
        }
        
        if(head == null){
            return output;
        }
        int rowStart = 0;
        int rowEnd = m-1;
        int columnStart = 0;
        int columnEnd = n-1;
        while(rowStart<=rowEnd && columnStart <=columnEnd){
            for(int i=columnStart; i<=columnEnd && head!= null; i++){
                output[rowStart][i] = head.val;
                head = head.next;        
            }
            rowStart++;
            
            for(int i=rowStart; i<=rowEnd && head != null; i++){
                output[i][columnEnd] = head.val;
                head = head.next;
            }
            columnEnd--;
            
            if(rowStart<=rowEnd){
                for(int i=columnEnd; i>=columnStart && head!=null; i--){
                    output[rowEnd][i] = head.val;
                    head = head.next;
                }
            }
            rowEnd--;
            
            if(columnStart<=columnEnd){
                for(int i=rowEnd; i>=rowStart && head!=null; i--){
                    output[i][columnStart] = head.val;
                    head = head.next;
                }
            }
            columnStart++;
        }
        return output;
    }
}