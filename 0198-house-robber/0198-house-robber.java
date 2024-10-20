class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] totalLoot = new int[nums.length];
        totalLoot[0] = nums[0];
        totalLoot[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++){
            totalLoot[i] = Math.max((totalLoot[i-2] + nums[i]), totalLoot[i-1]);
        }
        return totalLoot[nums.length-1];
    }
}