class Solution {
    public String shortestPalindrome(String s) {
        int len = s.length();
        if(len == 0){
            return s;
        }
        int left = 0;
        for(int right = len-1; right >= 0; right--){
            if(s.charAt(left) == s.charAt(right)){
                left++;
            }
        }
        if(left == len){
            return s;
        }
        String nonPalin = s.substring(left);
        StringBuilder sb = new StringBuilder(nonPalin).reverse();
        
        return sb.append(shortestPalindrome(s.substring(0,left))).append(nonPalin).toString();
    }
}