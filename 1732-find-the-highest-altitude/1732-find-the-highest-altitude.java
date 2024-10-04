class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int val = gain[0];
        if(val > max){
            max = val;
        }
        for(int i=1; i<gain.length; i++){
            val = val + gain[i];
            if(val > max){
                max = val; 
            }
        }
        return max;
    }
}