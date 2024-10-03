// class Solution {
//     public int minSubarray(int[] nums, int p) {
//         int total = 0;
//         for(int num: nums){
//             total = (total + num) % p;
//         }
//         if(total % p == 0){
//             return 0;
//         }
//         int rem = total;
//         Map<Integer, Integer> map = new HashMap<>();
//         int res = Integer.MAX_VALUE;
//         int curr = 0;
//         map.put(0, -1);
//         for(int i=0; i<nums.length; i++){
//             curr = (curr + nums[i]) % p;
//             int target = (curr - rem + p) % p;
//             if(map.containsKey(target)){
//                 res = Math.min(res, i-map.get(target));
//             }
//             map.put(curr, i);
//         }
//         return res < nums.length ? res : -1;
//     }
// }



class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        double sum = 0;
        for (int i : nums)
            sum += i;
        if (sum % p == 0.0)
            return 0;
        HashMap<Integer, Integer> mh = new HashMap<>();
        sum %= p;
        int s = (int)(sum);
        int len = n, mod = 0;
        for (int i = 0; i < n; i++) {
            if (len == 1)
                return 1;
            mod = (nums[i] + mod) % p;
            mh.put(mod, i);
            if (s == mod)
                len = Math.min(i + 1, len);
            if (mh.get((mod + p - s) % p) != null) 
                len = Math.min(len, i -  mh.get((mod + p - s) % p));
        }
        if(len==n)
            return -1;
        return len;
    }
}