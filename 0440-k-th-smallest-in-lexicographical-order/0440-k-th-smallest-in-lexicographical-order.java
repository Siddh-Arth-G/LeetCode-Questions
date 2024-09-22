class Solution {
    public int findKthNumber(int n, int k) {
        int output = 1;
        k--;
        while(k > 0){
            int steps = countSteps(output, n);
            if(steps <= k){
                k -= steps;
                output++;
            }else{
                output *= 10;
                k--;
            }
        }
        return output;
    }
    
    private int countSteps(int output, int n){
        long steps = 0;
        long first = output;
        long last = output;
        while(first <= n){
            steps += Math.min(last, n) - first + 1;
            first *= 10;
            last = last * 10 + 9;
        }
        return (int) steps;
    }
}