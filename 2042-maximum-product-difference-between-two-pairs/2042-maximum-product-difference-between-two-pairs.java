class Solution {
    public int maxProductDifference(int[] nums) {
        int [] arr1 = getminmax(nums);
        int [] arr2 = getminmax(nums);

        return (arr1[0] * arr2[0]) -(arr1[1] * arr2[1]);
    }
    int [] getminmax(int [] nums){
        int min = Integer.MAX_VALUE;
        int max = 0;
        int maxidx = 0;
        int minidx = 0;

        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=0){
                if(nums[i]>max) {
                    max = nums[i];
                    maxidx = i;
                }
                if(nums[i]<min){
                    min = nums[i];
                    minidx = i;
                }
            }
        }
        nums[maxidx] = 0;
        nums[minidx] = 0;
        return new int[]{max,min};
    }
    
}