class Solution {
    public int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        int len2 = len/2;
        int[] shuffle = new int[len];
        int num=0;
        for(int i=0; i<len; i++){
            if(i%2 == 0){
                shuffle[i] = nums[num];
                num++;
            } else{
                shuffle[i] = nums[len2];
                len2++;
            }
        }
        return shuffle;
    }
}