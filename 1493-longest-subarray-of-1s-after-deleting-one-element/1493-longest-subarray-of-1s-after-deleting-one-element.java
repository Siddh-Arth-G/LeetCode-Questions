class Solution {
    public int longestSubarray(int[] nums) {
        int zero = 0;
        int max = 0;
        int i = 0;
        int j = 0;
        while(j<nums.length){
            if(nums[j] == 0){
                zero++;
            }
            while(zero > 1){
                if(nums[i] == 0){
                    zero--;
                }
                i++;
            }
            max = Math.max(max, j-i);
            j++;
        }
        return max;
    }
}