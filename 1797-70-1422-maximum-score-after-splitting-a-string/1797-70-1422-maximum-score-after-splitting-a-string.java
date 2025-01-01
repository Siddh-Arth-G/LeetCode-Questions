class Solution {
    public int maxScore(String s) {
        int zero =0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '0'){
                zero++;
            }
        }
        int max = 0;
        int one = 0;
        for(int i=(s.length()-1); i>0; i--){
            if(s.charAt(i) == '0'){
                zero--;
            }else {
                one++;
            }
            max = Math.max(max, zero + one);
        }
        return max;
    }
}