class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] result = new int[2*nums.length];
        int len = nums.length;
        System.arraycopy(nums,0,result,0,len);
        System.arraycopy(nums,0,result,len,len);
        // for(int i= 0; i<result.length; i++){
        //     int j = i < nums.length ? i : i - nums.length;
        //     result[i] = nums[j];
        // }
        return result;
    }
}