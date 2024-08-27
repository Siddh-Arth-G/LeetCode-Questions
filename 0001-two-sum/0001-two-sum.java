class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        
        for (int gap = 1; gap < length; gap++) {
            for (int right = gap; right < length; right++) {
                int left = right - gap;
                if (numbers[left] + numbers[right] == target) {
                    return new int[] {left, right};
                }
            }
        }
        return new int[0];
    }
}