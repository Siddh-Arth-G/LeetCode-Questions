class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        // long sum = 0;
        // for(int i=0; i<chalk.length; i++){
        //     sum += chalk[i];
        // }
        // long l = k;
        // while(l >= sum){
        //     l = l-sum;
        // }
        // for(int i=chalk.length-1; i>=0; i--){
        //     if(sum-chalk[i] <= l){
        //         return i;
        //     }else{
        //         sum = sum - chalk[i];
        //     }
        // }
        // return -1;
        
        
        

        // Second Solution
        
        // int ans = 0;
        // outer:
        // while(true){
        //     for(int i=0; i<chalk.length; i++){
        //         if(k>=chalk[i]){
        //             k -= chalk[i];
        //         }else{
        //             ans = i;
        //             break outer;
        //         }
        //     }
        // }
        // return ans;
        
        
        // Third solution
        long sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
            if (sum > k) {
                break;
            }
        }
        k = k % (int) sum;
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k = k - chalk[i];
        }
        return 0;
    }
}