class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int num = x;
        int y = 0;
        while(num>0){
            int rem = num%10;
            y = y*10 + rem;
            num /= 10;
        }
        
        return y==x;
    }
}