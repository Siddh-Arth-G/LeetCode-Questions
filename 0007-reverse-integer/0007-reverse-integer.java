class Solution {
    public int reverse(int x) {
        int val = x>0 ? x:-x;
        long res = 0;
        while(val > 0){
            int rem = val % 10;
            res = res*10 + rem;
            val /= 10;
        }
        if(res < Integer.MIN_VALUE || res > Integer.MAX_VALUE){
            return 0;
        }
        return (int)(res = x>0?res:-res);
    }
}