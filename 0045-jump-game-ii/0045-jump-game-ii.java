class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int dest = nums.length-1;
        int coverage = 0;
        int lastIndex = 0;
        if(nums.length == 1){
            return 0;
        }
        
        for(int i=0; i< nums.length; i++){
            coverage = Math.max(coverage, i+nums[i]);
            
            if(i==lastIndex){
                lastIndex = coverage;
                jumps++;
                
                if(coverage >= dest){
                    return jumps;
                }
            }
        }
        return -1;
    }
}