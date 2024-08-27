class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] outcome = new int[101];
        int[] arr = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            outcome[nums[i]]++;
        }
        for(int i=1; i<=100; i++){
            outcome[i] += outcome[i-1];
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                arr[i] = 0;
            }else{
                arr[i] = outcome[nums[i]-1];
            }
        }
        return arr;
    }
}