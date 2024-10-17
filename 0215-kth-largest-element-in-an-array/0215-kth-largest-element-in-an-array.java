// class Solution {
//     public int findKthLargest(int[] arr, int k) {
        
//      PriorityQueue<Integer>pq=new PriorityQueue<>();
//      for(int i=0;i<k;i++){
//         pq.add(arr[i]);
//      }
//      for(int i=k;i<arr.length;i++){
//         if(pq.peek()<arr[i]){
//         pq.remove();
//         pq.add(arr[i]);
//         }
//      }
//      return pq.peek();
//     }
// }




class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] records = new int[20001];

        for(int num : nums){
            records[num + 10000]++;
        }

        for(int i = 20000; i >= 0; i--){
            if(records[i] > 0){
                k -= records[i];
                if(k <= 0){
                    return i - 10000;
                }
            }
        }
        return 0;
    }
}