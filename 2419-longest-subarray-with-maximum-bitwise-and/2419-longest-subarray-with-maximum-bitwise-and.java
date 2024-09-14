class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int max=0;
        int c=0,c1=0;
        for(int i=0;i<n;i++)
        {
            if(max<nums[i])
            max=nums[i];
        }
        for(int i=0;i<n;i++)
        {
            if(max==nums[i])
            {
                c1++;
                c=Math.max(c,c1);
            }
                else
                c1=0;
            
        }
        return c;
    }
}