class Solution {
    public int majorityElement(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        for(Integer val: set){
            int count = 0;
            for(int i=0; i<nums.length; i++){
                if(val == nums[i]){
                    count++;
                }
            }
            if(count > nums.length/2){
                return val;
            }
        }
        return -1;
    }
}