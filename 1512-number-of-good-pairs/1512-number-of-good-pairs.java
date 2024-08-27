class Solution {
    public int numIdenticalPairs(int[] nums) {
       int[] freq = new int[101];

       for(int i=0 ; i<nums.length; i++){
        freq[nums[i]] += 1;
       } 

       int ans = 0;

       for(int i=0 ; i<freq.length ; i++){
            if(freq[i]>0){
                int n = freq[i];
                ans = ans + (n*(n-1) / 2);
            }
       }
       return ans;
    }
}