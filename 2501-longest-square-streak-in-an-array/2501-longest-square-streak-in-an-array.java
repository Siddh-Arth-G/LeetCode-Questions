// class Solution {
//     public int longestSquareStreak(int[] nums) {
//         Arrays.sort(nums);
//         Set<Integer> set = new HashSet<>();
//         for(int i: nums){
//             set.add(i);
//         }
//         int size = 0;
//         for(int i=0; i<nums.length; i++){
//             int temp = 1;
//             int val = nums[i];
//             while(set.contains(val*val)){
//                 temp++;
//                 val = val*val;
//             }
//             size = Math.max(size, temp);
//         }
//         return size < 2 ? -1 : size;
//     }
// }


// class Solution {

//     public int longestSquareStreak(int[] nums) {
//         // Map to store the length of square streak for each number
//         Map<Integer, Integer> streakLengths = new HashMap<>();

//         Arrays.sort(nums);

//         for (int number : nums) {
//             int root = (int) Math.sqrt(number);

//             // Check if the number is a perfect square and its square root is in the map
//             if (root * root == number && streakLengths.containsKey(root)) {
//                 // If so, extend the streak from its square root
//                 streakLengths.put(number, streakLengths.get(root) + 1);
//             } else {
//                 // Otherwise, start a new streak
//                 streakLengths.put(number, 1);
//             }
//         }

//         // Find the maximum streak length
//         int longestStreak = 0;
//         for (int streakLength : streakLengths.values()) {
//             longestStreak = Math.max(longestStreak, streakLength);
//         }

//         // Return -1 if no valid streak found, otherwise return the longest streak
//         return longestStreak == 1 ? -1 : longestStreak;
//     }
// }






public class Solution {
    public int longestSquareStreak(int[] nums) {
        int result = -1;
        final int max = 100000;
        boolean[] isExisted = new boolean[max + 1];
        boolean[] isVisited = new boolean[max + 1];
        for (int num : nums) {
            isExisted[num] = true;
        }
        for (int i = 2; i * i <= max; i++) {
            if (!isExisted[i] || isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            int length = 1;
            int j = i * i;
            while (j >= 0 && j <= max && isExisted[j]) {
                isVisited[j] = true;
                length++;
                j = j * j;
            }
            if (length > 1) {
                result = Math.max(result, length);
            }
        }
        return result;
    }
}