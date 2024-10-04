class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        if(prefix[n-1] - prefix[0] == 0){
            return 0;
        }
        int sum = prefix[n-1];
        for(int i=1; i<n; i++){
            int temp = sum - prefix[i-1];
            if(temp == prefix[i]){
                return i;
            }
        }
        return -1;
    }
}