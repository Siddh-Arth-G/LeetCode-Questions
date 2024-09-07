class Solution {
    public int majorityElement(int[] nums) {
       int ele;
       int count = 1;
         ele = nums[0];
       for(int i=1; i<nums.length; i++){
        if(count==0){
            ele = nums[i];
            count++;
        }else if(ele == nums[i]){
            count++; 
        }else{
            count--;
        }
       }
       return ele;
    }
}