class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int n = nums.length;
        
        //LEFT ans
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        
       //RIGHT rt
        int rt = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * rt;
            rt = rt * nums[i];
        }
        
        return ans;
    }
}