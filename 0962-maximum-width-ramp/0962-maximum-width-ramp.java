// class Solution {
//     public int maxWidthRamp(int[] nums) {
//         int maxWidth = 0;
//         for (int i = 0; i < nums.length - 1; i++) {
//             for (int j = nums.length - 1; j > i; j--) {
//                 if (nums[j] >= nums[i]) {
//                     maxWidth = Math.max(maxWidth, j - i);
//                     break;
//                 }
//             }
//         }
//         return maxWidth;
//     }
// }





// class Solution {
//     public int maxWidthRamp(int[] nums) {
//         int n = nums.length;
//         int maxWidth = 0;
//         Stack<Integer> stack = new Stack<>();
//         for (int i = 0; i < n; i++) {
//             if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
//                 stack.push(i);
//             }
//         }

//         for (int j = n - 1; j >= 0; j--) {
//             while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
//                 maxWidth = Math.max(maxWidth, j - stack.pop());
//             }
//         }

//         return maxWidth;
//     }
// }





class Solution {
    public int maxWidthRamp(int[] nums) {
        int low = 1, high = nums.length-1, res = 0;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(possible(nums, mid)) {
                res = mid;
                low = mid + 1;
            } else high = mid - 1;
        }
        return res;
    }

    private boolean possible(int[] nums, int width) {
        int i=0,j=width;
        int min = nums[i];
        while(j < nums.length) {
            if(nums[j] >= min) return true;
            j++;
            min = Math.min(min, nums[++i]);
        }   
        return false;
    }
}