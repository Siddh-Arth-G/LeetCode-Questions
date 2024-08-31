class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] rightSum = new int[nums.length];
        int[] leftSum = new int[nums.length];
        for(int i=1; i<leftSum.length; i++){
            leftSum[i] = leftSum[i-1] + nums[i-1];
        }
        for(int i=rightSum.length-2; i>=0; i--){
            rightSum[i] = rightSum[i+1] + nums[i+1];
        }
        int[] answer = new int[nums.length];
        for(int i=0; i<answer.length; i++){
            answer[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return answer;
    }
}