class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length == 1){
            return (double) nums[0];
        }
        long maxSum = 0;
        long sum = 0;
        for(int i=0; i<k; i++){
            sum += nums[i];
        }
        maxSum = sum;
        int i=0;
        int j = k;
        while(j<nums.length){
            sum  = sum - nums[i++] + nums[j++];
            maxSum = Math.max(maxSum, sum);
        }        
        return (double) maxSum/k;
    }
}