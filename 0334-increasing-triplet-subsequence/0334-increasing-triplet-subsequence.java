// class Solution {
//     public boolean increasingTriplet(int[] nums) {
//         int size = nums.length;
//         if(size < 3){
//             return false;
//         }
//         int[] leftMin = new int[size];
//         int[] rightMax = new int[size];
//         leftMin[0] = nums[0];
//         for(int i=1; i<size; i++){
//             leftMin[i] = Math.min(leftMin[i-1], nums[i]);
//         }
//         rightMax[size-1] = nums[size-1];
//         for(int i=size-2; i>=0; i--){
//             rightMax[i] = Math.max(rightMax[i+1], nums[i]);
//         }
//         for(int i=0; i<size; i++){
//             if(leftMin[i] < nums[i] && nums[i] < rightMax[i]){
//                 return true;
//             }
//         }
//         return false;
//     }
// }


class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }

        return false;
    }
}